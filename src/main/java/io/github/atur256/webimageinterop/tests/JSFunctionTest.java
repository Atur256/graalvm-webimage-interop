package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.tests.testUtils.CustomClass;
import io.github.atur256.webimageinterop.tests.testUtils.Pair;
import io.github.atur256.webimageinterop.tests.testUtils.Triple;
import org.graalvm.webimage.api.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;


public class JSFunctionTest {

    public static void main(String[] args) {
        testFromBody();
        testFromArgs();
        testGeneralFunction();
        testBiFunction();
        testTriFunction();
        testRunnableAndConsumer();
        testBiConsumer();
        testTriConsumer();
        testSupplier();
        testCallJS();
        testCall();
        testCallWithSpreadArgs();
        testApply();
        testBind();
        testMetadata();
    }

    public static void testFromBody() {
        JSFunction fun = JSFunction.fromBody("return 'Hello ' + arg;");

        String result = fun.callJS("Alice", String.class);

        assertEquals("Hello Alice", result);
    }

    public static void testFromArgs() {
        JSFunction fun = JSFunction.fromArgs("a", "b", "return a + b;");

        int result = fun.applyJS(null, JSArray.of(JSNumber.of(5), JSNumber.of(7)), Integer.class);

        assertEquals(12, result);
    }

    public static void testGeneralFunction() {
        JSFunction fun1 = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);
        JSFunction fun2 = JSFunction.fromGeneralFunction((Integer arg) -> arg * 10);
        JSFunction fun3 = JSFunction.fromGeneralFunction((Double arg) -> arg * arg);
        JSFunction fun4 = JSFunction.fromGeneralFunction((Boolean arg) -> !arg);
        JSFunction fun5 = JSFunction.fromGeneralFunction((Long arg) -> arg / 10);
        JSFunction fun6 = JSFunction.fromGeneralFunction((CustomClass arg) ->
                new CustomClass("Hello " + arg.name() + "!"));

        String result1 = fun1.call("Alice");
        int result2 = fun2.call(42);
        double result3 = fun3.call(3.5);
        boolean result4 = fun4.call(true);
        long result5 = fun5.call(1234567890123L);
        CustomClass result6 = fun6.call(new CustomClass("Alice"));

