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
import org.graalvm.webimage.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class JSSetTest {

    public static void main(String[] args) {
        testAddAndHas();
        testJSSetOverwriting();
        testDeleteAndClear();
        testSetOperations();
        testSubsetAndSuperset();
        testIteration();
        testForEach();
        testEdgeCases();
    }

    public static void testAddAndHas() {
        JSSet set = new JSSet().add("apple").add(42).add(3.14).add(true).add(false);

        assertTrue(set.has("apple"));
        assertTrue(set.has(42));
        assertTrue(set.has(3.14));
        assertTrue(set.has(true));
        assertTrue(set.has(false));
        assertFalse(set.has("banana"));
        assertEquals(5, set.size);
    }

    public static void testJSSetOverwriting() {
        JSSet set = new JSSet();

        set.add("duplicate");
        set.add("duplicate");
        set.add("duplicate");
        boolean result1 = set.has("duplicate");
        int size1 = set.size;
        set.clear();
        set.add(1);
        set.add("1");
        boolean result2 = set.has(1);
        boolean result3 = set.has("1");
        int size2 = set.size;

        assertTrue(result1);
        assertEquals(1, size1);
        assertTrue(result2);
        assertTrue(result3);
        assertEquals(2, size2);
    }

    public static void testDeleteAndClear() {
        JSSet set = new JSSet();
        set.add("x").add("y").add(1).add(2.2).add(true);

        boolean result1 = set.has("x");
        boolean result2 = set.has("y");
        boolean result3 = set.has("z");
        boolean deleted1 = set.delete("x");
        boolean result4 = set.has("x");
        boolean result5 = set.has(1);
        boolean deleted2 = set.delete(1);
        boolean result6 = set.has(1);
        boolean result7 = set.has(2);
        boolean result8 = set.has(2.2);
        boolean result9 = set.has(3.3);
        boolean result10 = set.has(true);
        boolean result11 = set.has(false);
        boolean deleted3 = set.delete(2.2);
        boolean deleted4 = set.delete(true);
        int size1 = set.size;
        set.add(2.2).add("y").add(true);
        int size2 = set.size;
        set.clear();
        int size3 = set.size;
        boolean result12 = set.has("y");
        boolean result13 = set.has(2.2);
        boolean result14 = set.has(true);

        assertEquals(1, size1);
        assertEquals(3, size2);
        assertEquals(0, size3);
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertTrue(deleted1);
        assertFalse(result4);
        assertTrue(result5);
        assertTrue(deleted2);
        assertFalse(result6);
        assertFalse(result7);
        assertTrue(result8);
        assertFalse(result9);
        assertTrue(result10);
        assertFalse(result11);
        assertTrue(deleted3);
        assertTrue(deleted4);
        assertFalse(result12);
        assertFalse(result13);
        assertFalse(result14);
    }

    public static void testSetOperations() {
        JSSet a = new JSSet().add("a").add("b").add("c");
        JSSet b = new JSSet().add("b").add("c").add("d");

        JSSet union = a.union(b);
        JSSet intersection = a.intersection(b);
        JSSet difference = a.difference(b);
        JSSet symmetric = a.symmetricDifference(b);

        assertTrue(union.has("a"));
        assertTrue(union.has("d"));
        assertEquals(4, union.size);
        assertTrue(intersection.has("b"));
        assertFalse(intersection.has("a"));
        assertEquals(2, intersection.size);
        assertTrue(difference.has("a"));
        assertFalse(difference.has("b"));
        assertEquals(1, difference.size);
        assertTrue(symmetric.has("a"));
        assertTrue(symmetric.has("d"));
        assertFalse(symmetric.has("b"));
        assertEquals(2, symmetric.size);
    }

    public static void testSubsetAndSuperset() {
        JSSet full = new JSSet().add("x").add("y").add("z");
        JSSet part = new JSSet().add("x").add("y");
        JSSet disjoint = new JSSet().add("a").add("b");

        assertTrue(part.isSubsetOf(full));
        assertTrue(full.isSupersetOf(part));
        assertTrue(full.isDisjointFrom(disjoint));
        assertFalse(part.isDisjointFrom(full));
    }

    public static void testIteration() {
        JSSet set = new JSSet().add("one").add("two").add("three");
        List<String> results = new ArrayList<>();

        JSIterator keys = set.setKeys();
        JSIterator values = set.values();
        JSIterator entries = set.entries();
        JSArray entry1 = JSValue.checkedCoerce(entries.next().get("value"), JSArray.class);
        JSArray entry2 = JSValue.checkedCoerce(entries.next().get("value"), JSArray.class);
        JSArray entry3 = JSValue.checkedCoerce(entries.next().get("value"), JSArray.class);
        set.entries().forEach(JSFunction.fromCons((JSObject obj) -> {
            JSArray entry = JSValue.checkedCoerce(obj, JSArray.class);
            String key = JSValue.checkedCoerce(entry.get(0), String.class);
            String value = JSValue.checkedCoerce(entry.get(1), String.class);
            results.addLast("Key: " + key + " value: " + value);
        }));

        assertEquals("one", JSValue.checkedCoerce(keys.next().get("value"), String.class));
        assertEquals("two", JSValue.checkedCoerce(keys.next().get("value"), String.class));
        assertEquals("three", JSValue.checkedCoerce(keys.next().get("value"), String.class));
        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(keys.next().get("value"), JSUndefined.class));
        assertEquals("one", JSValue.checkedCoerce(values.next().get("value"), String.class));
        assertEquals("two", JSValue.checkedCoerce(values.next().get("value"), String.class));
        assertEquals("three", JSValue.checkedCoerce(values.next().get("value"), String.class));
        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(values.next().get("value"), JSUndefined.class));
        assertEquals("one", JSValue.checkedCoerce(entry1.get(0), String.class));
        assertEquals("one", JSValue.checkedCoerce(entry1.get(1), String.class));
        assertEquals("two", JSValue.checkedCoerce(entry2.get(0), String.class));
        assertEquals("two", JSValue.checkedCoerce(entry2.get(1), String.class));
        assertEquals("three", JSValue.checkedCoerce(entry3.get(0), String.class));
        assertEquals("three", JSValue.checkedCoerce(entry3.get(1), String.class));
        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(entries.next().get("value"), JSUndefined.class));
        assertEquals(List.of("Key: one value: one", "Key: two value: two", "Key: three value: three"), results);
    }

    public static void testForEach() {
        JSSet set = new JSSet().add("alpha").add("beta").add("gamma");
        JSValue thisValue = JSString.of("context:JSValue");
        List<String> collected = new ArrayList<>();
        List<List<List<String>>> values = List.of(
                List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
                List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        );

        set.forEach(JSFunction.fromCons((JSValue value) -> {
            String str = JSValue.checkedCoerce(value, String.class);
            collected.addLast(str);
        }));
        set.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString _) -> {
            values.getFirst().getFirst().addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).getFirst().addLast(JSValue.checkedCoerce(ctx, String.class));
        }), thisValue);
        set.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString _) -> {
            values.getFirst().get(1).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(1).addLast(JSValue.checkedCoerce(ctx, Integer.class).toString());
        }), 42);
        set.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString _) -> {
            values.getFirst().get(2).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(2).addLast(JSValue.checkedCoerce(ctx, Double.class).toString());
        }), 3.14);
        set.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString _) -> {
            values.getFirst().get(3).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(3).addLast(JSValue.checkedCoerce(ctx, Boolean.class).toString());
        }), true);
        set.forEach(JSFunction.fromBiConsWithThis((JSValue ctx, JSString value, JSString _) -> {
            values.getFirst().get(4).addLast(JSValue.checkedCoerce(value, String.class));
            values.get(1).get(4).addLast(JSValue.checkedCoerce(ctx, String.class));
        }), "context:Object");

        assertEquals(List.of("alpha", "beta", "gamma"), collected);
        for(List<String> list : values.getFirst()) {
            assertEquals(List.of("alpha", "beta", "gamma"), list);
        }
        assertEquals(List.of("context:JSValue", "context:JSValue", "context:JSValue"), values.get(1).getFirst());
        assertEquals(List.of("42", "42", "42"), values.get(1).get(1));
        assertEquals(List.of("3.14", "3.14", "3.14"), values.get(1).get(2));
        assertEquals(List.of("true", "true", "true"), values.get(1).get(3));
        assertEquals(List.of("context:Object", "context:Object", "context:Object"), values.get(1).get(4));
    }

    public static void testEdgeCases() {
        JSSet set = new JSSet();
        JSSet empty = new JSSet();

        set.add("dup").add("dup").add("dup");
        int size1 = set.size;
        set.add(null);
        boolean result1 = set.has(null);
        set.delete(null);
        boolean result2 = set.has(null);
        set.add(1).add(1.0).add("1");
        boolean result3 = set.has(1);
        boolean result4 = set.has(1.0);
        boolean result5 = set.has("1");
        int size2 = set.size;

        assertEquals(1, size1);
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertTrue(result5);
        assertEquals(3, size2);
        assertTrue(empty.isDisjointFrom(set));
        assertTrue(empty.isSubsetOf(set));
        assertFalse(empty.isSupersetOf(set));
    }
}
