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
import io.github.atur256.graalvmwebimageinterop.builtin.JSPromise;
import org.graalvm.webimage.api.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static io.github.atur256.graalvmwebimageinterop.tests.AssertArrayUtils.assertArray;
import static org.junit.jupiter.api.Assertions.*;


public class JSArrayTest {

    private static final JSArray BASE = JSArray.of("a", "b", "c", "d", "e");
    private static final JSArray EMPTY = JSArray.of();
    private static final JSArray MIXED = JSArray.of("1", 2, true);
    private static final JSArray NESTED = JSArray.of(JSArray.of(JSArray.of("deep")));
    private static final JSArray WITH_NULLS = JSArray.of(null, "a", null);
    private static final JSArray MAP_UNDEFINED = JSArray.of("a", "b");
    private static final JSArray STRINGS = JSArray.from("xyz");
    private static final JSArray BOOLEANS = JSArray.of(true, false, true);
    private static final JSArray UNSORTED = JSArray.of("c", "a", "b");

    public static void main(String[] args) {
        testOf();
        testLength();
        testFromAndFromAsync();
        testIsArray();
        testConcat();
        testCopyWithin();
        testIndexAccess();
        testMap();
        testPopPush();
        testReduce();
        testReverse();
        testShiftUnshift();
        testFill();
        testSliceSplice();
        testFindMethods();
        testFlatFlatMap();
        testForEach();
        testIncludesJoin();
        testKeysValuesEntries();
        testSomeEvery();
        testSortToSorted();
        testToLocaleStringToString();
        testWith();
        testFilter();
        testEntries();
    }


    public static void testOf() {
        JSArray testArr1 = JSArray.of("a", "o", "c", "d", "e");
        JSArray testArr2 = JSArray.of(1, 2, 3, 4);
        JSArray testArr3 = JSArray.of(1.1, 2.2, 3.3, 4.4);
        JSArray testArr4 = JSArray.of(true, false, false);

        assertArray(testArr1, String.class, "a", "b", "c", "d", "e");
        assertArray(testArr2, Integer.class, 1, 2, 3, 4);
        assertArray(testArr3, Double.class, 1.1, 2.2, 3.3, 4.4);
        assertArray(testArr4, Boolean.class, true, false, false);
    }

    public static void testLength() {
        assertEquals(5, BASE.length);
        assertEquals(0, EMPTY.length);
        assertEquals(3, WITH_NULLS.length);
    }

    public static void testFromAndFromAsync() {
        JSArray original = JSArray.of(1, 2, 3);
        JSValue[] jsValues = {JSNumber.of(1), JSNumber.of(2)};
        Object[] objArray = {"x", "y"};
        Object obj = new Object();

        JSArray fromNull = JSArray.from(null);
        JSArray fromJSArray = JSArray.from(original);
        JSArray fromString = JSArray.from("abc");
        JSArray fromJSValues = JSArray.from(jsValues);
        JSArray fromObjArray = JSArray.from(objArray);
        JSArray fromIntArray = JSArray.from(new int[]{1, 2});
        JSArray fromDoubleArray = JSArray.from(new double[]{1.5, 2.5});
        JSArray fromBooleanArray = JSArray.from(new boolean[]{true, false});
        JSArray fromCharArray = JSArray.from(new char[]{'a', 'b'});
        JSArray fromByteArray = JSArray.from(new byte[]{1, 2});
        JSArray fromShortArray = JSArray.from(new short[]{3, 4});
        JSArray fromLongArray = JSArray.from(new long[]{5, 6});
        JSArray fromFloatArray = JSArray.from(new float[]{7.5f, 8.5f});
        JSArray fromIterable = JSArray.from(List.of("foo", "bar"));
        JSArray fromObj = JSArray.from(obj);
        JSPromise promise = JSArray.fromAsync(JSString.of("abc"));
        JSPromise promiseString = JSArray.fromAsync("abc");
        JSPromise promiseObjArray = JSArray.fromAsync(new Object[]{"x", "y"});
        JSPromise promiseIntArray = JSArray.fromAsync(new int[]{1, 2});
        JSPromise promiseIterable = JSArray.fromAsync(List.of("i1", "i2"));
        JSPromise promiseObj = JSArray.fromAsync(obj);

        assertEquals(0, fromNull.length);
        assertArray(fromJSArray, Integer.class, 1, 2, 3);
        assertArray(fromString, String.class, "a", "b", "c");
        assertArray(fromJSValues, Integer.class, 1, 2);
        assertArray(fromObjArray, String.class, "x", "y");
        assertArray(fromIntArray, Integer.class, 1, 2);
        assertArray(fromDoubleArray, Double.class, 1.5, 2.5);
        assertArray(fromBooleanArray, Boolean.class, true, false);
        assertArray(fromCharArray, String.class, "a", "b");
        assertArray(fromByteArray, Byte.class, (byte) 1, (byte) 2);
        assertArray(fromShortArray, Short.class, (short) 3, (short) 4);
        assertArray(fromLongArray, Long.class, 5L, 6L);
        assertArray(fromFloatArray, Float.class, 7.5f, 8.5f);
        assertArray(fromIterable, String.class, "foo", "bar");
        assertEquals(1, fromObj.length);
        assertEquals(obj, fromObj.at(0));
        assertEquals("JavaScript<object; [object Promise]>", promise.toString());
        assertEquals("JavaScript<object; [object Promise]>", promiseString.toString());
        assertEquals("JavaScript<object; [object Promise]>", promiseObjArray.toString());
        assertEquals("JavaScript<object; [object Promise]>", promiseIntArray.toString());
        assertEquals("JavaScript<object; [object Promise]>", promiseIterable.toString());
        assertEquals("JavaScript<object; [object Promise]>", promiseObj.toString());
    }