        assertEquals("Hello, Alice", result1);
        assertEquals(420, result2);
        assertEquals(12.25, result3, 0.0);
        assertFalse(result4);
        assertEquals(123456789012L, result5);
        assertEquals("Hello Alice!", result6.name());
    }

    public static void testBiFunction() {
        JSFunction fun1 = JSFunction.fromGeneralBiFunction((String name, Integer age) ->
                "Name: " + name + ", Age: " + age);
        JSFunction fun2 = JSFunction.fromGeneralBiFunction((Double x, Double y) -> x * y);
        JSFunction fun3 = JSFunction.fromBiFunction((JSString name, JSNumber age) ->
                JSString.of(name.as(String.class) + " is " + age.as(Integer.class) + " years old."));

        String result1 = fun1.call("Bob", 30);
        double result2 = fun2.call(6.0, 7.0);
        String result3 = JSValue.checkedCoerce(fun3.call(JSString.of("Alice"), JSNumber.of(25)), String.class);

        assertEquals("Name: Bob, Age: 30", result1);
        assertEquals(42.0, result2, 0.0);
        assertEquals("Alice is 25 years old.", result3);
    }

    public static void testTriFunction() {
        JSFunction fun1 = JSFunction.fromGeneralTriFunction((String name, Integer age, Boolean vip) ->
                "Name: " + name + ", Age: " + age + ", VIP: " + (vip ? "Yes" : "No"));
        JSFunction fun2 = JSFunction.fromTriFunction((JSString name, JSNumber age, JSBoolean vip) -> {
            String result = name.as(String.class) + " (" + age.as(Integer.class) + ")";
            if(vip.as(Boolean.class)) result += " [VIP]";
            return JSString.of(result);
        });

        String result1 = (String) fun1.call("Charlie", 28, true);
        String result2 = JSValue.checkedCoerce(
                fun2.call(JSString.of("Dana"), JSNumber.of(35), JSBoolean.of(true))
                , String.class);

        assertEquals("Name: Charlie, Age: 28, VIP: Yes", result1);
        assertEquals("Dana (35) [VIP]", result2);
    }

    public static void testRunnableAndConsumer() {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<String> captured1 = new AtomicReference<>();
        AtomicReference<Integer> captured2 = new AtomicReference<>();
        AtomicReference<Double> captured3 = new AtomicReference<>();
        AtomicReference<Boolean> captured4 = new AtomicReference<>();
        AtomicReference<CustomClass> captured5 = new AtomicReference<>();
        JSFunction runner = JSFunction.fromRunnable(latch::countDown);
        JSFunction con1 = JSFunction.fromGeneralConsumer(captured1::set);
        JSFunction con2 = JSFunction.fromGeneralConsumer(captured2::set);
        JSFunction con3 = JSFunction.fromGeneralConsumer(captured3::set);
        JSFunction con4 = JSFunction.fromGeneralConsumer(captured4::set);
        JSFunction con5 = JSFunction.fromGeneralConsumer(captured5::set);

        runner.call();
        con1.call("Hello");
        con2.call(42);
        con3.call(3.14);
        con4.call(true);
        con5.call(new CustomClass("Alice"));

        assertEquals(0, latch.getCount());
        assertEquals("Hello", captured1.get());
        assertEquals(Integer.valueOf(42), captured2.get());
        assertEquals(3.14, captured3.get(), 0.0);
        assertTrue(captured4.get());
        assertEquals(new CustomClass("Alice"), captured5.get());
    }

    public static void testBiConsumer() {
        AtomicReference<Pair<String, String>> captured1 = new AtomicReference<>();
        AtomicReference<Pair<String, Integer>> captured2 = new AtomicReference<>();
        AtomicReference<Pair<CustomClass, CustomClass>> captured3 = new AtomicReference<>();
        JSFunction con1 = JSFunction.fromGeneralBiConsumer((String a, String b) ->
                captured1.set(Pair.of(a, b)));
        JSFunction con2 = JSFunction.fromGeneralBiConsumer((String label, Integer value) ->
                captured2.set(Pair.of(label, value)));
        JSFunction con3 = JSFunction.fromGeneralBiConsumer((CustomClass a, CustomClass b) ->
                captured3.set(Pair.of(a, b)));

        con1.call("Hello", "World");
        con2.call("Age", 30);
        con3.call(new CustomClass("Alice"), new CustomClass("Bob"));

        assertEquals("Hello", captured1.get().a());
        assertEquals("World", captured1.get().b());
        assertEquals("Age", captured2.get().a());
        assertEquals(Integer.valueOf(30), captured2.get().b());
        assertEquals(new CustomClass("Alice"), captured3.get().a());
        assertEquals(new CustomClass("Bob"), captured3.get().b());
    }

    public static void testTriConsumer() {
        AtomicReference<Triple<String, String, String>> captured1 = new AtomicReference<>();
        AtomicReference<Triple<String, Integer, Double>> captured2 = new AtomicReference<>();
        AtomicReference<Triple<CustomClass, CustomClass, CustomClass>> captured3 = new AtomicReference<>();
        JSFunction con1 = JSFunction.fromGeneralTriConsumer((String a, String b, String c) ->
                captured1.set(Triple.of(a, b, c)));
        JSFunction con2 = JSFunction.fromGeneralTriConsumer((String label, Integer value1, Double value2) ->
                captured2.set(Triple.of(label, value1, value2)));
        JSFunction con3 = JSFunction.fromGeneralTriConsumer((CustomClass a, CustomClass b, CustomClass c) ->
                captured3.set(Triple.of(a, b, c)));

        con1.call("Hello", "World", "!");
        con2.call("Age and Height", 30, 186.35);
        con3.call(new CustomClass("Alice"), new CustomClass("Bob"), new CustomClass("Anna"));

        assertEquals("Hello", captured1.get().a());
        assertEquals("World", captured1.get().b());
        assertEquals("!", captured1.get().c());
        assertEquals("Age and Height", captured2.get().a());
        assertEquals(Integer.valueOf(30), captured2.get().b());
        assertEquals(186.35, captured2.get().c(), 0.0);
        assertEquals(new CustomClass("Alice"), captured3.get().a());
        assertEquals(new CustomClass("Bob"), captured3.get().b());
        assertEquals(new CustomClass("Anna"), captured3.get().c());
    }

    public static void testSupplier() {
        JSFunction sup1 = JSFunction.fromSupplier(() -> "Supplied string");
        JSFunction sup2 = JSFunction.fromSupplier(() -> 42);
        JSFunction sup3 = JSFunction.fromSupplier(() -> 3.14);
        JSFunction sup4 = JSFunction.fromSupplier(() -> true);
        JSFunction sup5 = JSFunction.fromSupplier(() -> new CustomClass("Alice"));

        String result1 = sup1.call();
        int result2 = sup2.call();
        double result3 = sup3.call();
        boolean result4 = sup4.call();
        CustomClass result5 = sup5.call();

        assertEquals("Supplied string", result1);
        assertEquals(42, result2);
        assertEquals(3.14, result3, 0.0);
        assertTrue(result4);
        assertEquals("Alice", result5.name());
    }

    public static void testCallJS() {
        JSFunction fun1 = JSFunction.fromBody("return typeof arg + ': ' + arg;");
        JSFunction fun2 = JSFunction.fromBody("return arg + 2;");
        JSFunction fun3 = JSFunction.fromBody("return !arg;");
        JSValue jsStr = JSString.of("JSValue string");

        String result1 = fun1.callJS("Hello", String.class);
        int result2 = fun2.callJS(42, Integer.class);
        double result3 = fun2.callJS(3.14, Double.class);
        boolean result4 = fun3.callJS(true, Boolean.class);
        String result5 = fun1.callJS(jsStr, String.class);

        assertEquals("string: Hello", result1);
        assertEquals(44, result2);
        assertEquals(5.14, result3, 0.001);
        assertFalse(result4);
        assertEquals("string: JSValue string", result5);
    }

    public static void testCall() {
        JSValue jsValue = JSString.of("JSValue string");
        JSFunction fun1 = JSFunction.fromGeneralFunction(arg ->
                arg == null ? "null: null" : arg.getClass().getSimpleName() + ": " + arg);
        JSFunction fun2 = JSFunction.fromSupplier(() -> "No args called");
        JSFunction fun3 = JSFunction.fromGeneralBiFunction((String prefix, Object arg) ->
                arg == null ? "null: null" : prefix + arg.getClass().getSimpleName() + ": " + arg);

        String result1 = fun1.call("Java string");
        String result2 = fun1.call(42);
        String result3 = fun1.call(3.14);
        String result4 = fun1.call(true);
        String result5 = fun1.call(null);
        String result6 = fun1.call(new CustomClass("Alice"));
        String result7 = fun1.call(jsValue);
        String result8 = fun2.call();
        String result9 = fun3.call("Prefix: ", "Java string");

        assertEquals("String: Java string", result1);
        assertEquals("Integer: 42", result2);
        assertEquals("Double: 3.14", result3);
        assertEquals("Boolean: true", result4);
        assertEquals("null: null", result5);
        assertEquals("CustomClass: CustomClass(Alice)", result6);
        assertEquals("JSString: JavaScript<string; JSValue string>", result7);
        assertEquals("No args called", result8);
        assertEquals("Prefix: String: Java string", result9);
    }

    public static void testCallWithSpreadArgs() {
        JSArray args = JSArray.of(6, 7);
        JSFunction fun1 = JSFunction.fromArgs("a", "b", "return a * b;");
        JSFunction fun2 = JSFunction.fromArgs("a", "b", "return a + ' - ' + b;");
        JSFunction fun3 = JSFunction.fromGeneralBiFunction((JSString prefix, JSString message) ->
                prefix.as(String.class) + " - " + message.as(String.class));

        int result1 = JSValue.checkedCoerce(fun1.callWithSpreadArgs(JSValue.undefined(), args), Integer.class);
        String result2 = JSValue.checkedCoerce(fun2.callWithSpreadArgs(JSValue.undefined(), "Hello", "World"), String.class);
        String result3 = fun3.callWithSpreadArgs(JSValue.undefined(), "Hello", "World");

        assertEquals(42, result1);
        assertEquals("Hello - World", result2);
        assertEquals("Hello - World", result3);
    }

    public static void testApply() {
        JSArray args = JSArray.of("JSString", 3.14, true);
        JSFunction fun1 = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg + "!");
        JSFunction fun2 = JSFunction.fromGeneralFunction((Integer arg) -> "Number: " + arg);
        JSFunction jsFormatter = JSFunction.fromArgs("a", "b", "c", "return a + ' | ' + b + ' | ' + c;");

        String result1 = JSValue.checkedCoerce(jsFormatter.apply(JSValue.undefined(), args), String.class);
        String result2 = JSValue.checkedCoerce(jsFormatter.apply(null, "JavaString", 42, false), String.class);
        String result3 = JSValue.checkedCoerce(jsFormatter.applyGeneral(JSValue.undefined(), args), String.class);
        String result4 = JSValue.checkedCoerce(jsFormatter.applyRaw("RawPrefix", "RawString", 99, true), String.class);
        String result5 = JSValue.checkedCoerce(fun1.apply(null, "Alice"), String.class);
        String result6 = JSValue.checkedCoerce(fun2.apply(null, 20), String.class);

        assertEquals("JSString | 3.14 | true", result1);
        assertEquals("[Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]", result2);
        assertEquals("JSString | 3.14 | true", result3);
        assertEquals("[Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]", result4);
        assertEquals("Hello, Alice!", result5);
        assertEquals("Number: 20", result6);
    }

    public static void testBind() {
        JSObject context = JSObject.create();
        context.set("prefix", JSString.of("Hello "));
        JSFunction fun1 = JSFunction.fromArgs("name", "return this + name;");
        JSFunction fun2 = JSFunction.fromArgs("name", "return this.prefix + name;");

        String result1 = fun1.bind(JSString.of("JSValue: ")).callJS("Alice", String.class);
        String result2 = fun1.bind(123).callJS("Bob", String.class);
        String result3 = fun1.bind(3.14).callJS("Charlie", String.class);
        String result4 = fun1.bind(true).callJS("Dana", String.class);
        String result5 = fun1.bind("Custom: ").callJS("Eve", String.class);
        String result6 = fun2.bind(context).callJS("Frank", String.class);

        assertEquals("JSValue: Alice", result1);
        assertEquals("123Bob", result2);
        assertEquals("3.14Charlie", result3);
        assertEquals("trueDana", result4);
        assertEquals("Custom: Eve", result5);
        assertEquals("Hello Frank", result6);
    }

    public static void testMetadata() {
        JSFunction fun1 = JSFunction.fromArgs("x", "y", "z", "return x + y + z;");
        JSFunction fun2 = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);

        int result1 = fun1.length;
        int result2 = fun2.length;
        String result3 = fun1.name;
        String result4 = fun2.prototype.toString();
        String result5 = fun1.toString();
        String result6 = fun2.toString();

        assertEquals(3, result1);
        assertEquals(1, result2);
        assertEquals("anonymous", result3);
        assertEquals("JavaScript<object; [object Object]>", result4);
        assertEquals("""
                <JavaScript<function; function anonymous(x,y,z
                ) {
                return x + y + z;
                }>""", result5);
        assertEquals("<JavaScript<function; function(args) { return javaFunc.apply(args); }>", result6);
    }
}