package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.tests.testUtils.CustomClass;
import io.github.atur256.webimageinterop.tests.testUtils.Pair;
import io.github.atur256.webimageinterop.tests.testUtils.Triple;
import org.graalvm.webimage.api.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JSFunctionTests {

    public static void main(String[] args) {

        // fromBody
        JSFunction greetJS = JSFunction.fromBody("return 'Hello ' + arg;");
        assertEquals("Hello Alice", greetJS.callJS("Alice", String.class));

        // fromArgs
        JSFunction sum = JSFunction.fromArgs("a", "b", "return a + b;");
        assertEquals(Integer.valueOf(12), sum.applyJS(null, JSArray.of(JSNumber.of(5), JSNumber.of(7)), Integer.class));

        // fromGeneralFunction
        JSFunction greetJava = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);
        assertEquals("Hello, Alice", greetJava.call("Alice"));

        JSFunction intToString = JSFunction.fromGeneralFunction((Integer arg) -> "Int: " + arg);
        assertEquals("Int: 42", intToString.call(42));

        JSFunction doubleSquare = JSFunction.fromGeneralFunction((Double arg) -> arg * arg);
        assertEquals(12.25, doubleSquare.call(3.5), 0.0);

        JSFunction boolToString = JSFunction.fromGeneralFunction((Boolean arg) -> arg ? "Yes" : "No");
        assertEquals("Yes", boolToString.call(true));

        JSFunction longToString = JSFunction.fromGeneralFunction((Long arg) -> "Long: " + arg);
        assertEquals("Long: 1234567890123", longToString.call(1234567890123L));

        JSFunction customToString = JSFunction.fromGeneralFunction((CustomClass arg) -> "Custom: " + arg.name());
        assertEquals("Custom: Alice", customToString.call(new CustomClass("Alice")));

        // fromGeneralBiFunction
        JSFunction biFun = JSFunction.fromGeneralBiFunction((String name, Integer age) -> "Name: " + name + ", Age: " + age.toString());
        assertEquals("Name: Bob, Age: 30", biFun.call("Bob", 30));

        JSFunction biMultiply = JSFunction.fromGeneralBiFunction((Double x, Double y) -> x * y);
        assertEquals(42.0, biMultiply.call(6.0, 7.0), 0.0);

        // fromBiFunction
        JSFunction biMixed = JSFunction.fromBiFunction((JSString name, JSNumber age) -> JSString.of(name.as(String.class) + " is " + age.as(Integer.class) + " years old."));
        assertEquals("Alice is 25 years old.", JSValue.checkedCoerce(biMixed.call(JSString.of("Alice"), JSNumber.of(25)), String.class));

        // fromGeneralTriFunction
        JSFunction triFun = JSFunction.fromGeneralTriFunction((String name, Integer age, Boolean vip) ->
                "Name: " + name + ", Age: " + age + ", VIP: " + (vip ? "Yes" : "No"));
        assertEquals("Name: Charlie, Age: 28, VIP: Yes", triFun.call("Charlie", 28, true));

        // fromTriFunction
        JSFunction triMixed = JSFunction.fromTriFunction((JSString name, JSNumber age, JSBoolean vip) -> {
            String result223423 = name.as(String.class) + " (" + age.as(Integer.class) + ")";
            if(vip.as(Boolean.class)) result223423 += " [VIP]";
            return JSString.of(result223423);
        });
        assertEquals("Dana (35) [VIP]", JSValue.checkedCoerce(triMixed.call(JSString.of("Dana"), JSNumber.of(35), JSBoolean.of(true)), String.class));

        // fromRunnable
        CountDownLatch latch = new CountDownLatch(1);
        JSFunction runner = JSFunction.fromRunnable(latch::countDown);
        runner.call();
        assertEquals(0, latch.getCount());

        // fromGeneralConsumer
        AtomicReference<String> captured1 = new AtomicReference<>();
        JSFunction stringConsumer = JSFunction.fromGeneralConsumer(captured1::set);
        stringConsumer.call("Hello");
        assertEquals("Hello", captured1.get());

        AtomicReference<Integer> captured2 = new AtomicReference<>();
        JSFunction intConsumer = JSFunction.fromGeneralConsumer(captured2::set);
        intConsumer.call(42);
        assertEquals(Integer.valueOf(42), captured2.get());

        AtomicReference<Double> captured3 = new AtomicReference<>();
        JSFunction doubleConsumer = JSFunction.fromGeneralConsumer(captured3::set);
        doubleConsumer.call(3.14);
        assertEquals(3.14, captured3.get(), 0.0);

        AtomicReference<Boolean> captured4 = new AtomicReference<>();
        JSFunction boolConsumer = JSFunction.fromGeneralConsumer(captured4::set);
        boolConsumer.call(true);
        assertTrue(captured4.get());

        AtomicReference<CustomClass> captured5 = new AtomicReference<>();
        JSFunction customConsumer = JSFunction.fromGeneralConsumer(captured5::set);
        customConsumer.call(new CustomClass("Alice"));
        assertEquals(new CustomClass("Alice"), captured5.get());

        // fromGeneralBiConsumer
        AtomicReference<Pair<String, String>> captured6 = new AtomicReference<>();
        JSFunction biStringConsumer = JSFunction.fromGeneralBiConsumer((String a, String b) -> captured6.set(Pair.of(a, b)));
        biStringConsumer.call("Hello", "World");
        assertEquals("Hello", captured6.get().a());
        assertEquals("World", captured6.get().b());

        AtomicReference<Pair<String, Integer>> captured7 = new AtomicReference<>();
        JSFunction biMixedConsumer = JSFunction.fromGeneralBiConsumer((String label, Integer value) -> captured7.set(Pair.of(label, value)));
        biMixedConsumer.call("Age", 30);
        assertEquals("Age", captured7.get().a());
        assertEquals(Integer.valueOf(30), captured7.get().b());

        AtomicReference<Pair<CustomClass, CustomClass>> captured8 = new AtomicReference<>();
        JSFunction biCustomConsumer = JSFunction.fromGeneralBiConsumer((CustomClass a, CustomClass b) -> captured8.set(Pair.of(a, b)));
        biCustomConsumer.call(new CustomClass("Alice"), new CustomClass("Bob"));
        assertEquals(new CustomClass("Alice"), captured8.get().a());
        assertEquals(new CustomClass("Bob"), captured8.get().b());

        // fromGeneralTriConsumer
        AtomicReference<Triple<String, String, String>> captured9 = new AtomicReference<>();
        JSFunction triStringConsumer = JSFunction.fromGeneralTriConsumer((String a, String b, String c) -> captured9.set(Triple.of(a, b, c)));
        triStringConsumer.call("Hello", "World", "!");
        assertEquals("Hello", captured9.get().a());
        assertEquals("World", captured9.get().b());
        assertEquals("!", captured9.get().c());

        AtomicReference<Triple<String, Integer, Double>> captured10 = new AtomicReference<>();
        JSFunction triMixedConsumer = JSFunction.fromGeneralTriConsumer((String label, Integer value1, Double value2) -> captured10.set(Triple.of(label, value1, value2)));
        triMixedConsumer.call("Age and Height", 30, 186.35);
        assertEquals("Age and Height", captured10.get().a());
        assertEquals(Integer.valueOf(30), captured10.get().b());
        assertEquals(186.35, captured10.get().c(), 0.0);

        AtomicReference<Triple<CustomClass, CustomClass, CustomClass>> captured11 = new AtomicReference<>();
        JSFunction triCustomConsumer = JSFunction.fromGeneralTriConsumer((CustomClass a, CustomClass b, CustomClass c) -> captured11.set(Triple.of(a, b, c)));
        triCustomConsumer.call(new CustomClass("Alice"), new CustomClass("Bob"), new CustomClass("Anna"));
        assertEquals(new CustomClass("Alice"), captured11.get().a());
        assertEquals(new CustomClass("Bob"), captured11.get().b());
        assertEquals(new CustomClass("Anna"), captured11.get().c());

        // fromSupplier
        JSFunction stringSupplier = JSFunction.fromSupplier(() -> "Supplied string");
        assertEquals("Supplied string", stringSupplier.call());

        JSFunction intSupplier = JSFunction.fromSupplier(() -> 42);
        assertEquals(Integer.valueOf(42), intSupplier.call());

        JSFunction doubleSupplier = JSFunction.fromSupplier(() -> 3.14);
        assertEquals(3.14, doubleSupplier.call(), 0.0);

        JSFunction boolSupplier = JSFunction.fromSupplier(() -> true);
        assertTrue(boolSupplier.call());

        JSFunction customSupplier = JSFunction.fromSupplier(() -> new CustomClass("Alice"));
        assertEquals("Alice", ((CustomClass) customSupplier.call()).name());

        // callJS
        JSFunction describeJS = JSFunction.fromBody("return typeof arg + ': ' + arg;");
        JSValue jsStr = JSString.of("JSValue string");

        assertEquals("string: Hello", describeJS.callJS("Hello", String.class));
        assertEquals("number: 42", describeJS.callJS(42, String.class));
        assertEquals("number: 3.14", describeJS.callJS(3.14, String.class));
        assertEquals("boolean: true", describeJS.callJS(true, String.class));
        assertEquals("string: JSValue string", describeJS.callJS(jsStr, String.class));

        // call
        JSFunction describeJava = JSFunction.fromGeneralFunction((Object arg) -> {
            if(arg == null) return "null: null";
            return arg.getClass().getSimpleName() + ": " + arg;
        });
        JSValue jsValue = JSString.of("JSValue string");
        JSFunction noArg = JSFunction.fromSupplier(() -> "No args called");
        JSFunction describeBi = JSFunction.fromGeneralBiFunction((String prefix, Object arg) -> {
            if(arg == null) return "null: null";
            return prefix + arg.getClass().getSimpleName() + ": " + arg;
        });

        assertEquals("String: Java string", describeJava.call("Java string"));
        assertEquals("Integer: 42", describeJava.call(42));
        assertEquals("Double: 3.14", describeJava.call(3.14));
        assertEquals("Boolean: true", describeJava.call(true));
        assertEquals("null: null", describeJava.call(null));
        assertEquals("CustomClass: CustomClass(Alice)", describeJava.call(new CustomClass("Alice")));
        assertEquals("JSString: JavaScript<string; JSValue string>", describeJava.call(jsValue));
        assertEquals("No args called", noArg.call());
        assertEquals("Prefix: String: Java string", describeBi.call("Prefix: ", "Java string"));

        // callWithSpreadArgs
        JSFunction multiply = JSFunction.fromArgs("a", "b", "return a * b;");
        JSArray jsArgs1 = new JSArray();
        jsArgs1.push(JSNumber.of(6));
        jsArgs1.push(JSNumber.of(7));
        JSFunction concat = JSFunction.fromArgs("a", "b", "return a + ' - ' + b;");
        JSFunction javaConcat = JSFunction.fromGeneralBiFunction((JSString prefix, JSString message) -> prefix.as(String.class) + " - " + message.as(String.class));

        assertEquals(Integer.valueOf(42), JSValue.checkedCoerce(multiply.callWithSpreadArgs(JSValue.undefined(), jsArgs1), Integer.class));
        assertEquals("Hello - World", JSValue.checkedCoerce(concat.callWithSpreadArgs(JSValue.undefined(), "Hello", "World"), String.class));
        assertEquals("Hello - World", javaConcat.callWithSpreadArgs(JSValue.undefined(), "Hello", "World"));

        // apply
        JSFunction jsFormatter = JSFunction.fromArgs("a", "b", "c", "return a + ' | ' + b + ' | ' + c;");
        JSArray jsArgs2 = new JSArray();
        jsArgs2.push(JSString.of("JSString"));
        jsArgs2.push(JSNumber.of(3.14));
        jsArgs2.push(JSBoolean.of(true));
        JSFunction javaDescriber = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg + "!");
        JSFunction javaDescriber2 = JSFunction.fromGeneralFunction((Integer arg) -> "Number: " + arg);

        assertEquals("JSString | 3.14 | true", JSValue.checkedCoerce(jsFormatter.apply(JSValue.undefined(), jsArgs2), String.class));
        assertEquals("[Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]", JSValue.checkedCoerce(jsFormatter.apply(null, "JavaString", 42, false), String.class));
        assertEquals("JSString | 3.14 | true", JSValue.checkedCoerce(jsFormatter.applyGeneral(JSValue.undefined(), jsArgs2), String.class));
        assertEquals("[Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]", JSValue.checkedCoerce(jsFormatter.applyRaw("RawPrefix", "RawString", 99, true), String.class));
        assertEquals("Hello, Alice!", JSValue.checkedCoerce(javaDescriber.apply(null, "Alice"), String.class));
        assertEquals("Number: 20", JSValue.checkedCoerce(javaDescriber2.apply(null, 20), String.class));

        // bind
        JSFunction greet = JSFunction.fromArgs("name", "return this + name;");

        JSFunction boundJSValue = greet.bind(JSString.of("JSValue: "));
        assertEquals("JSValue: Alice", boundJSValue.callJS("Alice", String.class));

        JSFunction boundInt = greet.bind(123);
        assertEquals("123Bob", boundInt.callJS("Bob", String.class));

        JSFunction boundDouble = greet.bind(3.14);
        assertEquals("3.14Charlie", boundDouble.callJS("Charlie", String.class));

        JSFunction boundBoolean = greet.bind(true);
        assertEquals("trueDana", boundBoolean.callJS("Dana", String.class));

        JSFunction boundObject = greet.bind("Custom: ");
        assertEquals("Custom: Eve", boundObject.callJS("Eve", String.class));

        JSObject context = JSObject.create();
        context.set("prefix", JSString.of("Hello "));
        JSFunction greetWithPrefix = JSFunction.fromArgs("name", "return this.prefix + name;");
        JSFunction boundJSObject = greetWithPrefix.bind(context);
        assertEquals("Hello Frank", boundJSObject.callJS("Frank", String.class));

        JSFunction jsF = JSFunction.fromArgs("x", "y", "z", "return x + y + z;");
        JSFunction javaF = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);

        // length
        assertEquals(3, jsF.length);
        assertEquals(1, javaF.length);

        // name
        assertEquals("anonymous", jsF.name);

        // prototype
        assertEquals("JavaScript<object; [object Object]>", javaF.prototype.toString());
        assertEquals("""
                function anonymous(x,y,z
                ) {
                return x + y + z;
                }""", jsF.toStringJS());

        // toStringJS
        assertEquals("function(args) { return javaFunc.apply(args); }", javaF.toStringJS());
    }
}