    public static void testIsArray() {
        assertTrue(JSArray.isArray(BASE));
        assertTrue(JSArray.isArray(EMPTY));
        assertFalse(JSArray.isArray(JSString.of("not-an-array")));
    }

    public static void testConcat() {
        // Base arrays
        JSArray strings = JSArray.of("d", "e", "x", "y", "z");
        JSArray empty = JSArray.of();

        // Object[] array
        Object[] objectArray = new Object[]{"obj1", "obj2"};

        // Primitive arrays
        int[] intArray = {1, 2, 3};
        double[] doubleArray = {1.1, 2.2, 3.3};
        boolean[] booleanArray = {true, false, true};

        // Iterables
        List<String> iterableList = List.of("i1", "i2", "i3");
        Set<String> iterableSet = new LinkedHashSet<>(List.of("s1", "s2", "s3"));

        // Default fallback (single object)
        Object singleObject = "fallback";

        // JSArray (should create a copy, not the same instance)
        JSArray jsArrayCopy = JSArray.from(JSArray.of("copy1", "copy2"));

        JSArray jsArrayOfArrays = JSArray.from(new JSArray[]{JSArray.from(new int[]{1, 2, 3}), JSArray.from(new int[]{4, 5, 6})});

        // Test concat with all types
        JSArray result = empty.concat(
                strings,
                objectArray,
                intArray,
                doubleArray,
                booleanArray,
                iterableList,
                iterableSet,
                singleObject,
                jsArrayCopy,
                jsArrayOfArrays,
                null
        );

        assertEquals(27, result.length);
        assertEquals("d", result.at(0, String.class));
        assertEquals("e", result.at(1, String.class));
        assertEquals("x", result.at(2, String.class));
        assertEquals("y", result.at(3, String.class));
        assertEquals("z", result.at(4, String.class));
        assertEquals("obj1", result.at(5, String.class));
        assertEquals("obj2", result.at(6, String.class));
        assertEquals(Integer.valueOf(1), result.at(7, Integer.class));
        assertEquals(Integer.valueOf(2), result.at(8, Integer.class));
        assertEquals(Integer.valueOf(3), result.at(9, Integer.class));
        assertEquals(1.1, result.at(10, Double.class), 0.0);
        assertEquals(2.2, result.at(11, Double.class), 0.0);
        assertEquals(3.3, result.at(12, Double.class), 0.0);
        assertTrue(result.at(13, Boolean.class));
        assertFalse(result.at(14, Boolean.class));
        assertTrue(result.at(15, Boolean.class));
        assertEquals("i1", result.at(16, String.class));
        assertEquals("i2", result.at(17, String.class));
        assertEquals("i3", result.at(18, String.class));
        assertEquals("s1", result.at(19, String.class));
        assertEquals("s2", result.at(20, String.class));
        assertEquals("s3", result.at(21, String.class));
        assertEquals("fallback", JSValue.checkedCoerce(result.at(22), String.class));
        assertEquals("copy1", result.at(23, String.class));
        assertEquals("copy2", result.at(24, String.class));
        assertEquals(Integer.valueOf(1), result.at(25, JSArray.class).at(0, Integer.class));
        assertEquals(Integer.valueOf(2), result.at(25, JSArray.class).at(1, Integer.class));
        assertEquals(Integer.valueOf(3), result.at(25, JSArray.class).at(2, Integer.class));
        assertEquals(Integer.valueOf(4), result.at(26, JSArray.class).at(0, Integer.class));
        assertEquals(Integer.valueOf(5), result.at(26, JSArray.class).at(1, Integer.class));
        assertEquals(Integer.valueOf(6), result.at(26, JSArray.class).at(2, Integer.class));
    }

