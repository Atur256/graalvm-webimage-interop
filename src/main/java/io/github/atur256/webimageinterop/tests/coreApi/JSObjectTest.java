package io.github.atur256.webimageinterop.tests.coreApi;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.*;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class JSObjectTest {

    public static void main(String[] args) {
        testPrototypeInheritance();
        testCreateWithProperties();
        testDefineProperties();
        testDefinePropertyVariants();
        testEntries();
        testFreeze();
        testFromEntries();
        testGetOwnPropertyDescriptor();
        testGetOwnPropertyNames();
        testGroupBy();
        testHasOwn();
        testIsEquality();
        testIsExtensibleAndPreventExtensions();
        testIsFrozenAndFreeze();
        testPrototypeChain();
        testSealAndMutation();
        testKeysAndValues();
        testPreventExtensions();
        testPropertyIsEnumerable();
        testPrototypeMethodBinding();
        testToLocaleString();
        testValueOf();
        testValues();
    }

    @JS.Coerce
    @JS(value = "return function(args) { return javaFunc.apply(args); }")
    public static native <T, R> JSValue fromJavaFunction(Function<T, R> javaFunc);

    public static void testPrototypeInheritance() {
        JSObject proto = JSObject.create();
        proto.set("greet", fromJavaFunction((String name) -> "Hello, " + name));

        JSObject obj = JSObject.create(proto);
        JSValue fun = (JSValue) obj.get("greet");
        String greeting = apply(fun, null, "Alice");

        assertEquals("Hello, Alice", greeting);
    }

    public static void testCreateWithProperties() {
        JSObject proto = JSObject.create();
        proto.set("greet", JSFunction.fromGeneralFunction((String name) -> "Hello, " + name));
        JSObject nameDescriptor = JSObject.create();
        set(nameDescriptor, JSString.of("Bob"), false, true);
        JSObject properties = JSObject.create();
        properties.set("name", nameDescriptor);

        JSObject obj = JSObject.create(proto, properties);
        boolean failed = false;
        try {
            obj.set("name", "Alice");
        } catch (Exception e) {
            failed = true;
        }
        String result = JSValue.checkedCoerce(obj.get("name"), String.class);
        JSFunction fun = ((JSValue) obj.get("greet")).as(JSFunction.class);
        String greeting = fun.apply(null, "World");

        assertTrue(failed);
        assertEquals("Bob", result);
        assertEquals("Hello, World", greeting);
    }

    public static void testDefineProperties() {
        JSObject target = JSObject.create();
        JSObject descriptors = JSObject.create();
        JSObject nameDescriptor = JSObject.create();
        set(nameDescriptor, JSString.of("Alice"), true, true);
        descriptors.set("name", nameDescriptor);
        JSObject versionDescriptor = JSObject.create();
        set(versionDescriptor, JSNumber.of(26), false, false);
        descriptors.set("age", versionDescriptor);

        JSObject result = JSObject.defineProperties(target, descriptors);
        String name1 = JSValue.checkedCoerce(result.get("name"), String.class);
        int age = JSValue.checkedCoerce(result.get("age"), Integer.class);
        result.set("name", JSString.of("Bob"));
        boolean failed = false;
        try {
            result.set("age", JSNumber.of(21));
        } catch (Exception e) {
            failed = true;
        }
        String name2 = JSValue.checkedCoerce(result.get("name"), String.class);

        assertEquals("Alice", name1);
        assertEquals(26, age);
        assertEquals("Bob", name2);
        assertTrue(failed);
    }

    public static void testDefinePropertyVariants() {
        JSObject obj1 = JSObject.create();
        JSObject obj2 = JSObject.create();
        JSObject descriptor = JSObject.create();
        set(descriptor, JSString.of("Alice"), false, true);

        JSObject.defineProperty(obj1, JSString.of("name"), descriptor);
        JSObject.defineProperty(obj2, "name", descriptor);
        boolean failed1 = false;
        boolean failed2 = false;
        try {
            obj1.set("name", "NotAlice");
        } catch (Exception e) {
            failed1 = true;
        }
        try {
            obj2.set("name", "StillNotAlice");
        } catch (Exception e) {
            failed2 = true;
        }

        assertTrue(failed1);
        assertTrue(failed2);
        assertEquals("Alice", JSValue.checkedCoerce(obj1.get("name"), String.class));
        assertEquals("Alice", JSValue.checkedCoerce(obj2.get("name"), String.class));
    }

    @JS.Coerce
    @JS("return it.toString();")
    private static native String objToString(Object it);

    public static void testEntries() {
        JSObject obj = JSObject.create();
        obj.set("language", "JavaScript");
        obj.set("version", "ES2025");

        JSArray entryArray = JSArray.checkedCoerce(JSObject.entries(obj), JSArray.class);
        JSArray pair0 = entryArray.at(0, JSArray.class);
        JSArray pair1 = entryArray.at(1, JSArray.class);

        assertEquals(2, entryArray.length);
        assertEquals("language", pair0.at(0, String.class));
        assertEquals("JavaScript", pair0.at(1, String.class));
        assertEquals("version", pair1.at(0, String.class));
        assertEquals("ES2025", pair1.at(1, String.class));
    }


    public static void testFreeze() {
        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        JSObject.freeze(obj);
        boolean failed = false;
        try {
            obj.set("name", "Changed");
        } catch (ThrownFromJavaScript e) {
            failed = true;
        }

        assertTrue(failed);
        assertEquals("Alice", JSValue.checkedCoerce(obj.get("name"), String.class));
    }

    public static void testFromEntries() {
        JSArray entries = new JSArray();
        JSArray pair1 = new JSArray();
        pair1.push("framework");
        pair1.push("GraalVM");
        JSArray pair2 = new JSArray();
        pair2.push("mode");
        pair2.push("native");

        entries.push(pair1);
        entries.push(pair2);
        JSObject result = JSObject.fromEntries(entries);
        JSArray keys = JSValue.checkedCoerce(result.keys(), JSArray.class);

        assertEquals("GraalVM", JSValue.checkedCoerce(result.get("framework"), String.class));
        assertEquals("native", JSValue.checkedCoerce(result.get("mode"), String.class));
        AssertArray.assertArray(keys, String.class, "framework", "mode");
    }

    public static void testGetOwnPropertyDescriptor() {
        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        JSObject descriptor = JSObject.getOwnPropertyDescriptor(obj, "name");

        assertEquals("Alice", JSValue.checkedCoerce(descriptor.get("value"), String.class));
        assertTrue(JSValue.checkedCoerce(descriptor.get("writable"), Boolean.class));
        assertTrue(JSValue.checkedCoerce(descriptor.get("enumerable"), Boolean.class));
        assertTrue(JSValue.checkedCoerce(descriptor.get("configurable"), Boolean.class));
    }

    public static void testGetOwnPropertyNames() {
        JSObject obj = JSObject.create();
        obj.set("x", 1);
        obj.set("y", 2);

        JSArray names = JSValue.checkedCoerce(JSObject.getOwnPropertyNames(obj), JSArray.class);

        AssertArray.assertArray(names, String.class, "x", "y");
    }

    public static void testGroupBy() {
        JSArray items = new JSArray();
        JSObject obj1 = JSObject.create();
        obj1.set("name", "asparagus");
        obj1.set("type", "vegetables");
        obj1.set("quantity", 5);
        JSObject obj2 = JSObject.create();
        obj2.set("name", "bananas");
        obj2.set("type", "fruit");
        obj2.set("quantity", 0);
        JSObject obj3 = JSObject.create();
        obj3.set("name", "cherries");
        obj3.set("type", "fruit");
        obj3.set("quantity", 5);
        JSObject obj4 = JSObject.create();
        obj4.set("name", "goat");
        obj4.set("type", "meat");
        obj4.set("quantity", 23);
        JSObject obj5 = JSObject.create();
        obj5.set("name", "fish");
        obj5.set("type", "meat");
        obj5.set("quantity", 22);
        items.push(obj1);
        items.push(obj2);
        items.push(obj3);
        items.push(obj4);
        items.push(obj5);
        JSFunction groupByType = JSFunction.fromGeneralFunction((JSObject item) -> item.get("type"));

        JSObject grouped = JSObject.groupBy(items, groupByType);
        JSArray keys = JSValue.checkedCoerce(JSObject.keys(grouped), JSArray.class);

        AssertArray.assertArray(keys, String.class, "vegetables", "fruit", "meat");
        assertInnerArray(JSValue.checkedCoerce(grouped.get("vegetables"), JSArray.class), "asparagus");
        assertInnerArray(JSValue.checkedCoerce(grouped.get("fruit"), JSArray.class), "bananas", "cherries");
        assertInnerArray(JSValue.checkedCoerce(grouped.get("meat"), JSArray.class), "goat", "fish");
    }

    public static void testHasOwn() {
        JSObject obj = JSObject.create();
        obj.set("x", 10);

        assertTrue(JSObject.hasOwn(obj, "x"));
        assertFalse(JSObject.hasOwn(obj, "y"));
    }

    public static void testIsEquality() {
        JSObject obj1 = JSObject.create();
        obj1.set("value", 1);
        JSObject obj2 = JSObject.create();
        obj2.set("value", 1);

        assertTrue(JSObject.is(JSString.of("hello"), JSString.of("hello")));
        assertFalse(JSObject.is(JSString.of("5"), JSNumber.of(5)));
        assertTrue(JSObject.is(JSNumber.of(Double.NaN), JSNumber.of(Double.NaN)));
        assertFalse(JSObject.is(JSNumber.of(0.0), JSNumber.of(-0.0)));
        assertTrue(JSObject.is(JSBoolean.of(true), JSBoolean.of(true)));
        assertFalse(JSObject.is(obj1, obj2));
        assertTrue(JSObject.is(obj1, obj1));
    }

    public static void testIsExtensibleAndPreventExtensions() {
        JSObject obj = createTestObject();

        boolean result1 = JSObject.isExtensible(obj);
        JSObject.preventExtensions(obj);
        boolean result2 = JSObject.isExtensible(obj);
        boolean failed = false;
        try {
            obj.set("newProp", "test");
        } catch (Exception e) {
            failed = true;
        }

        assertTrue(result1);
        assertFalse(result2);
        assertTrue(failed);
        assertFalse(JSObject.hasOwn(obj, "newProp"));
    }

    public static void testIsFrozenAndFreeze() {
        JSObject obj = createTestObject();

        boolean result1 = JSObject.isFrozen(obj);
        JSObject.freeze(obj);
        boolean result2 = JSObject.isFrozen(obj);
        boolean failed1 = false;
        try {
            obj.set("name", "Bob");
        } catch (Exception e) {
            failed1 = true;
        }
        boolean failed2 = false;
        try {
            obj.set("newProp", "test");
        } catch (Exception e) {
            failed2 = true;
        }

        assertFalse(result1);
        assertTrue(result2);
        assertTrue(failed1);
        assertTrue(failed2);
        assertEquals("Alice", obj.get("name"));
        assertFalse(JSObject.hasOwn(obj, "newProp"));
    }

    public static void testPrototypeChain() {
        JSObject proto = JSObject.create();
        JSObject obj = JSObject.create();
        JSObject.setPrototypeOf(obj, proto);

        assertTrue(proto.isPrototypeOf(obj));
        assertFalse(obj.isPrototypeOf(proto));
    }

    public static void testSealAndMutation() {
        JSObject obj = createTestObject();

        boolean result1 = JSObject.isSealed(obj);
        JSObject.seal(obj);
        boolean result2 = JSObject.isSealed(obj);
        boolean failed1 = false;
        try {
            obj.set("name", "Bob");
        } catch (Exception e) {
            failed1 = true;
        }
        boolean failed2 = false;
        try {
            obj.set("newProp", "test");
        } catch (Exception e) {
            failed2 = true;
        }
        String finalName = JSValue.checkedCoerce(obj.get("name"), String.class);
        boolean exists = JSObject.hasOwn(obj, "newProp");

        assertFalse(result1);
        assertTrue(result2);
        assertFalse(failed1);
        assertTrue(failed2);
        assertEquals("Bob", finalName);
        assertFalse(exists);
    }

    public static void testKeysAndValues() {
        JSObject obj = createTestObject();
        obj.set("age", "27");
        obj.set("active", "true");

        JSArray keyArray = JSValue.checkedCoerce(JSObject.keys(obj), JSArray.class);
        JSArray valueArray = JSValue.checkedCoerce(JSObject.values(obj), JSArray.class);

        AssertArray.assertArray(keyArray, String.class, "name", "age", "active");
        AssertArray.assertArray(valueArray, String.class, "Alice", "27", "true");
    }

    public static void testPreventExtensions() {
        JSObject obj = createTestObject();

        boolean result1 = JSObject.isExtensible(obj);
        JSObject.preventExtensions(obj);
        boolean result2 = JSObject.isExtensible(obj);
        boolean failed = false;
        try {
            obj.set("newProp", "test");
        } catch (Exception e) {
            failed = true;
        }
        boolean exists = JSObject.hasOwn(obj, "newProp");

        assertTrue(result1);
        assertFalse(result2);
        assertTrue(failed);
        assertFalse(exists);
    }

    public static void testPropertyIsEnumerable() {
        JSObject obj = JSObject.create();
        obj.set("visible", "yes");
        JSObject descriptors = JSObject.create();
        JSObject hiddenDescriptor = JSObject.create();
        hiddenDescriptor.set("value", "no");
        hiddenDescriptor.set("enumerable", JSBoolean.of(false));
        descriptors.set("hidden", hiddenDescriptor);
        JSObject.defineProperties(obj, descriptors);
        JSArray keys = JSValue.checkedCoerce(obj.keys(), JSArray.class);

        assertTrue(obj.propertyIsEnumerable("visible"));
        assertFalse(obj.propertyIsEnumerable("hidden"));
        assertFalse(obj.propertyIsEnumerable("missing"));
        AssertArray.assertArray(keys, String.class, "visible");
    }

    public static void testPrototypeMethodBinding() {
        JSObject obj = createTestObject();

        JSObject proto = JSObject.create();
        proto.set("describe", JSFunction.fromArgs("return 'I am ' + String(this.name);"));

        JSObject result = JSObject.setPrototypeOf(obj, proto);
        JSFunction describeFn = JSValue.checkedCoerce(result.get("describe"), JSFunction.class);
        String description = JSValue.checkedCoerce(describeFn.applyRaw(result), String.class);

        assertEquals("I am Alice", description);
    }

    public static void testToLocaleString() {
        JSObject obj = createTestObject();
        obj.set("region", "Austria");

        assertEquals("[object Object]", obj.toLocaleString());
    }

    public static void testValueOf() {
        JSObject obj = JSObject.create();
        obj.set("id", 42);

        JSObject result = JSValue.checkedCoerce(obj.valueOf(), JSObject.class);
        int value = JSValue.checkedCoerce(result.get("id"), Integer.class);

        assertEquals(42, value);
    }

    public static void testValues() {
        JSObject obj = createTestObject();
        obj.set("age", "27");
        obj.set("active", "true");

        JSArray valueArray = JSValue.checkedCoerce(JSObject.values(obj), JSArray.class);
        AssertArray.assertArray(valueArray, String.class, "Alice", "27", "true");
    }

    private static void set(JSObject obj, JSValue value, boolean writable, boolean configurable) {
        obj.set("value", value);
        obj.set("writable", JSBoolean.of(writable));
        obj.set("enumerable", JSBoolean.of(true));
        obj.set("configurable", JSBoolean.of(configurable));
    }

    @SafeVarargs
    private static <T> void assertInnerArray(JSArray array, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(JSValue.checkedCoerce(array.get(i), JSObject.class).get("name"), String.class));
        }
    }

    private static JSObject createTestObject() {
        JSObject obj = JSObject.create();
        obj.set("name", "Alice");
        return obj;
    }

    @JS.Coerce
    @JS(value = "return fun.apply(thisArg, argsJSArray);")
    public static native <R> R apply(JSValue fun, JSValue thisArg, JSValue argsJSArray);

    @SafeVarargs
    @JS.Coerce
    @JS(value = "return fun.apply(thisArg, args);")
    public static native <T, R, Q> R apply(JSValue fun, Q thisArg, T... args);
}