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

import io.github.atur256.graalvmwebimageinterop.builtin.*;
import io.github.atur256.graalvmwebimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSUndefined;
import org.graalvm.webimage.api.JSValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class JSMapTest {

    public static void main(String[] args) {
        testSetAndGetWithJSValueKey();
        testSetAndGetWithIntKey();
        testSetAndGetWithDoubleKey();
        testSetAndGetWithBooleanKey();
        testSetAndGetWithObjectKey();
        testJSMapOverwrite();
        testHasAndDelete();
        testClearAndSize();
        testIteration();
        testForEach();
        testGroupBy();
        testEdgeCases();
    }

    public static void testSetAndGetWithJSValueKey() {
        JSMap map = new JSMap();

        map.setValue(JSString.of("key1:js"), JSString.of("value:js"))
                .setValue(JSString.of("key2:js"), 100)
                .setValue(JSString.of("key3:js"), 2.718)
                .setValue(JSString.of("key4:js"), true)
                .setValue(JSString.of("key5:js"), "value:js-object");

        assertEquals("value:js", map.getValue(JSString.of("key1:js"), String.class));
        assertEquals(Integer.valueOf(100), map.getValue(JSString.of("key2:js"), Integer.class));
        assertEquals(2.718, map.getValue(JSString.of("key3:js"), Double.class), 1e-15);
        assertTrue(map.getValue(JSString.of("key4:js"), Boolean.class));
        assertEquals("value:js-object", map.getValue(JSString.of("key5:js"), String.class));
    }

    public static void testSetAndGetWithIntKey() {
        JSMap map = new JSMap();

        map.setValue(1, JSString.of("value:int-js"))
                .setValue(2, 777)
                .setValue(3, 3.1415)
                .setValue(4, false)
                .setValue(5, "value:int-object");

        assertEquals("value:int-js", map.getValue(1, String.class));
        assertEquals(Integer.valueOf(777), map.getValue(2, Integer.class));
        assertEquals(3.1415, map.getValue(3, Double.class), 1e-15);
        assertFalse(map.getValue(4, Boolean.class));
        assertEquals("value:int-object", map.getValue(5, String.class));
    }

    public static void testSetAndGetWithDoubleKey() {
        JSMap map = new JSMap();

        map.setValue(1.1, JSString.of("value:double-js"))
                .setValue(2.2, 1618)
                .setValue(3.3, 0.5772)
                .setValue(4.4, true)
                .setValue(5.5, "value:double-object");

        assertEquals("value:double-js", map.getValue(1.1, String.class));
        assertEquals(Integer.valueOf(1618), map.getValue(2.2, Integer.class));
        assertEquals(0.5772, map.getValue(3.3, Double.class), 1e-15);
        assertTrue(map.getValue(4.4, Boolean.class));
        assertEquals("value:double-object", map.getValue(5.5, String.class));
    }

    public static void testSetAndGetWithBooleanKey() {
        JSMap map = new JSMap();

        map.setValue(true, JSString.of("value:bool-js"));
        String result1 = map.getValue(true, String.class);
        map.setValue(false, 1);
        int result2 = map.getValue(false, Integer.class);
        map.setValue(true, 0.0);
        double result3 = map.getValue(true, Double.class);
        map.setValue(false, false);
        boolean result4 = map.getValue(false, Boolean.class);
        map.setValue(false, "value:bool-object");
        String result5 = map.getValue(false, String.class);

        assertEquals("value:bool-js", result1);
        assertEquals(1, result2);
        assertEquals(0.0, result3, 0.0);
        assertFalse(result4);
        assertEquals("value:bool-object", result5);
    }

    public static void testSetAndGetWithObjectKey() {
        JSMap map = new JSMap();

        map.setValue("key1:object", JSString.of("value:object-js"));
        String result1 = map.getValue("key1:object", String.class);
        map.setValue("key2:object", 123);
        int result2 = map.getValue("key2:object", Integer.class);
        map.setValue("key3:object", 6.022);
        double result3 = map.getValue("key3:object", Double.class);
        map.setValue("key4:object", false);
        boolean result4 = map.getValue("key4:object", Boolean.class);
        map.setValue("key5:object", "value:object-generic");
        String result6 = map.getValue("key5:object", String.class);

        assertEquals("value:object-js", result1);
        assertEquals(123, result2);
        assertEquals(6.022, result3, 0.0);
        assertFalse(result4);
        assertEquals("value:object-generic", result6);
    }

    public static void testJSMapOverwrite() {
        JSMap map = new JSMap();

        map.setValue("key", "first");
        String result1 = map.getValue("key", String.class);
        map.setValue("key", "second");
        String result2 = map.getValue("key", String.class);
        map.setValue("key", 123);
        int result3 = map.getValue("key", Integer.class);
        map.setValue("key", true);
        boolean result4 = map.getValue("key", Boolean.class);
        map.setValue("key", 3.14);
        double result5 = map.getValue("key", Double.class);

        assertEquals("first", result1);
        assertEquals("second", result2);
        assertEquals(123, result3);
        assertTrue(result4);
        assertEquals(3.14, result5, 0.0);
    }

    public static void testHasAndDelete() {
        JSMap map = new JSMap();
        map.setValue(JSString.of("temp"), JSString.of("value"));
        map.setValue(42, "int-value");
        map.setValue(3.14, "pi-value");
        map.setValue(true, "truthy");
        map.setValue(false, "falsy");
        map.setValue("customKey", "customValue");

        assertTrue(map.has(JSString.of("temp")));
        assertTrue(map.delete(JSString.of("temp")));
        assertFalse(map.has(JSString.of("temp")));
        assertFalse(map.has(JSString.of("missing")));
        assertTrue(map.has(42));
        assertTrue(map.delete(42));
        assertFalse(map.has(42));
        assertFalse(map.has(99));
        assertTrue(map.has(3.14));
        assertTrue(map.delete(3.14));
        assertFalse(map.has(3.14));
        assertFalse(map.has(2.71));
        assertTrue(map.has(true));
        assertTrue(map.has(false));
        assertTrue(map.delete(true));
        assertFalse(map.has(true));
        assertTrue(map.has(false));
        assertTrue(map.has("customKey"));
        assertTrue(map.delete("customKey"));
        assertFalse(map.has("customKey"));
        assertFalse(map.has("unknownKey"));
    }

    public static void testClearAndSize() {
        JSMap map = new JSMap();
        map.setValue("a", 1);
        map.setValue("b", 2);

        int size1 = map.size;
        map.clear();
        int size2 = map.size;

        assertTrue(size1 >= 2);
        assertEquals(0, size2);
        assertFalse(map.has("a"));
    }

    static void testIteration() {
        JSMap map = new JSMap();
        map.setValue("x", 10);
        map.setValue("y", 20);
        List<String> results = new ArrayList<>();

        JSIterator keys = map.mapKeys();
        JSIterator values = map.values();
        JSIterator entries = map.entries();
        JSArray entry1 = JSValue.checkedCoerce(entries.next().get("value"), JSArray.class);
        JSArray entry2 = JSValue.checkedCoerce(entries.next().get("value"), JSArray.class);
        map.entries().forEach(JSFunction.of((JSObject obj) -> {
            JSArray entry = JSValue.checkedCoerce(obj, JSArray.class);
            String key = JSValue.checkedCoerce(entry.get(0), String.class);
            int value = JSValue.checkedCoerce(entry.get(1), Integer.class);
            results.addLast("Key: " + key + " value: " + value);
        }));

        assertEquals("x", JSValue.checkedCoerce(keys.next().get("value"), String.class));
        assertEquals("y", JSValue.checkedCoerce(keys.next().get("value"), String.class));
        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(keys.next().get("value"), JSUndefined.class));
        assertEquals(Integer.valueOf(10), JSValue.checkedCoerce(values.next().get("value"), Integer.class));
        assertEquals(Integer.valueOf(20), JSValue.checkedCoerce(values.next().get("value"), Integer.class));
        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(values.next().get("value"), JSUndefined.class));
        assertEquals("x", JSValue.checkedCoerce(entry1.get(0), String.class));
        assertEquals(Integer.valueOf(10), JSValue.checkedCoerce(entry1.get(1), Integer.class));
        assertEquals("y", JSValue.checkedCoerce(entry2.get(0), String.class));
        assertEquals(Integer.valueOf(20), JSValue.checkedCoerce(entry2.get(1), Integer.class));
        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(entries.next().get("value"), JSUndefined.class));
        assertEquals(List.of("Key: x value: 10", "Key: y value: 20"), results);
    }

    public static void testForEach() {
        JSMap map = new JSMap();
        map.setValue("a", "alpha");
        map.setValue("b", "beta");
        map.setValue("c", "gamma");
        JSValue thisValue = JSString.of("context:JSValue");
        List<String> collected = new ArrayList<>();
        List<List<List<String>>> values = List.of(
                List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
                List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
                List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        );

        map.forEach(JSFunction.of((JSValue value) -> {
            String str = JSValue.checkedCoerce(value, String.class);
            collected.addLast(str);
        }));
        map.forEach(JSFunction.withThis((JSValue ctx, JSString value, JSString key) -> {
            values.getFirst().getFirst().addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).getFirst().addLast(JSValue.checkedCoerce(key, String.class));
            values.get(2).getFirst().addLast(JSValue.checkedCoerce(ctx, String.class));
        }), thisValue);
        map.forEach(JSFunction.withThis((JSValue ctx, JSString value, JSString key) -> {
            values.getFirst().get(1).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(1).addLast(JSValue.checkedCoerce(key, String.class));
            values.get(2).get(1).addLast(JSValue.checkedCoerce(ctx, Integer.class).toString());
        }), 42);
        map.forEach(JSFunction.withThis((JSValue ctx, JSString value, JSString key) -> {
            values.getFirst().get(2).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(2).addLast(JSValue.checkedCoerce(key, String.class));
            values.get(2).get(2).addLast(JSValue.checkedCoerce(ctx, Double.class).toString());
        }), 3.14);
        map.forEach(JSFunction.withThis((JSValue ctx, JSString value, JSString key) -> {
            values.getFirst().get(3).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(3).addLast(JSValue.checkedCoerce(key, String.class));
            values.get(2).get(3).addLast(JSValue.checkedCoerce(ctx, Boolean.class).toString());
        }), true);
        map.forEach(JSFunction.withThis((JSValue ctx, JSString value, JSString key) -> {
            values.getFirst().get(4).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(4).addLast(JSValue.checkedCoerce(key, String.class));
            values.get(2).get(4).addLast(JSValue.checkedCoerce(ctx, String.class));
        }), "context:Object");

        assertEquals(List.of("alpha", "beta", "gamma"), collected);
        for(List<String> list : values.getFirst()) {
            assertEquals(List.of("alpha", "beta", "gamma"), list);
        }
        for(List<String> list : values.get(1)) {
            assertEquals(List.of("a", "b", "c"), list);
        }
        assertEquals(List.of("context:JSValue", "context:JSValue", "context:JSValue"), values.get(2).getFirst());
        assertEquals(List.of("42", "42", "42"), values.get(2).get(1));
        assertEquals(List.of("3.14", "3.14", "3.14"), values.get(2).get(2));
        assertEquals(List.of("true", "true", "true"), values.get(2).get(3));
        assertEquals(List.of("context:Object", "context:Object", "context:Object"), values.get(2).get(4));
    }

    public static void testGroupBy() {
        List<String> fruits = Arrays.asList("apple", "blueberry", "apricot", "cherry", "banana");
        JSArray jsArray = JSArray.of(fruits.toArray());
        JSIterator iterator = JSIterator.from(jsArray);
        JSFunction callback1 = JSFunction.of((JSString item) -> JSString.of(item.asString().substring(0, 1)));
        JSFunction callback2 = JSFunction.of((JSString item) -> JSString.of(item.as(String.class).substring(0, 1)));

        JSMap groupedFromIterator = JSMap.groupBy(iterator, callback1);
        JSMap groupedFromArray = JSMap.groupBy(jsArray, callback1);
        JSMap groupedFromList = JSMap.groupBy(fruits, callback2);

        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromIterator.getValue("a"), JSArray.class), String.class, "apple", "apricot");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromIterator.getValue("b"), JSArray.class), String.class, "blueberry", "banana");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromIterator.getValue("c"), JSArray.class), String.class, "cherry");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromArray.getValue("a"), JSArray.class), String.class, "apple", "apricot");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromArray.getValue("b"), JSArray.class), String.class, "blueberry", "banana");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromArray.getValue("c"), JSArray.class), String.class, "cherry");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromList.getValue("a"), JSArray.class), String.class, "apple", "apricot");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromList.getValue("b"), JSArray.class), String.class, "blueberry", "banana");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromList.getValue("c"), JSArray.class), String.class, "cherry");
    }

    static void testEdgeCases() {
        JSMap map = new JSMap();
        map.setValue("x", 1);
        map.setValue("x", 2);
        map.setValue(null, "nullKey");
        map.setValue("nullValue", null);
        map.setValue(1, "int");
        map.setValue("1", "string");
        map.setValue(true, "yes");
        map.setValue(false, "no");
        JSMap empty = new JSMap();

        assertEquals(Integer.valueOf(2), map.getValue("x", Integer.class));
        assertEquals("nullKey", map.getValue(null, String.class));
        assertNull(map.getValue("nullValue", Object.class));
        assertEquals("int", map.getValue(1, String.class));
        assertEquals("string", map.getValue("1", String.class));
        assertEquals("yes", map.getValue(true, String.class));
        assertEquals("no", map.getValue(false, String.class));
        assertEquals(0, empty.size);
        assertFalse(empty.has("anything"));
        assertEquals(JSUndefined.undefined(), empty.getValue("anything", Object.class));
    }
}