    public static void testCopyWithin() {
        JSArray baseClone = JSArray.from(BASE);
        JSArray copied = JSArray.from(baseClone).copyWithin(0, 3, 5);

        assertArray(copied, String.class, "d", "e", "c", "d", "e");
    }

    public static void testIndexAccess() {
        JSArray jsValueArray = JSArray.of(JSNumber.of(1), JSString.of("Test"));
        JSArray doubleArray = JSArray.of(1.1, 2.2, 1.1);

        assertEquals(1, jsValueArray.indexOf(JSString.of("Test")));
        assertEquals(-1, jsValueArray.indexOf(JSNumber.of(2.3)));
        assertEquals(1, MIXED.indexOf(2));
        assertEquals(-1, MIXED.indexOf(1));
        assertEquals(0, doubleArray.indexOf(1.1));
        assertEquals(-1, doubleArray.indexOf(1.5));
        assertEquals(2, MIXED.indexOf(true));
        assertEquals(-1, MIXED.indexOf(false));
        assertEquals(2, BASE.indexOf("c"));
        assertEquals(0, jsValueArray.lastIndexOf(JSNumber.of(1)));
        assertEquals(-1, jsValueArray.lastIndexOf(JSNumber.of(2)));
        assertEquals(1, MIXED.lastIndexOf(2));
        assertEquals(-1, MIXED.lastIndexOf(1));
        assertEquals(2, doubleArray.lastIndexOf(1.1));
        assertEquals(-1, doubleArray.lastIndexOf(1.5));
        assertEquals(2, BOOLEANS.lastIndexOf(true));
        assertEquals(-1, MIXED.lastIndexOf(false));
        assertEquals(4, BASE.lastIndexOf("e"));
        assertEquals(-1, EMPTY.indexOf("anything"));
        assertEquals("a", BASE.at(0, String.class));
        assertEquals("e", BASE.at(-1, String.class));
        assertEquals("1", MIXED.at(0, String.class));
        assertEquals(JSUndefined.undefined(), EMPTY.at(0, Object.class));
        assertNull(WITH_NULLS.at(0, Object.class));
        assertEquals("a", WITH_NULLS.at(1, String.class));
        assertEquals(JSUndefined.undefined(), BASE.at(99));
        assertEquals(Integer.valueOf(2), MIXED.at(1, Integer.class));
        assertEquals(Boolean.TRUE, MIXED.at(2, Boolean.class));
    }

    public static void testMap() {
        JSArray mapped = BASE.map(JSFunction.of((JSString x) -> JSString.of(x.asString().toUpperCase())));
        JSArray result = MAP_UNDEFINED.map(JSFunction.of((JSString _) -> {
            // Do nothing
        }));

        assertArray(mapped, String.class, "A", "B", "C", "D", "E");
        assertArray(result, JSUndefined.class, JSUndefined.undefined(), JSUndefined.undefined());
    }

    public static void testPopPush() {
        JSArray arr = JSArray.of();

        assertEquals(1, arr.push(JSNumber.of(1)));
        assertEquals(2, arr.push(2));
        assertEquals(3, arr.push(1.1));
        assertEquals(4, arr.push(true));
        assertEquals(5, arr.push("Hello World"));
        assertEquals("Hello World", arr.pop(String.class));
        assertTrue(arr.pop(Boolean.class));
        assertEquals(1.1, arr.pop(Double.class), 0.0);
        assertEquals(Integer.valueOf(2), arr.pop(Integer.class));
        assertEquals(JSNumber.of(1), arr.pop(JSNumber.class));
        assertEquals(0, arr.length);
    }

