/*
 * Copyright (c) 2025 Arthur Schwaiger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.atur256.graalvmwebimageinterop.tests;

import io.github.atur256.graalvmwebimageinterop.builtin.JSArray;
import io.github.atur256.graalvmwebimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

import static io.github.atur256.graalvmwebimageinterop.tests.Asserts.*;


public class JSFunctionTest {

    public static void main(String[] args) {

        testFromBody();
        testFromArgs();
        testGenericOf();
        testFunction();
        testBiFunction();
        testTriFunction();
        testRunnableAndConsumer();
        testBiConsumer();
        testTriConsumer();
        testSupplier();
        testGenericWithThis();
        testThisFunc();
        testFuncWithThis();
        testBiFuncWithThis();
        testThisCons();
        testConsWithThis();
        testBiConsWithThis();
        testCall();
        testBind();
        testMetadata();
    }

    public static void testFromBody() {
        JSFunction fun = JSFunction.fromBody("return 'Hello ' + arg;");

        String result = fun.invokeRaw(String.class, "Alice");

        assertEquals("Hello Alice", result);
    }

    public static void testFromArgs() {
        JSFunction fun = JSFunction.fromArgs(new String[]{"a", "b"}, "return a + b;");

        int result = fun.invokeRaw(Integer.class, JSNumber.of(5), JSNumber.of(7));

        assertEquals(12, result);
    }

    public static void testGenericOf() {
        JSFunction fun = JSFunction.of((JSNumber x, JSNumber y) -> JSNumber.of(x.asInt() + y.asInt()));
        JSFunction biFun = JSFunction.of((BiFunction<Integer, Integer, Integer>) (a, b) -> a * b);

        int result = fun.invokeRaw(Integer.class, JSNumber.of(5), JSNumber.of(7));
        int product = biFun.invoke(Integer.class, 6, 7);

        assertEquals(12, result);
        assertEquals(42, product);
    }

    public static void testFunction() {
        JSFunction fun1 = JSFunction.of((String arg) -> "Hello, " + arg);
        JSFunction fun2 = JSFunction.of((Integer arg) -> arg * 10);
        JSFunction fun3 = JSFunction.of((Double arg) -> arg * arg);
        JSFunction fun4 = JSFunction.of((Boolean arg) -> !arg);
        JSFunction fun5 = JSFunction.of((Long arg) -> arg / 10);
        JSFunction fun6 = JSFunction.of((CustomClass arg) ->
                new CustomClass("Hello " + arg.name() + "!"));
        JSFunction fun7 = JSFunction.of((JSString arg) -> JSString.of("Hello, " + arg.asString()));
        JSFunction fun8 = JSFunction.of((JSNumber arg) -> JSNumber.of(arg.asInt() * 10));
        JSFunction fun9 = JSFunction.of((JSBoolean arg) -> JSBoolean.of(!arg.asBoolean()));
        JSFunction fun10 = JSFunction.of((JSObject raw) -> {
            JSArray arg = JSValue.checkedCoerce(raw, JSArray.class);
            int sum = 0;
            for(int i = 0; i < arg.length; i++) {
                sum += arg.at(i, Integer.class);
            }
            return JSNumber.of(sum);
        });

        String result1 = fun1.invoke(String.class, "Alice");
        int result2 = fun2.invoke(Integer.class, 42);
        double result3 = fun3.invoke(Double.class, 3.5);
        boolean result4 = fun4.invoke(Boolean.class, true);
        long result5 = fun5.invoke(Long.class, 1234567890123L);
        CustomClass result6 = fun6.invoke(CustomClass.class, new CustomClass("Alice"));
        String result7 = fun7.invokeRaw(String.class, JSString.of("Alice"));
        int result8 = fun8.invokeRaw(Integer.class, JSNumber.of(42));
        boolean result9 = fun9.invokeRaw(Boolean.class, JSBoolean.of(true));
        int result10 = fun10.invokeRaw(Integer.class, JSArray.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

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
        JSFunction fun1 = JSFunction.of((String name, Integer age) ->
                "Name: " + name + ", Age: " + age);
        JSFunction fun2 = JSFunction.of((Double x, Double y) -> x * y);
        JSFunction fun3 = JSFunction.of((JSString name, JSNumber age) ->
                JSString.of(name.as(String.class) + " is " + age.as(Integer.class) + " years old."));

        String result1 = fun1.invoke(String.class, "Bob", 30);
        double result2 = fun2.invoke(Double.class, 6.0, 7.0);
        String result3 = fun3.invokeRaw(String.class, JSString.of("Alice"), JSNumber.of(25));

        assertEquals("Name: Bob, Age: 30", result1);
        assertEquals(42.0, result2, 0.0);
        assertEquals("Alice is 25 years old.", result3);
    }

    public static void testTriFunction() {
        JSFunction fun1 = JSFunction.of((String name, Integer age, Boolean vip) ->
                "Name: " + name + ", Age: " + age + ", VIP:" + (vip ? " Yes" : " No"));
        JSFunction fun2 = JSFunction.of((JSString name, JSNumber age, JSBoolean vip) -> {
            String result = name.as(String.class) + " (" + age.as(Integer.class) + ")";
            if(vip.as(Boolean.class)) result += " [VIP]";
            return JSString.of(result);
        });

        String result1 = fun1.invoke(String.class, "Charlie", 28, true);
        String result2 = fun2.invokeRaw(String.class, JSString.of("Dana"), JSNumber.of(35), JSBoolean.of(true));

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
        JSFunction runner = JSFunction.of(latch::countDown);
        JSFunction con1 = JSFunction.of(captured1::set);
        JSFunction con2 = JSFunction.of(captured2::set);
        JSFunction con3 = JSFunction.of(captured3::set);
        JSFunction con4 = JSFunction.of(captured4::set);
        JSFunction con5 = JSFunction.of(captured5::set);
        JSFunction con6 = JSFunction.of(captured6::set);
        JSFunction con7 = JSFunction.of(captured7::set);
        JSFunction con8 = JSFunction.of(captured8::set);

        runner.invoke();
        con1.invoke("Hello");
        con2.invoke(42);
        con3.invoke(3.14);
        con4.invoke(true);
        con5.invoke(new CustomClass("Alice"));
        con6.invokeRaw(JSString.of("Hello"));
        con7.invokeRaw(JSNumber.of(42));
        con8.invokeRaw(JSBoolean.of(false));

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
        JSFunction con1 = JSFunction.of((String a, String b) ->
                captured1.set(Pair.of(a, b)));
        JSFunction con2 = JSFunction.of((String label, Integer value) ->
                captured2.set(Pair.of(label, value)));
        JSFunction con3 = JSFunction.of((CustomClass a, CustomClass b) ->
                captured3.set(Pair.of(a, b)));
        JSFunction con4 = JSFunction.of((JSString a, JSString b) ->
                captured4.set(Pair.of(a, b)));
        JSFunction con5 = JSFunction.of((JSString label, JSNumber value) ->
                captured5.set(Pair.of(label, value)));
        JSFunction con6 = JSFunction.of((JSString label, JSBoolean value) ->
                captured6.set(Pair.of(label, value)));

        con1.invoke("Hello", "World");
        con2.invoke("Age", 30);
        con3.invoke(new CustomClass("Alice"), new CustomClass("Bob"));
        con4.invokeRaw(JSString.of("Hello"), JSString.of("World"));
        con5.invokeRaw(JSString.of("Age"), JSNumber.of(30));
        con6.invokeRaw(JSString.of("VIP"), JSBoolean.of(true));

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
        JSFunction con1 = JSFunction.of((String a, String b, String c) ->
                captured1.set(Triple.of(a, b, c)));
        JSFunction con2 = JSFunction.of((String label, Integer value1, Double value2) ->
                captured2.set(Triple.of(label, value1, value2)));
        JSFunction con3 = JSFunction.of((CustomClass a, CustomClass b, CustomClass c) ->
                captured3.set(Triple.of(a, b, c)));
        JSFunction con4 = JSFunction.of((JSString a, JSString b, JSString c) ->
                captured4.set(Triple.of(a, b, c)));
        JSFunction con5 = JSFunction.of((JSString label, JSNumber value1, JSBoolean value2) ->
                captured5.set(Triple.of(label, value1, value2)));

        con1.invoke("Hello", "World", "!");
        con2.invoke("Age and Height", 30, 186.35);
        con3.invoke(new CustomClass("Alice"), new CustomClass("Bob"), new CustomClass("Anna"));
        con4.invokeRaw(JSString.of("Hello"), JSString.of("World"), JSString.of("!"));
        con5.invokeRaw(JSString.of("Age and VIP status"), JSNumber.of(186.35), JSBoolean.of(true));

        assertTriple(captured1.get(), "Hello", "World", "!");
        assertTriple(captured2.get(), "Age and Height", 30, 186.35);
        assertTriple(captured3.get(),
                new CustomClass("Alice"), new CustomClass("Bob"), new CustomClass("Anna"));
        assertTriple(captured4.get(), JSString.of("Hello"), JSString.of("World"), JSString.of("!"));
        assertTriple(captured5.get(),
                JSString.of("Age and VIP status"), JSNumber.of(186.35), JSBoolean.of(true));
    }

    public static void testSupplier() {
        JSFunction sup1 = JSFunction.of(() -> "Supplied string");
        JSFunction sup2 = JSFunction.of(() -> 42);
        JSFunction sup3 = JSFunction.of(() -> 3.14);
        JSFunction sup4 = JSFunction.of(() -> true);
        JSFunction sup5 = JSFunction.of(() -> new CustomClass("Alice"));

        String result1 = sup1.invoke(String.class);
        int result2 = sup2.invoke(Integer.class);
        double result3 = sup3.invoke(Double.class);
        boolean result4 = sup4.invoke(Boolean.class);
        CustomClass result5 = sup5.invoke(CustomClass.class);

        assertEquals("Supplied string", result1);
        assertEquals(42, result2);
        assertEquals(3.14, result3, 0.0);
        assertTrue(result4);
        assertEquals("Alice", result5.name());
    }

    public static void testGenericWithThis() {
        record Holder(int value) {

        }
        Holder holder = new Holder(10);
        JSFunction fun = JSFunction.withThis((Holder self, Integer x) -> self.value + x);
        JSFunction funObj = JSFunction.withThis((Object self, Integer x) -> ((Holder) self).value * x);

        int result = fun.call(Integer.class, holder, 5);
        int result2 = funObj.call(Integer.class, holder, 3);

        assertEquals(15, result);
        assertEquals(30, result2);
    }

    public static void testThisFunc() {
        TestObject testObject = new TestObject(1234);
        TestJSObject testJSObject = new TestJSObject(1234);
        JSFunction fun1 = JSFunction.withThis((Object this_) ->
                "Value of this_.value: " + ((TestObject) this_).value);
        JSFunction fun2 = JSFunction.withThis((JSObject this_) ->
                JSString.of("Value of this_.value: " + this_.get("value", Integer.class)));

        String result1 = fun1.call(String.class, testObject);
        String result2 = fun2.callRaw(String.class, testJSObject);

        assertEquals("Value of this_.value: 1234", result1);
        assertEquals("Value of this_.value: 1234", result2);
    }

    public static void testFuncWithThis() {
        TestObject testObject = new TestObject(42);
        TestJSObject testJSObject = new TestJSObject(25);
        JSFunction fun1 = JSFunction.withThis((Object this_, Integer arg) ->
                "Value of this_.value * arg: " + ((TestObject) this_).value * arg);
        JSFunction fun2 = JSFunction.withThis((JSObject this_, JSNumber arg) ->
                JSString.of("Value of this_.value * arg: " + this_.get("value", Integer.class) * arg.asInt()));

        String result1 = fun1.call(String.class, testObject, 5);
        String result2 = fun2.callRaw(String.class, testJSObject, JSNumber.of(5));

        assertEquals("Value of this_.value * arg: 210", result1);
        assertEquals("Value of this_.value * arg: 125", result2);
    }


    public static void testBiFuncWithThis() {
        TestObject testObject = new TestObject(42);
        TestJSObject testJSObject = new TestJSObject(25);
        JSFunction fun1 = JSFunction.withThis((Object this_, Integer arg1, Integer arg2) ->
                "Value of this_.value * arg1 + arg2: " + (((TestObject) this_).value * arg1 + arg2));
        JSFunction fun2 = JSFunction.withThis((JSObject this_, JSNumber arg1, JSNumber arg2) ->
                JSString.of("Value of this_.value * arg1 + arg2: " +
                        ((this_.get("value", Integer.class)) * arg1.asInt() + arg2.asInt())));

        String result1 = fun1.call(String.class, testObject, 5, 5);
        String result2 = fun2.callRaw(String.class, testJSObject, JSNumber.of(5), JSNumber.of(10));

        assertEquals("Value of this_.value * arg1 + arg2: 215", result1);
        assertEquals("Value of this_.value * arg1 + arg2: 135", result2);
    }

    public static void testThisCons() {
        AtomicReference<Integer> captured1 = new AtomicReference<>();
        AtomicReference<Integer> captured2 = new AtomicReference<>();
        TestObject testObject = new TestObject(1234);
        TestJSObject testJSObject = new TestJSObject(10);
        JSFunction fun1 = JSFunction.withThis((Object this_) ->
                captured1.set(((TestObject) this_).value));
        JSFunction fun2 = JSFunction.withThis((JSObject this_) ->
                captured2.set(this_.get("value", Integer.class)));

        fun1.call(testObject);
        fun2.callRaw(testJSObject);

        assertEquals(Integer.valueOf(1234), captured1.get());
        assertEquals(Integer.valueOf(10), captured2.get());
    }

    public static void testConsWithThis() {
        AtomicReference<Pair<Object, Integer>> captured1 = new AtomicReference<>();
        AtomicReference<Pair<JSObject, JSNumber>> captured2 = new AtomicReference<>();
        TestObject testObject = new TestObject(42);
        TestJSObject testJSObject = new TestJSObject(25);
        JSFunction fun1 = JSFunction.withThis((Object this_, Integer arg) ->
                captured1.set(Pair.of(this_, arg)));
        JSFunction fun2 = JSFunction.withThis((JSObject this_, JSNumber arg) ->
                captured2.set(Pair.of(this_, arg)));

        fun1.call(testObject, 5);
        fun2.callRaw(testJSObject, JSNumber.of(10));

        assertPair(captured1.get(), testObject, 5);
        assertPair(captured2.get(), testJSObject, JSNumber.of(10));
    }

    public static void testBiConsWithThis() {
        AtomicReference<Triple<Object, Integer, Integer>> captured1 = new AtomicReference<>();
        AtomicReference<Triple<JSObject, JSNumber, JSNumber>> captured2 = new AtomicReference<>();
        TestObject testObject = new TestObject(42);
        TestJSObject testJSObject = new TestJSObject(25);
        JSFunction fun1 = JSFunction.withThis((Object this_, Integer arg1, Integer arg2) ->
                captured1.set(Triple.of(this_, arg1, arg2)));
        JSFunction fun2 = JSFunction.withThis((JSObject this_, JSNumber arg1, JSNumber arg2) ->
                captured2.set(Triple.of(this_, arg1, arg2)));

        fun1.call(testObject, 5, 5);
        fun2.callRaw(testJSObject, JSNumber.of(5), JSNumber.of(10));

        assertTriple(captured1.get(), testObject, 5, 5);
        assertTriple(captured2.get(), testJSObject, JSNumber.of(5), JSNumber.of(10));
    }

    public static void testCall() {
        TestObject testObject = new TestObject(42);
        TestJSObject testJSObject = new TestJSObject(25);
        JSFunction fun1 = JSFunction.withThis((Object this_) ->
                "Value of this_.value: " + ((TestObject) this_).value);
        JSFunction fun2 = JSFunction.withThis((JSObject this_) ->
                JSNumber.of(this_.get("value", Integer.class)));
        JSFunction fun3 = JSFunction.withThis((Object this_, Integer arg) ->
                ((TestObject) this_).value > arg);
        JSFunction fun4 = JSFunction.withThis((JSObject this_, JSNumber arg) ->
                JSString.of("Value of this_.value * arg: " +
                        this_.get("value", Integer.class) * arg.asInt()));
        JSFunction fun5 = JSFunction.withThis((Object this_, Integer arg1, Integer arg2) ->
                (((TestObject) this_).value * arg1 + arg2));
        JSFunction fun6 = JSFunction.withThis((JSObject this_, JSNumber arg1, JSNumber arg2) ->
                JSBoolean.of(this_.get("value", Integer.class) > (arg1.asInt() * arg2.asInt())));

        String result1 = fun1.call(String.class, testObject);
        int result2 = fun2.callRaw(Integer.class, testJSObject);
        boolean result3 = fun3.call(Boolean.class, testObject, 10);
        String result4 = fun4.callRaw(String.class, testJSObject, 5);
        int result5 = fun5.call(Integer.class, testObject, 10, 2);
        boolean result6 = fun6.callRaw(Boolean.class, testJSObject, 5, 6);

        assertEquals("Value of this_.value: 42", result1);
        assertEquals(25, result2);
        assertTrue(result3);
        assertEquals("Value of this_.value * arg: 125", result4);
        assertEquals(422, result5);
        assertFalse(result6);
    }

    public static void testBind() {
        CustomClass obj = new CustomClass("Alice");
        JSFunction fun1 = JSFunction.withThis((CustomClass self, Boolean value) ->
                (self.name() + " is VIP: " + value));
        JSFunction fun2 = JSFunction.withThis((JSString self, JSString value) ->
                JSString.of(self.asString() + value.asString()));

        String result1 = fun1.bind(obj).invoke(String.class, false);
        String result2 = fun2.bindRaw(JSString.of("Hello ")).invokeRaw(String.class, JSString.of("Alice"));

        assertEquals("Alice is VIP: false", result1);
        assertEquals("Hello Alice", result2);
    }

    public static void testMetadata() {
        JSFunction fun1 = JSFunction.fromArgs(new String[]{"x", "y", "z"}, "return x + y + z;");

        int result1 = fun1.length;
        String result2 = fun1.name;

        assertEquals(3, result1);
        assertEquals("anonymous", result2);
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
