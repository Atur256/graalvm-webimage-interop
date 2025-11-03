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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class JSFunctionTest {

    public static void main(String[] args) {

        testFromBody();
        testFromArgs();
        testFunction();
        testBiFunction();
        testTriFunction();
        testRunnableAndConsumer();
        testBiConsumer();
        testTriConsumer();
        testSupplier();
        testThisFunc();
        testFuncWithThis();
        testBiFuncWithThis();
        testThisCons();
        testConsWithThis();
        testBiConsWithThis();
        testCall();
        testCallJS();
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

        int result = fun.applyJS(null, Integer.class, JSNumber.of(5), JSNumber.of(7));

        assertEquals(12, result);
    }

    public static void testFunction() {
        JSFunction fun1 = JSFunction.fromFunc((String arg) -> "Hello, " + arg);
        JSFunction fun2 = JSFunction.fromFunc((Integer arg) -> arg * 10);
        JSFunction fun3 = JSFunction.fromFunc((Double arg) -> arg * arg);
        JSFunction fun4 = JSFunction.fromFunc((Boolean arg) -> !arg);
        JSFunction fun5 = JSFunction.fromFunc((Long arg) -> arg / 10);
        JSFunction fun6 = JSFunction.fromFunc((CustomClass arg) ->
                new CustomClass("Hello " + arg.name() + "!"));
        JSFunction fun7 = JSFunction.fromJSFunc((JSString arg) -> JSString.of("Hello, " + arg.asString()));
        JSFunction fun8 = JSFunction.fromJSFunc((JSNumber arg) -> JSNumber.of(arg.asInt() * 10));
        JSFunction fun9 = JSFunction.fromJSFunc((JSBoolean arg) -> JSBoolean.of(!arg.asBoolean()));
        JSFunction fun10 = JSFunction.fromJSFunc((JSObject raw) -> {
            JSArray arg = JSValue.checkedCoerce(raw, JSArray.class);
            int sum = 0;
            for(int i = 0; i < arg.length; i++) {
                sum += arg.at(i, Integer.class);
            }
            return JSNumber.of(sum);
        });

        String result1 = fun1.call("Alice");
        int result2 = fun2.call(42);
        double result3 = fun3.call(3.5);
        boolean result4 = fun4.call(true);
        long result5 = fun5.call(1234567890123L);
        CustomClass result6 = fun6.call(new CustomClass("Alice"));
        String result7 = fun7.callJS(JSString.of("Alice"), String.class);
        int result8 = fun8.callJS(JSNumber.of(42), Integer.class);
        boolean result9 = fun9.callJS(JSBoolean.of(true), Boolean.class);
        int result10 = fun10.callJS(JSArray.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), Integer.class);

        assertEquals("Hello, Alice", result1);
        assertEquals(420, result2);
        assertEquals(12.25, result3, 0.0);
        assertFalse(result4);
        assertEquals(123456789012L, result5);
        assertEquals("Hello Alice!", result6.name());
        assertEquals("Hello, Alice", result7);
        assertEquals(420, result8);
        assertFalse(result9);
        assertEquals(55, result10);
    }

    public static void testBiFunction() {
        JSFunction fun1 = JSFunction.fromBiFunc((String name, Integer age) ->
                "Name: " + name + ", Age: " + age);
        JSFunction fun2 = JSFunction.fromBiFunc((Double x, Double y) -> x * y);
        JSFunction fun3 = JSFunction.fromJSBiFunc((JSString name, JSNumber age) ->
                JSString.of(name.as(String.class) + " is " + age.as(Integer.class) + " years old."));

        String result1 = fun1.call("Bob", 30);
        double result2 = fun2.call(6.0, 7.0);
        String result3 = fun3.callJS(JSString.of("Alice"), JSNumber.of(25), String.class);

        assertEquals("Name: Bob, Age: 30", result1);
        assertEquals(42.0, result2, 0.0);
        assertEquals("Alice is 25 years old.", result3);
    }

    public static void testTriFunction() {
        JSFunction fun1 = JSFunction.fromTriFunc((String name, Integer age, Boolean vip) ->
                "Name: " + name + ", Age: " + age + ", VIP:" + (vip ? " Yes" : " No"));
        JSFunction fun2 = JSFunction.fromJSTriFunc((JSString name, JSNumber age, JSBoolean vip) -> {
            String result = name.as(String.class) + " (" + age.as(Integer.class) + ")";
            if(vip.as(Boolean.class)) result += " [VIP]";
            return JSString.of(result);
        });

        String result1 = fun1.call("Charlie", 28, true);
        String result2 = fun2.callJS(JSString.of("Dana"), JSNumber.of(35), JSBoolean.of(true), String.class);

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
        AtomicReference<JSString> captured6 = new AtomicReference<>();
        AtomicReference<JSNumber> captured7 = new AtomicReference<>();
        AtomicReference<JSBoolean> captured8 = new AtomicReference<>();
        JSFunction runner = JSFunction.fromRun(latch::countDown);
        JSFunction con1 = JSFunction.fromCons(captured1::set);
        JSFunction con2 = JSFunction.fromCons(captured2::set);
        JSFunction con3 = JSFunction.fromCons(captured3::set);
        JSFunction con4 = JSFunction.fromCons(captured4::set);
        JSFunction con5 = JSFunction.fromCons(captured5::set);
        JSFunction con6 = JSFunction.fromJSCons(captured6::set);
        JSFunction con7 = JSFunction.fromJSCons(captured7::set);
        JSFunction con8 = JSFunction.fromJSCons(captured8::set);

        runner.call();
        con1.call("Hello");
        con2.call(42);
        con3.call(3.14);
        con4.call(true);
        con5.call(new CustomClass("Alice"));
        con6.callJS(JSString.of("Hello"));
        con7.callJS(JSNumber.of(42));
        con8.callJS(JSBoolean.of(false));

        assertEquals(0, latch.getCount());
        assertEquals("Hello", captured1.get());
        assertEquals(Integer.valueOf(42), captured2.get());
        assertEquals(3.14, captured3.get(), 0.0);
        assertTrue(captured4.get());
        assertEquals(new CustomClass("Alice"), captured5.get());
        assertEquals("Hello", captured6.get().asString());
        assertEquals(Integer.valueOf(42), captured7.get().asInt());
        assertFalse(captured8.get().asBoolean());
    }

    public static void testBiConsumer() {
        AtomicReference<Pair<String, String>> captured1 = new AtomicReference<>();
        AtomicReference<Pair<String, Integer>> captured2 = new AtomicReference<>();
        AtomicReference<Pair<CustomClass, CustomClass>> captured3 = new AtomicReference<>();
        AtomicReference<Pair<JSString, JSString>> captured4 = new AtomicReference<>();
        AtomicReference<Pair<JSString, JSNumber>> captured5 = new AtomicReference<>();
        AtomicReference<Pair<JSString, JSBoolean>> captured6 = new AtomicReference<>();
        JSFunction con1 = JSFunction.fromBiCons((String a, String b) ->
                captured1.set(Pair.of(a, b)));
        JSFunction con2 = JSFunction.fromBiCons((String label, Integer value) ->
                captured2.set(Pair.of(label, value)));
        JSFunction con3 = JSFunction.fromBiCons((CustomClass a, CustomClass b) ->
                captured3.set(Pair.of(a, b)));
        JSFunction con4 = JSFunction.fromJSBiCons((JSString a, JSString b) ->
                captured4.set(Pair.of(a, b)));
        JSFunction con5 = JSFunction.fromJSBiCons((JSString label, JSNumber value) ->
                captured5.set(Pair.of(label, value)));
        JSFunction con6 = JSFunction.fromJSBiCons((JSString label, JSBoolean value) ->
                captured6.set(Pair.of(label, value)));

        con1.call("Hello", "World");
        con2.call("Age", 30);
        con3.call(new CustomClass("Alice"), new CustomClass("Bob"));
        con4.callJS(JSString.of("Hello"), JSString.of("World"));
        con5.callJS(JSString.of("Age"), JSNumber.of(30));
        con6.callJS(JSString.of("VIP"), JSBoolean.of(true));

        assertPair(captured1.get(), "Hello", "World");
        assertPair(captured2.get(), "Age", 30);
        assertPair(captured3.get(), new CustomClass("Alice"), new CustomClass("Bob"));
        assertPair(captured4.get(), JSString.of("Hello"), JSString.of("World"));
        assertPair(captured5.get(), JSString.of("Age"), JSNumber.of(30));
        assertPair(captured6.get(), JSString.of("VIP"), JSBoolean.of(true));
    }

    public static void testTriConsumer() {
        AtomicReference<Triple<String, String, String>> captured1 = new AtomicReference<>();
        AtomicReference<Triple<String, Integer, Double>> captured2 = new AtomicReference<>();
        AtomicReference<Triple<CustomClass, CustomClass, CustomClass>> captured3 = new AtomicReference<>();
        AtomicReference<Triple<JSString, JSString, JSString>> captured4 = new AtomicReference<>();
        AtomicReference<Triple<JSString, JSNumber, JSBoolean>> captured5 = new AtomicReference<>();
        JSFunction con1 = JSFunction.fromTriCons((String a, String b, String c) ->
                captured1.set(Triple.of(a, b, c)));
        JSFunction con2 = JSFunction.fromTriCons((String label, Integer value1, Double value2) ->
                captured2.set(Triple.of(label, value1, value2)));
        JSFunction con3 = JSFunction.fromTriCons((CustomClass a, CustomClass b, CustomClass c) ->
                captured3.set(Triple.of(a, b, c)));
        JSFunction con4 = JSFunction.fromJSTriCons((JSString a, JSString b, JSString c) ->
                captured4.set(Triple.of(a, b, c)));
        JSFunction con5 = JSFunction.fromJSTriCons((JSString label, JSNumber value1, JSBoolean value2) ->
                captured5.set(Triple.of(label, value1, value2)));

        con1.call("Hello", "World", "!");
        con2.call("Age and Height", 30, 186.35);
        con3.call(new CustomClass("Alice"), new CustomClass("Bob"), new CustomClass("Anna"));
        con4.callJS(JSString.of("Hello"), JSString.of("World"), JSString.of("!"));
        con5.callJS(JSString.of("Age and VIP status"), JSNumber.of(186.35), JSBoolean.of(true));

        assertTriple(captured1.get(), "Hello", "World", "!");
        assertTriple(captured2.get(), "Age and Height", 30, 186.35);
        assertTriple(captured3.get(),
                new CustomClass("Alice"), new CustomClass("Bob"), new CustomClass("Anna"));
        assertTriple(captured4.get(), JSString.of("Hello"), JSString.of("World"), JSString.of("!"));
        assertTriple(captured5.get(),
                JSString.of("Age and VIP status"), JSNumber.of(186.35), JSBoolean.of(true));
    }

    public static void testSupplier() {
        JSFunction sup1 = JSFunction.fromSupp(() -> "Supplied string");
        JSFunction sup2 = JSFunction.fromSupp(() -> 42);
        JSFunction sup3 = JSFunction.fromSupp(() -> 3.14);
        JSFunction sup4 = JSFunction.fromSupp(() -> true);
        JSFunction sup5 = JSFunction.fromSupp(() -> new CustomClass("Alice"));

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

    public static void testThisFunc() {
        TestObject testObject = new TestObject(1234);
        TestJSObject testJSObject = new TestJSObject(1234);
        JSFunction fun1 = JSFunction.fromThisFunc((Object this_) ->
                "Value of this_.value: " + ((TestObject) this_).value);
        JSFunction fun2 = JSFunction.fromThisJSFunc((JSObject this_) ->
                JSString.of("Value of this_.value: " + JSValue.checkedCoerce(this_.get("value"), Integer.class)));

        String result1 = fun1.apply(testObject);
        String result2 = fun2.applyJS(testJSObject, String.class);

        assertEquals("Value of this_.value: 1234", result1);
        assertEquals("Value of this_.value: 1234", result2);
    }

    public static void testFuncWithThis() {
        TestObject testObject = new TestObject(42);
        TestJSObject testJSObject = new TestJSObject(25);
        JSFunction fun1 = JSFunction.fromFuncWithThis((Object this_, Integer arg) ->
                "Value of this_.value * arg: " + ((TestObject) this_).value * arg);
        JSFunction fun2 = JSFunction.fromJSFuncWithThis((JSObject this_, JSNumber arg) ->
                JSString.of("Value of this_.value * arg: " +
                        JSValue.checkedCoerce(this_.get("value"), Integer.class) * arg.asInt()));

        String result1 = fun1.apply(testObject, 5);
        String result2 = fun2.applyJS(testJSObject, String.class, JSNumber.of(5));

        assertEquals("Value of this_.value * arg: 210", result1);
        assertEquals("Value of this_.value * arg: 125", result2);
    }


    public static void testBiFuncWithThis() {
        TestObject testObject = new TestObject(42);
        TestJSObject testJSObject = new TestJSObject(25);
        JSFunction fun1 = JSFunction.fromBiFuncWithThis((Object this_, Integer arg1, Integer arg2) ->
                "Value of this_.value * arg1 + arg2: " + (((TestObject) this_).value * arg1 + arg2));
        JSFunction fun2 = JSFunction.fromJSBiFuncWithThis((JSObject this_, JSNumber arg1, JSNumber arg2) ->
                JSString.of("Value of this_.value * arg1 + arg2: " +
                        ((JSValue.checkedCoerce(this_.get("value"), Integer.class)) * arg1.asInt() + arg2.asInt())));

        String result1 = fun1.apply(testObject, 5, 5);
        String result2 = fun2.applyJS(testJSObject, String.class, JSNumber.of(5), JSNumber.of(10));

        assertEquals("Value of this_.value * arg1 + arg2: 215", result1);
        assertEquals("Value of this_.value * arg1 + arg2: 135", result2);
    }

    public static void testThisCons() {
        AtomicReference<Integer> captured1 = new AtomicReference<>();
        AtomicReference<Integer> captured2 = new AtomicReference<>();
        TestObject testObject = new TestObject(1234);
        TestJSObject testJSObject = new TestJSObject(10);
        JSFunction fun1 = JSFunction.fromThisCons((Object this_) ->
                captured1.set(((TestObject) this_).value));
        JSFunction fun2 = JSFunction.fromThisJSCons((JSObject this_) ->
                captured2.set(JSValue.checkedCoerce(this_.get("value"), Integer.class)));

        fun1.apply(testObject);
        fun2.applyJS(testJSObject);

        assertEquals(Integer.valueOf(1234), captured1.get());
        assertEquals(Integer.valueOf(10), captured2.get());
    }

    public static void testConsWithThis() {
        AtomicReference<Pair<Object, Integer>> captured1 = new AtomicReference<>();
        AtomicReference<Pair<JSObject, JSNumber>> captured2 = new AtomicReference<>();
        TestObject testObject = new TestObject(42);
        TestJSObject testJSObject = new TestJSObject(25);
        JSFunction fun1 = JSFunction.fromConsWithThis((Object this_, Integer arg) ->
                captured1.set(Pair.of(this_, arg)));
        JSFunction fun2 = JSFunction.fromJSConsWithThis((JSObject this_, JSNumber arg) ->
                captured2.set(Pair.of(this_, arg)));

        fun1.apply(testObject, 5);
        fun2.applyJS(testJSObject, JSNumber.of(10));

        assertPair(captured1.get(), testObject, 5);
        assertPair(captured2.get(), testJSObject, JSNumber.of(10));
    }

    public static void testBiConsWithThis() {
        AtomicReference<Triple<Object, Integer, Integer>> captured1 = new AtomicReference<>();
        AtomicReference<Triple<JSObject, JSNumber, JSNumber>> captured2 = new AtomicReference<>();
        TestObject testObject = new TestObject(42);
        TestJSObject testJSObject = new TestJSObject(25);
        JSFunction fun1 = JSFunction.fromBiConsWithThis((Object this_, Integer arg1, Integer arg2) ->
                captured1.set(Triple.of(this_, arg1, arg2)));
        JSFunction fun2 = JSFunction.fromJSBiConsWithThis((JSObject this_, JSNumber arg1, JSNumber arg2) ->
                captured2.set(Triple.of(this_, arg1, arg2)));

        fun1.apply(testObject, 5, 5);
        fun2.applyJS(testJSObject, JSNumber.of(5), JSNumber.of(10));

        assertTriple(captured1.get(), testObject, 5, 5);
        assertTriple(captured2.get(), testJSObject, JSNumber.of(5), JSNumber.of(10));
    }

    public static void testCall() {
        JSValue jsValue = JSString.of("JSValue string");
        JSFunction fun1 = JSFunction.fromFunc(arg ->
                arg == null ? "null: null" : arg.getClass().getSimpleName() + ": " + arg);
        JSFunction fun2 = JSFunction.fromSupp(() -> "No args called");
        JSFunction fun3 = JSFunction.fromBiFunc((String prefix, Object arg) ->
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

    public static void testCallJS() {
        JSFunction fun1 = JSFunction.fromBody("return typeof arg + ': ' + arg;");
        JSFunction fun2 = JSFunction.fromBody("return arg + 2;");
        JSFunction fun3 = JSFunction.fromBody("return !arg;");
        JSFunction fun4 = JSFunction.fromBody("return \"No args called\";");
        JSValue jsStr = JSString.of("JSValue string");

        String result1 = fun1.callJS("Hello", String.class);
        int result2 = fun2.callJS(42, Integer.class);
        double result3 = fun2.callJS(3.14, Double.class);
        boolean result4 = fun3.callJS(true, Boolean.class);
        String result5 = fun4.callJS(String.class);
        String result6 = fun1.callJS(jsStr, String.class);

        assertEquals("string: Hello", result1);
        assertEquals(44, result2);
        assertEquals(5.14, result3, 0.001);
        assertFalse(result4);
        assertEquals("No args called", result5);
        assertEquals("string: JSValue string", result6);
    }

    public static void testCallWithSpreadArgs() {
        JSArray args = JSArray.of(6, 7);
        JSFunction fun1 = JSFunction.fromArgs("a", "b", "return a * b;");
        JSFunction fun2 = JSFunction.fromArgs("a", "b", "return a + ' - ' + b;");
        JSFunction fun3 = JSFunction.fromBiFunc((JSString prefix, JSString message) ->
                prefix.as(String.class) + " - " + message.as(String.class));

        int result1 = JSValue.checkedCoerce(fun1.callJSWithSpreadArgs(JSValue.undefined(), args), Integer.class);
        String result2 = JSValue.checkedCoerce(
                fun2.callJSWithSpreadArgs(JSValue.undefined(), "Hello", "World"), String.class);
        String result3 = fun3.callJSWithSpreadArgs(JSValue.undefined(), "Hello", "World");

        assertEquals(42, result1);
        assertEquals("Hello - World", result2);
        assertEquals("Hello - World", result3);
    }

    public static void testApply() {
        JSArray args1 = JSArray.of("String", 3.14, true);
        TestObject testObject = new TestObject(5);
        TestJSObject testJSObject = new TestJSObject(10);
        JSFunction fun1 = JSFunction.fromBiFuncWithThis((Object this_, String a, Double b) ->
                ((TestObject) this_).value + " | " + a + " | " + b);
        JSFunction fun2 = JSFunction.fromArgs("a", "b", "c", "return a + ' | ' + b + ' | ' + c;");
        JSFunction fun3 = JSFunction.fromJSBiFuncWithThis((JSObject this_, JSString a, JSNumber b) ->
                JSString.of(this_.as(TestJSObject.class).value + " | " + a.asString() + " | " + b.asDouble()));
        JSFunction fun4 = JSFunction.fromThisJSFunc((JSObject this_) ->
                JSString.of("Value of this_.value: " + this_.as(TestJSObject.class).value));

        String result1 = JSValue.checkedCoerce(fun1.apply(testObject, "String", 1.23), String.class);
        String result2 = JSValue.checkedCoerce(fun2.applyArray(testObject, args1), String.class);
        String result3 = JSValue.checkedCoerce(
                fun3.applyJS(testJSObject, JSString.of("String"), JSNumber.of(1.23)), String.class);
        String result4 = fun4.applyJS(testJSObject, String.class);
        String result5 = fun3.applyJS(testJSObject, String.class, JSString.of("String"), JSNumber.of(1.23));
        String result6 = JSValue.checkedCoerce(fun2.applyJSArray(testJSObject, args1), String.class);

        assertEquals("5 | String | 1.23", result1);
        assertEquals("String | 3.14 | true", result2);
        assertEquals("10 | String | 1.23", result3);
        assertEquals("Value of this_.value: 10", result4);
        assertEquals("10 | String | 1.23", result5);
        assertEquals("String | 3.14 | true", result6);
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
        JSFunction fun2 = JSFunction.fromFunc((String arg) -> "Hello, " + arg);

        int result1 = fun1.length;
        int result2 = fun2.length;
        String result3 = fun1.name;
        String result4 = fun2.prototype.toString();
        String result5 = fun1.toString();
        String result6 = fun2.toString();
        String result7 = fun2.toJSString();

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
        assertEquals("function(args) { return javaFunc.apply(args); }", result7);
    }

    private static <A, B> void assertPair(Pair<A, B> pair, A value1, B value2) {
        assertEquals(value1, pair.a());
        assertEquals(value2, pair.b());
    }

    private static <A, B, C> void assertTriple(Triple<A, B, C> triple, A value1, B value2, C value3) {
        assertEquals(value1, triple.a());
        assertEquals(value2, triple.b());
        assertEquals(value3, triple.c());
    }

    private static class TestObject {

        public int value;

        public TestObject(int value) {
            this.value = value;
        }
    }

    private static class TestJSObject extends JSObject {

        public int value;

        public TestJSObject(int value) {
            this.value = value;
        }
    }
}