    public static void testReduce() {
        String reduced1 = BASE.reduce(JSFunction.of((JSString acc, JSString val) ->
                JSString.of(acc.asString() + val.asString())), String.class);
        String reduced2 = BASE.reduce(JSFunction.of((JSString acc, JSString val) ->
                JSString.of(acc.asString() + val.asString())), "Test:", String.class);
        String reduced3 = BASE.reduceRight(JSFunction.of((JSString acc, JSString val) ->
                JSString.of(acc.asString() + val.asString())), String.class);
        String reduced4 = BASE.reduceRight(JSFunction.of((JSString acc, JSString val) ->
                JSString.of(acc.asString() + val.asString())), "Test:", String.class);

        assertEquals("abcde", reduced1);
        assertEquals("Test:abcde", reduced2);
        assertEquals("edcba", reduced3);
        assertEquals("Test:edcba", reduced4);
        assertThrows(ThrownFromJavaScript.class, () ->
                EMPTY.reduce(JSFunction.of((JSString acc, JSString val) ->
                        JSString.of(acc.asString() + val.asString())), String.class));
        assertThrows(ThrownFromJavaScript.class, () ->
                EMPTY.reduce(JSFunction.of((JSString acc, JSString val) ->
                        JSString.of(acc.asString() + val.asString())), String.class));
    }

    public static void testReverse() {
        JSArray baseClone = JSArray.from(BASE);
        JSArray reversed = baseClone.reverse();
        JSArray toReversed = BASE.toReversed();

        assertArray(baseClone, String.class, "e", "d", "c", "b", "a");
        assertArray(reversed, String.class, "e", "d", "c", "b", "a");
        assertArray(toReversed, String.class, "e", "d", "c", "b", "a");
    }

    public static void testShiftUnshift() {
        JSArray arr = JSArray.of();

        assertEquals(1, arr.unshift(JSNumber.of(1)));
        assertEquals(2, arr.unshift(2));
        assertEquals(3, arr.unshift(1.1));
        assertEquals(4, arr.unshift(true));
        assertEquals(5, arr.unshift("Hello World"));
        assertEquals("Hello World", arr.shift(String.class));
        assertTrue(arr.shift(Boolean.class));
        assertEquals(1.1, arr.shift(Double.class), 0.0);
        assertEquals(Integer.valueOf(2), arr.shift(Integer.class));
        assertEquals(JSNumber.of(1), arr.shift(JSNumber.class));
        assertEquals(0, arr.length);
    }


