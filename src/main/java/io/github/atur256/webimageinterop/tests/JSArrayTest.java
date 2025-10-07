package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.builtin.JSPromise;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.*;


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
        JSArray testArr1 = JSArray.of("a", "b", "c", "d", "e");
        JSArray testArr2 = JSArray.of(1, 2, 3, 4);
        JSArray testArr3 = JSArray.of(1.1, 2.2, 3.3, 4.4);
        JSArray testArr4 = JSArray.of(true, false, false);

        AssertArray.assertArray(testArr1, String.class, "a", "b", "c", "d", "e");
        AssertArray.assertArray(testArr2, Integer.class, 1, 2, 3, 4);
        AssertArray.assertArray(testArr3, Double.class, 1.1, 2.2, 3.3, 4.4);
        AssertArray.assertArray(testArr4, Boolean.class, true, false, false);
    }

    public static void testLength() {
        assertEquals(5, BASE.length);
        assertEquals(0, EMPTY.length);
        assertEquals(3, WITH_NULLS.length);
    }

    public static void testFromAndFromAsync() {
        JSArray stringsLocal = JSArray.from("xyz");
        JSPromise promise = JSArray.fromAsync(JSString.of("abc"));

        AssertArray.assertArray(stringsLocal, String.class, "x", "y", "z");
        assertEquals("JavaScript<object; [object Promise]>", promise.toString());
    }

    public static void testIsArray() {
        assertTrue(JSArray.isArray(BASE));
        assertTrue(JSArray.isArray(EMPTY));
        assertFalse(JSArray.isArray(JSString.of("not-an-array")));
    }

    public static void testConcat() {
        JSArray concatResult = BASE.concat(STRINGS);
        JSArray concatNull = EMPTY.concat((Object) null);

        AssertArray.assertArray(concatResult, String.class, "a", "b", "c", "d", "e", "x", "y", "z");
        AssertArray.assertArray(concatNull, JSUndefined.class, JSUndefined.undefined());
    }

    public static void testCopyWithin() {
        JSArray baseClone = JSArray.from(BASE);
        JSArray copied = JSArray.from(baseClone).copyWithin(0, 3, 5);

        AssertArray.assertArray(copied, String.class, "d", "e", "c", "d", "e");
    }

    public static void testIndexAccess() {
        assertEquals(2, BASE.indexOf("c"));
        assertEquals(4, BASE.lastIndexOf("e"));
        assertEquals(-1, EMPTY.indexOf("anything"));
        assertEquals("a", BASE.at(0, String.class));
        assertEquals("e", BASE.at(-1, String.class));
        assertEquals("1", MIXED.at(0, String.class));
        assertEquals(JSUndefined.undefined(), EMPTY.at(0, Object.class));
        assertEquals(JSUndefined.undefined(), WITH_NULLS.at(0, Object.class));
        assertEquals("a", WITH_NULLS.at(1, String.class));
        assertEquals(JSUndefined.undefined(), BASE.at(99));
        assertEquals(Integer.valueOf(2), MIXED.at(1, Integer.class));
        assertEquals(Boolean.TRUE, MIXED.at(2, Boolean.class));
    }

    public static void testMap() {
        JSArray mapped = BASE.map(JSFunction.fromArgs("x", "return x.toUpperCase();"));
        JSArray result = MAP_UNDEFINED.map(JSFunction.fromArgs("x", "return;"));

        AssertArray.assertArray(mapped, String.class, "A", "B", "C", "D", "E");
        AssertArray.assertArray(result, JSUndefined.class, JSUndefined.undefined(), JSUndefined.undefined());
    }


    public static void testPopPush() {
        JSArray baseClone = JSArray.from(BASE);
        JSArray emptyClone = JSArray.from(EMPTY);

        String popped = baseClone.pop(String.class);
        int newLength = baseClone.push("z");
        JSUndefined emptyPopped = emptyClone.pop(JSUndefined.class);

        assertEquals("e", popped);
        assertEquals(5, newLength);
        AssertArray.assertArray(baseClone, String.class, "a", "b", "c", "d", "z");
        assertEquals(JSUndefined.undefined(), emptyPopped);
    }

    public static void testReduce() {
        String reduced = BASE.reduce(JSFunction.fromArgs("acc", "val", "return acc + val;"), "");
        try {
            EMPTY.reduce(JSFunction.fromArgs("acc", "val", "return acc + val;"), String.class);
            fail();
        } catch (Exception _) {
        }
        String reversed = BASE.reduceRight(JSFunction.fromArgs("acc", "val", "return acc + val;"), "");
        assertEquals("edcba", reversed);
        try {
            EMPTY.reduceRight(JSFunction.fromArgs("acc", "val", "return acc + val;"), String.class);
            fail();
        } catch (Exception _) {
        }

        assertEquals("abcde", reduced);
    }

    public static void testReverse() {
        JSArray baseClone = JSArray.from(BASE);
        JSArray reversed = baseClone.reverse();
        JSArray toReversed = BASE.toReversed();

        AssertArray.assertArray(baseClone, String.class, "e", "d", "c", "b", "a");
        AssertArray.assertArray(reversed, String.class, "e", "d", "c", "b", "a");
        AssertArray.assertArray(toReversed, String.class, "e", "d", "c", "b", "a");
    }

    public static void testShiftUnshift() {
        JSArray baseClone = JSArray.from(BASE);
        JSArray emptyClone = JSArray.from(EMPTY);

        String shifted = baseClone.shift(String.class);
        int newLength = baseClone.unshift("x");
        JSUndefined emptyShifted = emptyClone.shift(JSUndefined.class);

        assertEquals("a", shifted);
        assertEquals(5, newLength);
        AssertArray.assertArray(baseClone, String.class, "x", "b", "c", "d", "e");
        assertEquals(JSUndefined.undefined(), emptyShifted);
    }


    public static void testFill() {
        JSArray baseClone = JSArray.from(BASE);
        JSArray filled = baseClone.fill("X", 1, 3);

        JSArray fillTestClone = JSArray.from(STRINGS);
        JSArray filledOutOfBounds = fillTestClone.fill("X", 5, 10);

        AssertArray.assertArray(baseClone, String.class, "a", "X", "X", "d", "e");
        AssertArray.assertArray(filled, String.class, "a", "X", "X", "d", "e");
        AssertArray.assertArray(fillTestClone, String.class, "x", "y", "z");
        AssertArray.assertArray(filledOutOfBounds, String.class, "x", "y", "z");
    }

    public static void testSliceSplice() {
        JSArray baseClone1 = JSArray.from(BASE);
        JSArray baseClone2 = JSArray.from(BASE);

        JSArray sliced = BASE.slice(1, 3);
        JSArray spliced = baseClone1.splice(2, 1);
        JSArray splicedExcess = baseClone2.splice(1, 10);
        JSArray toSpliced = baseClone1.toSpliced(1, 2);

        AssertArray.assertArray(sliced, String.class, "b", "c");
        AssertArray.assertArray(baseClone1, String.class, "a", "b", "d", "e");
        AssertArray.assertArray(spliced, String.class, "c");
        AssertArray.assertArray(baseClone2, String.class, "a");
        AssertArray.assertArray(splicedExcess, String.class, "b", "c", "d", "e");
        AssertArray.assertArray(toSpliced, String.class, "a", "e");
    }

    public static void testFindMethods() {
        JSArray findArray1 = JSArray.of("x", "X", "X", "z");

        String found = findArray1.find(JSFunction.fromArgs("x", "return x === 'z';"), String.class);
        JSUndefined notFound = findArray1.find(JSFunction.fromArgs("x", "return x === 'b';"), JSUndefined.class);
        String foundLast = findArray1.findLast(JSFunction.fromArgs("x", "return x === 'X';"), String.class);
        int foundIndex = findArray1.findIndex(JSFunction.fromArgs("x", "return x === 'z';"));
        int foundLastIndex = findArray1.findLastIndex(JSFunction.fromArgs("x", "return x === 'X';"));

        assertEquals("z", found);
        assertEquals(JSUndefined.undefined(), notFound);
        assertEquals("X", foundLast);
        assertEquals(3, foundIndex);
        assertEquals(2, foundLastIndex);
    }

    public static void testFlatFlatMap() {
        JSArray flattened = NESTED.flat(10);
        JSArray flatMapped = BASE.flatMap(JSFunction.fromArgs("x", "return [x, x];"));

        AssertArray.assertArray(flattened, String.class, "deep");
        AssertArray.assertArray(flatMapped, String.class, "a", "a", "b", "b", "c", "c", "d", "d", "e", "e");
    }


    public static void testForEach() {
        List<String> forEachOutput = new ArrayList<>();
        AtomicReference<List<String>> forEachOutputRef = new AtomicReference<>(forEachOutput);

        BASE.forEach(JSFunction.fromJavaConsumer((JSString arg) -> forEachOutputRef.get().add(arg.asString())));

        assertEquals(List.of("a", "b", "c", "d", "e"), forEachOutputRef.get());
    }

    public static void testIncludesJoin() {
        JSArray onlyTrue = JSArray.of(true, true);

        assertTrue(BASE.includes("a"));
        assertFalse(BASE.includes("not-there"));
        assertTrue(BOOLEANS.includes(true));
        assertTrue(BOOLEANS.includes(false));
        assertFalse(onlyTrue.includes(false));
        assertTrue(WITH_NULLS.includes(JSUndefined.undefined()));
        assertEquals("a,b,c,d,e", BASE.join(","));
        assertEquals("", EMPTY.join(","));
    }

    public static void testKeysValuesEntries() {
        JSArray keys = BASE.keys().toArray();
        JSArray values = BASE.values().toArray();
        JSArray entries = BASE.entries().toArray();

        AssertArray.assertArray(keys, Integer.class, 0, 1, 2, 3, 4);
        AssertArray.assertArray(values, String.class, "a", "b", "c", "d", "e");
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
        JSFunction containsD = JSFunction.fromJavaFunction((JSString arg) -> JSBoolean.of(arg.asString().equals("d")));
        JSFunction containsX = JSFunction.fromJavaFunction((JSString arg) -> JSBoolean.of(arg.asString().equals("x")));
        JSFunction divideBy5 = JSFunction.fromJavaFunction((JSNumber arg) -> JSBoolean.of(arg.asInt() % 5 == 0));
        JSFunction divideBy2 = JSFunction.fromJavaFunction((JSNumber arg) -> JSBoolean.of(arg.asInt() % 2 == 0));

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

        AssertArray.assertArray(sorted, String.class, "a", "b", "c");
        AssertArray.assertArray(unsortedClone, String.class, "a", "b", "c");
        AssertArray.assertArray(toSorted, String.class, "a", "b", "c");
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
        try {
            fillTest.with(-5, "oops");
            fail();
        } catch (Exception _) {
        }

        assertEquals("replaced", replaced.at(0, String.class));
    }

    public static void testFilter() {
        JSArray filterTest = JSArray.of("apple", "banana", "cherry");
        JSFunction startsWithB = JSFunction.fromJavaFunction((JSString str) -> JSBoolean.of(str.asString().startsWith("b")));
        JSFunction alwaysFalse = JSFunction.fromJavaFunction((JSString _) -> JSBoolean.of(false));

        JSArray filtered1 = filterTest.filter(startsWithB);
        JSArray filtered2 = MAP_UNDEFINED.filter(alwaysFalse);

        AssertArray.assertArray(filtered1, String.class, "banana");
        AssertArray.assertArray(filtered2, String.class);
    }

    public static void testEntries() {
        JSArray entries = STRINGS.entries().toArray();

        JSArray pair0 = JSValue.checkedCoerce(entries.get(0), JSArray.class);
        JSArray pair1 = JSValue.checkedCoerce(entries.get(1), JSArray.class);
        JSArray pair2 = JSValue.checkedCoerce(entries.get(2), JSArray.class);
        assertEquals(Integer.valueOf(0), JSValue.checkedCoerce(pair0.get(0), Integer.class));
        assertEquals("x", JSValue.checkedCoerce(pair0.get(1), String.class));
        assertEquals(Integer.valueOf(1), JSValue.checkedCoerce(pair1.get(0), Integer.class));
        assertEquals("y", JSValue.checkedCoerce(pair1.get(1), String.class));
        assertEquals(Integer.valueOf(2), JSValue.checkedCoerce(pair2.get(0), Integer.class));
        assertEquals("z", JSValue.checkedCoerce(pair2.get(1), String.class));
    }
}