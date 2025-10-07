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
        testSetAndGet();
        testHasAndDelete();
        testClearAndSize();
        testIteration();
        testGroupBy();
        testEdgeCases();
    }

    public static void testSetAndGet() {
        JSMap map = new JSMap();
        map.set("name", "Alice");
        map.set(42, true);
        map.set(false, 3.14);

        assertEquals("Alice", map.get("name", String.class));
        assertTrue(map.get(42, Boolean.class));
        assertEquals(3.14, map.get(false, Double.class), 1e-15);
    }

    public static void testHasAndDelete() {
        JSMap map = new JSMap();
        map.set(JSString.of("temp"), JSString.of("value"));
        map.set(42, "int-value");
        map.set(3.14, "pi-value");
        map.set(true, "truthy");
        map.set(false, "falsy");
        map.set("customKey", "customValue");

        boolean result1 = map.has(JSString.of("temp"));
        boolean deleted1 = map.delete(JSString.of("temp"));
        boolean result2 = map.has(JSString.of("temp"));
        boolean result3 = map.has(JSString.of("missing"));
        boolean result4 = map.has(42);
        boolean deleted2 = map.delete(42);
        boolean result5 = map.has(42);
        boolean result6 = map.has(99);
        boolean result7 = map.has(3.14);
        boolean deleted3 = map.delete(3.14);
        boolean result8 = map.has(3.14);
        boolean result9 = map.has(2.71);
        boolean result10 = map.has(true);
        boolean result11 = map.has(false);
        boolean deleted4 = map.delete(true);
        boolean result12 = map.has(true);
        boolean result13 = map.has(false);
        boolean result14 = map.has("customKey");
        boolean deleted5 = map.delete("customKey");
        boolean result15 = map.has("customKey");
        boolean result16 = map.has("unknownKey");

        assertTrue(result1);
        assertTrue(deleted1);
        assertFalse(result2);
        assertFalse(result3);
        assertTrue(result4);
        assertTrue(deleted2);
        assertFalse(result5);
        assertFalse(result6);
        assertTrue(result7);
        assertTrue(deleted3);
        assertFalse(result8);
        assertFalse(result9);
        assertTrue(result10);
        assertTrue(result11);
        assertTrue(deleted4);
        assertFalse(result12);
        assertTrue(result13);
        assertTrue(result14);
        assertTrue(deleted5);
        assertFalse(result15);
        assertFalse(result16);
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
        map.entries().forEach(JSFunction.fromJavaConsumer((JSObject obj) -> {
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

    public static void testGroupBy() {
        List<String> fruits = Arrays.asList("apple", "blueberry", "apricot", "cherry", "banana");
        JSArray jsArray = JSArray.of(fruits.toArray());
        JSIterator iterator = JSIterator.from(jsArray);
        JSFunction callback1 = JSFunction.fromJavaFunction((JSString item) -> JSString.of(item.asString().substring(0, 1)));
        JSFunction callback2 = JSFunction.fromFunction((JSString item) -> JSString.of(item.as(String.class).substring(0, 1)));

        JSMap groupedFromIterator = JSMap.groupBy(iterator, callback1);
        JSMap groupedFromArray = JSMap.groupBy(jsArray, callback1);
        JSMap groupedFromList = JSMap.groupBy(fruits, callback2);

        AssertArray.assertArray(JSValue.checkedCoerce(groupedFromIterator.get("a"), JSArray.class), String.class, "apple", "apricot");
        AssertArray.assertArray(JSValue.checkedCoerce(groupedFromIterator.get("b"), JSArray.class), String.class, "blueberry", "banana");
        AssertArray.assertArray(JSValue.checkedCoerce(groupedFromIterator.get("c"), JSArray.class), String.class, "cherry");
        AssertArray.assertArray(JSValue.checkedCoerce(groupedFromArray.get("a"), JSArray.class), String.class, "apple", "apricot");
        AssertArray.assertArray(JSValue.checkedCoerce(groupedFromArray.get("b"), JSArray.class), String.class, "blueberry", "banana");
        AssertArray.assertArray(JSValue.checkedCoerce(groupedFromArray.get("c"), JSArray.class), String.class, "cherry");
        AssertArray.assertArray(JSValue.checkedCoerce(groupedFromList.get("a"), JSArray.class), String.class, "apple", "apricot");
        AssertArray.assertArray(JSValue.checkedCoerce(groupedFromList.get("b"), JSArray.class), String.class, "blueberry", "banana");
        AssertArray.assertArray(JSValue.checkedCoerce(groupedFromList.get("c"), JSArray.class), String.class, "cherry");
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