    public static void testFill() {
        JSArray arr1 = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3),
                JSNumber.of(4), JSNumber.of(5));
        JSArray arr2 = JSArray.of(1, 2, 3, 4, 5);
        JSArray arr3 = JSArray.of(1.2, 2.3, 3.4, 4.5, 5.6);
        JSArray arr4 = JSArray.of(true, true, true, true);
        JSArray arr5 = JSArray.of("Alice", "Bob", "Anna");

        JSArray filled1 = arr1.fill(JSString.of("Hello World"), 1, 3);
        JSArray filled2 = arr2.fill(0, 3, 6);
        JSArray filled3 = arr3.fill(0.0, 0, 5);
        JSArray filled4 = arr4.fill(false, -1, 10);
        JSArray filled5 = arr5.fill("X", 2, 5);

        assertArray(filled1, JSValue.class, JSNumber.of(1), JSString.of("Hello World"),
                JSString.of("Hello World"), JSNumber.of(4), JSNumber.of(5));
        assertArray(filled2, Integer.class, 1, 2, 3, 0, 0);
        assertArray(filled3, Double.class, 0.0, 0.0, 0.0, 0.0, 0.0);
        assertArray(filled4, Boolean.class, true, true, true, false);
        assertArray(filled5, String.class, "Alice", "Bob", "X");
    }

    public static void testSliceSplice() {
        JSArray baseClone1 = JSArray.from(BASE);
        JSArray baseClone2 = JSArray.from(BASE);

        JSArray sliced = BASE.slice(1, 3);
        JSArray spliced = baseClone1.splice(2, 1);
        JSArray splicedExcess = baseClone2.splice(1, 10);
        JSArray toSpliced = baseClone1.toSpliced(1, 2);

        assertArray(sliced, String.class, "b", "c");
        assertArray(baseClone1, String.class, "a", "b", "d", "e");
        assertArray(spliced, String.class, "c");
        assertArray(baseClone2, String.class, "a");
        assertArray(splicedExcess, String.class, "b", "c", "d", "e");
        assertArray(toSpliced, String.class, "a", "e");
    }

    public static void testFindMethods() {
        JSArray findArray1 = JSArray.of("x", "X", "X", "z");

        String found = findArray1.find(JSFunction.of((JSString x) ->
                JSBoolean.of(Objects.equals(x.asString(), "z"))), String.class);
        JSUndefined notFound = findArray1.find(JSFunction.of((JSString x) ->
                JSBoolean.of(Objects.equals(x.asString(), "b"))), JSUndefined.class);
        String foundLast = findArray1.findLast(JSFunction.of((JSString x) ->
                JSBoolean.of(Objects.equals(x.asString(), "X"))), String.class);
        int foundIndex = findArray1.findIndex(JSFunction.of((JSString x) ->
                JSBoolean.of(Objects.equals(x.asString(), "z"))));
        int foundLastIndex = findArray1.findLastIndex(JSFunction.of((JSString x) ->
                JSBoolean.of(Objects.equals(x.asString(), "X"))));

        assertEquals("z", found);
        assertEquals(JSUndefined.undefined(), notFound);
        assertEquals("X", foundLast);
        assertEquals(3, foundIndex);
        assertEquals(2, foundLastIndex);
    }

    public static void testFlatFlatMap() {
        JSArray flattened = NESTED.flat(10);
        JSArray flatMapped = BASE.flatMap(JSFunction.of((JSString x) -> JSArray.of(x.asString(), x.asString())));

        assertArray(flattened, String.class, "deep");
        assertArray(flatMapped, String.class, "a", "a", "b", "b", "c", "c", "d", "d", "e", "e");
    }

    public static void testForEach() {
        List<String> forEachOutput = new ArrayList<>();
        AtomicReference<List<String>> forEachOutputRef = new AtomicReference<>(forEachOutput);

        BASE.forEach(JSFunction.of((JSString arg) -> forEachOutputRef.get().add(arg.asString())));

        assertEquals(List.of("a", "b", "c", "d", "e"), forEachOutputRef.get());
    }

    public static void testIncludesJoin() {
        JSArray onlyTrue = JSArray.of(true, true);
        JSArray doubleArray = JSArray.of(1.2, 2.3);

        assertTrue(BASE.includes("a"));
        assertFalse(BASE.includes("not-there"));
        assertTrue(MIXED.includes(2));
        assertFalse(MIXED.includes(1234));
        assertTrue(doubleArray.includes(1.2));
        assertFalse(doubleArray.includes(1.5));
        assertTrue(BOOLEANS.includes(true));
        assertTrue(BOOLEANS.includes(false));
        assertFalse(onlyTrue.includes(false));
        assertTrue(WITH_NULLS.includes(null));
        assertEquals("a,b,c,d,e", BASE.join(","));
        assertEquals("a,b,c,d,e", BASE.join(JSString.of(",")));
        assertEquals("", EMPTY.join(","));
    }

    public static void testKeysValuesEntries() {
        JSArray keys = BASE.arrayKeys().toArray();
        JSArray values = BASE.values().toArray();
        JSArray entries = BASE.entries().toArray();

        assertArray(keys, Integer.class, 0, 1, 2, 3, 4);
        assertArray(values, String.class, "a", "b", "c", "d", "e");
        JSArray pair0 = JSValue.checkedCoerce(entries.at(0), JSArray.class);
        JSArray pair1 = JSValue.checkedCoerce(entries.at(1), JSArray.class);
        JSArray pair2 = JSValue.checkedCoerce(entries.at(2), JSArray.class);
        JSArray pair3 = JSValue.checkedCoerce(entries.at(3), JSArray.class);
        JSArray pair4 = JSValue.checkedCoerce(entries.at(4), JSArray.class);
        assertEquals(Integer.valueOf(0), JSValue.checkedCoerce(pair0.at(0), Integer.class));
        assertEquals("a", JSValue.checkedCoerce(pair0.at(1), String.class));
        assertEquals(Integer.valueOf(1), JSValue.checkedCoerce(pair1.at(0), Integer.class));
        assertEquals("b", JSValue.checkedCoerce(pair1.at(1), String.class));
        assertEquals(Integer.valueOf(2), JSValue.checkedCoerce(pair2.at(0), Integer.class));
        assertEquals("c", JSValue.checkedCoerce(pair2.at(1), String.class));
        assertEquals(Integer.valueOf(3), JSValue.checkedCoerce(pair3.at(0), Integer.class));
        assertEquals("d", JSValue.checkedCoerce(pair3.at(1), String.class));
        assertEquals(Integer.valueOf(4), JSValue.checkedCoerce(pair4.at(0), Integer.class));
        assertEquals("e", JSValue.checkedCoerce(pair4.at(1), String.class));
    }

    public static void testSomeEvery() {
        JSArray numbers = JSArray.of(5, 10, 15, 20);
        JSFunction containsD = JSFunction.of((JSString arg) -> JSBoolean.of(arg.asString().equals("d")));
        JSFunction containsX = JSFunction.of((JSString arg) -> JSBoolean.of(arg.asString().equals("x")));
        JSFunction divideBy5 = JSFunction.of((JSNumber arg) -> JSBoolean.of(arg.asInt() % 5 == 0));
        JSFunction divideBy2 = JSFunction.of((JSNumber arg) -> JSBoolean.of(arg.asInt() % 2 == 0));

        boolean some1 = BASE.some(containsD);
        boolean some2 = BASE.some(containsX);
        boolean every1 = numbers.every(divideBy5);
        boolean every2 = numbers.every(divideBy2);

        assertTrue(some1);
        assertFalse(some2);
        assertTrue(every1);
        assertFalse(every2);
    }

    public static void testSortToSorted() {
        JSArray unsortedClone = JSArray.from(UNSORTED);

        JSArray sorted = unsortedClone.sort();
        JSArray toSorted = UNSORTED.toSorted();

        assertArray(sorted, String.class, "a", "b", "c");
        assertArray(unsortedClone, String.class, "a", "b", "c");
        assertArray(toSorted, String.class, "a", "b", "c");
    }

    public static void testToLocaleStringToString() {
        JSArray localArr = JSArray.of(123456.789, 987654.321);

        String localized = localArr.toLocaleString();
        String emptyLocalized = EMPTY.toString();
        String baseString = BASE.toString();
        String emptyString = EMPTY.toString();

        assertTrue(localized.matches("\\d{3}[,.]\\d{3}[,.]\\d{3},\\d{3}[,.]\\d{3}[,.]\\d{3}"));
        assertEquals("<JavaScript<object; []>", emptyLocalized);
        assertEquals("<JavaScript<object; [a,b,c,d,e]>", baseString);
        assertEquals("<JavaScript<object; []>", emptyString);
    }

    public static void testWith() {
        JSArray fillTest = JSArray.of("a", "b", "c");

        JSArray replaced = BASE.with(0, "replaced");

        assertThrows(ThrownFromJavaScript.class, () -> fillTest.with(-5, "oops"));
        assertEquals("replaced", replaced.at(0, String.class));
    }

    public static void testFilter() {
        JSArray filterTest = JSArray.of("apple", "banana", "cherry");
        JSFunction startsWithB = JSFunction.of((JSString str) -> JSBoolean.of(str.asString().startsWith("b")));
        JSFunction alwaysFalse = JSFunction.of((JSString _) -> JSBoolean.of(false));

        JSArray filtered1 = filterTest.filter(startsWithB);
        JSArray filtered2 = MAP_UNDEFINED.filter(alwaysFalse);

        assertArray(filtered1, String.class, "banana");
        assertArray(filtered2, String.class);
    }

    public static void testEntries() {
        JSArray entries = STRINGS.entries().toArray();

        JSArray pair0 = entries.get(0, JSArray.class);
        JSArray pair1 = entries.get(1, JSArray.class);
        JSArray pair2 = entries.get(2, JSArray.class);
        assertEquals(Integer.valueOf(0), pair0.get(0, Integer.class));
        assertEquals("x", pair0.get(1, String.class));
        assertEquals(Integer.valueOf(1), pair1.get(0, Integer.class));
        assertEquals("y", pair1.get(1, String.class));
        assertEquals(Integer.valueOf(2), pair2.get(0, Integer.class));
        assertEquals("z", pair2.get(1, String.class));
    }
}
