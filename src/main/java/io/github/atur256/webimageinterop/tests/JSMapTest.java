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

package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.*;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
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

        map.set(JSString.of("key1:js"), JSString.of("value:js"))
                .set(JSString.of("key2:js"), 100)
                .set(JSString.of("key3:js"), 2.718)
                .set(JSString.of("key4:js"), true)
                .set(JSString.of("key5:js"), "value:js-object");

        assertEquals("value:js", map.get(JSString.of("key1:js"), String.class));
        assertEquals(Integer.valueOf(100), map.get(JSString.of("key2:js"), Integer.class));
        assertEquals(2.718, map.get(JSString.of("key3:js"), Double.class), 1e-15);
        assertTrue(map.get(JSString.of("key4:js"), Boolean.class));
        assertEquals("value:js-object", map.get(JSString.of("key5:js"), String.class));
    }

    public static void testSetAndGetWithIntKey() {
        JSMap map = new JSMap();

        map.set(1, JSString.of("value:int-js"))
                .set(2, 777)
                .set(3, 3.1415)
                .set(4, false)
                .set(5, "value:int-object");

        assertEquals("value:int-js", map.get(1, String.class));
        assertEquals(Integer.valueOf(777), map.get(2, Integer.class));
        assertEquals(3.1415, map.get(3, Double.class), 1e-15);
        assertFalse(map.get(4, Boolean.class));
        assertEquals("value:int-object", map.get(5, String.class));
    }

    public static void testSetAndGetWithDoubleKey() {
        JSMap map = new JSMap();

        map.set(1.1, JSString.of("value:double-js"))
                .set(2.2, 1618)
                .set(3.3, 0.5772)
                .set(4.4, true)
                .set(5.5, "value:double-object");

        assertEquals("value:double-js", map.get(1.1, String.class));
        assertEquals(Integer.valueOf(1618), map.get(2.2, Integer.class));
        assertEquals(0.5772, map.get(3.3, Double.class), 1e-15);
        assertTrue(map.get(4.4, Boolean.class));
        assertEquals("value:double-object", map.get(5.5, String.class));
    }

    public static void testSetAndGetWithBooleanKey() {
        JSMap map = new JSMap();

        map.set(true, JSString.of("value:bool-js"));
        String result1 = map.get(true, String.class);
        map.set(false, 1);
        int result2 = map.get(false, Integer.class);
        map.set(true, 0.0);
        double result3 = map.get(true, Double.class);
        map.set(false, false);
        boolean result4 = map.get(false, Boolean.class);
        map.set(false, "value:bool-object");
        String result5 = map.get(false, String.class);

        assertEquals("value:bool-js", result1);
        assertEquals(1, result2);
        assertEquals(0.0, result3, 0.0);
        assertFalse(result4);
        assertEquals("value:bool-object", result5);
    }

    public static void testSetAndGetWithObjectKey() {
        JSMap map = new JSMap();

        map.set("key1:object", JSString.of("value:object-js"));
        String result1 = map.get("key1:object", String.class);
        map.set("key2:object", 123);
        int result2 = map.get("key2:object", Integer.class);
        map.set("key3:object", 6.022);
        double result3 = map.get("key3:object", Double.class);
        map.set("key4:object", false);
        boolean result4 = map.get("key4:object", Boolean.class);
        map.set("key5:object", "value:object-generic");
        String result6 = map.get("key5:object", String.class);

        assertEquals("value:object-js", result1);
        assertEquals(123, result2);
        assertEquals(6.022, result3, 0.0);
        assertFalse(result4);
        assertEquals("value:object-generic", result6);
    }

    public static void testJSMapOverwrite() {
        JSMap map = new JSMap();

        map.set("key", "first");
        String result1 = map.get("key", String.class);
        map.set("key", "second");
        String result2 = map.get("key", String.class);
        map.set("key", 123);
        int result3 = map.get("key", Integer.class);
        map.set("key", true);
        boolean result4 = map.get("key", Boolean.class);
        map.set("key", 3.14);
        double result5 = map.get("key", Double.class);

        assertEquals("first", result1);
        assertEquals("second", result2);
        assertEquals(123, result3);
        assertTrue(result4);
        assertEquals(3.14, result5, 0.0);
    }

    public static void testHasAndDelete() {
        JSMap map = new JSMap();
        map.set(JSString.of("temp"), JSString.of("value"));
        map.set(42, "int-value");
        map.set(3.14, "pi-value");
        map.set(true, "truthy");
        map.set(false, "falsy");
        map.set("customKey", "customValue");

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
        map.set("a", 1);
        map.set("b", 2);

        int size1 = map.size;
        map.clear();
        int size2 = map.size;

        assertTrue(size1 >= 2);
        assertEquals(0, size2);
        assertFalse(map.has("a"));
    }

    static void testIteration() {
        JSMap map = new JSMap();
        map.set("x", 10);
        map.set("y", 20);
        List<String> results = new ArrayList<>();

        JSIterator keys = map.keys();
        JSIterator values = map.values();
        JSIterator entries = map.entries();
        JSArray entry1 = JSValue.checkedCoerce(entries.next().get("value"), JSArray.class);
        JSArray entry2 = JSValue.checkedCoerce(entries.next().get("value"), JSArray.class);
        map.entries().forEach(JSFunction.fromCons((JSObject obj) -> {
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
        map.set("a", "alpha");
        map.set("b", "beta");
        map.set("c", "gamma");
        JSValue thisValue = JSString.of("context:JSValue");
        List<String> collected = new ArrayList<>();
        List<List<List<String>>> values = List.of(
                List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
                List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
                List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        );

        map.forEach(JSFunction.fromCons((JSValue value) -> {
            String str = JSValue.checkedCoerce(value, String.class);
            collected.addLast(str);
        }));
        map.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString key) -> {
            values.getFirst().getFirst().addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).getFirst().addLast(JSValue.checkedCoerce(key, String.class));
            values.get(2).getFirst().addLast(JSValue.checkedCoerce(ctx, String.class));
        }), thisValue);
        map.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString key) -> {
            values.getFirst().get(1).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(1).addLast(JSValue.checkedCoerce(key, String.class));
            values.get(2).get(1).addLast(JSValue.checkedCoerce(ctx, Integer.class).toString());
        }), 42);
        map.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString key) -> {
            values.getFirst().get(2).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(2).addLast(JSValue.checkedCoerce(key, String.class));
            values.get(2).get(2).addLast(JSValue.checkedCoerce(ctx, Double.class).toString());
        }), 3.14);
        map.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString key) -> {
            values.getFirst().get(3).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(3).addLast(JSValue.checkedCoerce(key, String.class));
            values.get(2).get(3).addLast(JSValue.checkedCoerce(ctx, Boolean.class).toString());
        }), true);
        map.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString key) -> {
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
        JSFunction callback1 = JSFunction.fromFunc((JSString item) -> JSString.of(item.asString().substring(0, 1)));
        JSFunction callback2 = JSFunction.fromFunc((JSString item) -> JSString.of(item.as(String.class).substring(0, 1)));

        JSMap groupedFromIterator = JSMap.groupBy(iterator, callback1);
        JSMap groupedFromArray = JSMap.groupBy(jsArray, callback1);
        JSMap groupedFromList = JSMap.groupBy(fruits, callback2);

        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromIterator.get("a"), JSArray.class), String.class, "apple", "apricot");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromIterator.get("b"), JSArray.class), String.class, "blueberry", "banana");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromIterator.get("c"), JSArray.class), String.class, "cherry");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromArray.get("a"), JSArray.class), String.class, "apple", "apricot");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromArray.get("b"), JSArray.class), String.class, "blueberry", "banana");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromArray.get("c"), JSArray.class), String.class, "cherry");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromList.get("a"), JSArray.class), String.class, "apple", "apricot");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromList.get("b"), JSArray.class), String.class, "blueberry", "banana");
        AssertArray.assertArray(JSValue.checkedCoerce(
                groupedFromList.get("c"), JSArray.class), String.class, "cherry");
    }

    static void testEdgeCases() {
        JSMap map = new JSMap();
        map.set("x", 1);
        map.set("x", 2);
        map.set(null, "nullKey");
        map.set("nullValue", null);
        map.set(1, "int");
        map.set("1", "string");
        map.set(true, "yes");
        map.set(false, "no");
        JSMap empty = new JSMap();

        assertEquals(Integer.valueOf(2), map.get("x", Integer.class));
        assertEquals("nullKey", map.get(null, String.class));
        assertNull(map.get("nullValue", Object.class));
        assertEquals("int", map.get(1, String.class));
        assertEquals("string", map.get("1", String.class));
        assertEquals("yes", map.get(true, String.class));
        assertEquals("no", map.get(false, String.class));
        assertEquals(0, empty.size);
        assertFalse(empty.has("anything"));
        assertEquals(JSUndefined.undefined(), empty.get("anything", Object.class));
    }
}
