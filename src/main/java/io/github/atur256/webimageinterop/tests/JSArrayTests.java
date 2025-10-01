package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.builtin.JSPromise;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSUndefined;
import org.graalvm.webimage.api.JSValue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.*;


public class JSArrayTests {

    public static void main(String[] args) {

        // of
        JSArray base = JSArray.of("a", "b", "c", "d", "e");
        JSArray empty = JSArray.of();
        JSArray mixed = JSArray.of("1", 2, true);
        JSArray nested = JSArray.of(JSArray.of(JSArray.of("deep")));
        JSArray withNulls = JSArray.of(null, "a", null);

        // length
        assertEquals(5, base.length);
        assertEquals(0, empty.length);
        assertEquals(3, withNulls.length);

        // from
        JSArray strings = JSArray.from("xyz");
        AssertArray.assertArray(strings, String.class, "x", "y", "z");

        // fromAsync
        JSPromise promise = JSArray.fromAsync(JSString.of("abc"));
        assertEquals("JavaScript<object; [object Promise]>", promise.toString());

        // isArray
        assertTrue(JSArray.isArray(base));
        assertTrue(JSArray.isArray(strings));
        assertFalse(JSArray.isArray(JSString.of("not-an-array")));

        // concat
        JSArray concatResult = base.concat(strings);
        AssertArray.assertArray(concatResult, String.class, "a", "b", "c", "d", "e", "x", "y", "z");
        JSArray concatNull = empty.concat((Object) null);
        assertEquals(1, concatNull.length);
        assertEquals(JSUndefined.undefined(), concatNull.at(0));

        // copyWithin
        JSArray baseCopy1 = JSArray.from(base);
        JSArray copied = baseCopy1.copyWithin(0, 3, 5);
        AssertArray.assertArray(copied, String.class, "d", "e", "c", "d", "e");

        // indexOf / lastIndexOf / at
        assertEquals(2, base.indexOf("c"));
        assertEquals(4, base.lastIndexOf("e"));
        assertEquals(-1, empty.indexOf("anything"));
        assertEquals("a", base.at(0, String.class));
        assertEquals("e", base.at(-1, String.class));
        assertEquals("1", mixed.at(0, String.class));
        assertEquals(JSUndefined.undefined(), empty.at(0, Object.class));
        assertEquals(JSUndefined.undefined(), withNulls.at(0, Object.class));
        assertEquals("a", withNulls.at(1, String.class));
        assertEquals(JSUndefined.undefined(), base.at(99));
        assertEquals(Integer.valueOf(2), mixed.at(1, Integer.class));
        assertEquals(Boolean.TRUE, mixed.at(2, Boolean.class));

        // map
        JSArray mapped = base.map(JSFunction.fromArgs("x", "return x.toUpperCase();"));
        assertEquals("C", mapped.at(2, String.class));
        JSArray mapUndefined = JSArray.of("a", "b");
        JSArray result = mapUndefined.map(JSFunction.fromArgs("x", "return;"));
        assertEquals(JSValue.undefined(), result.at(0, JSValue.class));

        // pop / push
        JSArray baseCopy2 = JSArray.from(base);
        Object popped = baseCopy2.pop(String.class);
        assertEquals("e", popped);
        int newLength = baseCopy2.push("z");
        assertEquals(5, newLength);
        assertEquals("z", baseCopy2.at(4, String.class));
        assertEquals(JSUndefined.undefined(), empty.pop());

        // reduce / reduceRight
        String reduced = base.reduce(JSFunction.fromArgs("acc", "val", "return acc + val;"), "");
        assertEquals("abcde", reduced);
        try {
            empty.reduce(JSFunction.fromArgs("acc", "val", "return acc + val;"), String.class);
            fail("Expected reduce to fail");
        } catch (Exception _) {
        }
        String reversed = base.reduceRight(JSFunction.fromArgs("acc", "val", "return acc + val;"), "");
        assertEquals("edcba", reversed);
        try {
            empty.reduceRight(JSFunction.fromArgs("acc", "val", "return acc + val;"), String.class);
            fail("Expected reduceRight to fail");
        } catch (Exception _) {
        }

        // reverse / toReversed
        JSArray baseCopy3 = JSArray.from(base);
        JSArray reversedArray = baseCopy3.reverse();
        assertEquals("e", reversedArray.at(0, String.class));
        JSArray toReversedArray = baseCopy3.toReversed();
        assertEquals("a", toReversedArray.at(0, String.class));

        // shift / unshift
        JSArray baseCopy4 = JSArray.from(base);
        Object shifted = baseCopy4.shift(String.class);
        assertEquals("a", shifted);
        assertEquals(JSUndefined.undefined(), empty.shift());
        int unshiftedLength = baseCopy4.unshift("x");
        assertEquals(5, unshiftedLength);
        assertEquals("x", baseCopy4.at(0, String.class));

        // fill
        JSArray baseCopy5 = JSArray.from(base);
        JSArray filled = baseCopy5.fill("X", 1, 3);
        assertEquals("X", filled.at(1, String.class));
        JSArray fillTest = JSArray.of("a", "b", "c");
        JSArray filledOutOfBounds = fillTest.fill("X", 5, 10);
        assertEquals("a", filledOutOfBounds.at(0, String.class));

        // slice / splice / toSpliced
        JSArray baseCopy6 = JSArray.from(base);
        JSArray sliced = baseCopy6.slice(1, 3);
        assertEquals("b", sliced.at(0, String.class));
        JSArray baseCopy7 = JSArray.from(base);
        JSArray spliced = baseCopy7.splice(2, 1);
        assertEquals("c", spliced.at(0, String.class));
        JSArray splicedExcess = fillTest.splice(1, 10);
        assertEquals("b", splicedExcess.at(0, String.class));
        assertEquals(1, fillTest.length);
        JSArray toSpliced = baseCopy7.toSpliced(1, 2);
        assertEquals("e", toSpliced.at(1, String.class));

        // find / findLast / findIndex / findLastIndex
        JSArray findArray = JSArray.of("x", "X", "X", "z");
        Object found = findArray.find(JSFunction.fromArgs("x", "return x === 'z';"));
        assertEquals("z", JSValue.checkedCoerce(found, String.class));
        Object notFound = mapUndefined.find(JSFunction.fromArgs("x", "return x === 'z';"));
        assertEquals(JSUndefined.undefined(), notFound);
        Object foundLast = findArray.findLast(JSFunction.fromArgs("x", "return x === 'X';"));
        assertEquals("X", JSValue.checkedCoerce(foundLast, String.class));
        assertEquals(3, findArray.findIndex(JSFunction.fromArgs("x", "return x === 'z';")));
        assertEquals(2, findArray.findLastIndex(JSFunction.fromArgs("x", "return x === 'X';")));

        // flat / flatMap
        JSArray flattened = nested.flat(10);
        AssertArray.assertArray(flattened, String.class, "deep");
        JSArray flatMapped = base.flatMap(JSFunction.fromArgs("x", "return [x, x];"));
        AssertArray.assertArray(flatMapped, String.class, "a", "a", "b", "b", "c", "c", "d", "d", "e", "e");

        // forEach
        List<String> forEachOutput = new ArrayList<>();
        AtomicReference<List<String>> forEachOutputRef = new AtomicReference<>(forEachOutput);
        base.forEach(JSFunction.fromGeneralConsumer((JSString arg) -> forEachOutputRef.get().add(arg.asString())));
        assertEquals(forEachOutputRef.get(), List.of("a", "b", "c", "d", "e"));

        // includes / join
        assertTrue(base.includes("a"));
        assertFalse(base.includes("not-there"));
        JSArray coercion = JSArray.of("true", "false");
        assertFalse(coercion.includes(true));
        assertFalse(coercion.includes(false));
        assertTrue(withNulls.includes(JSUndefined.undefined()));
        assertEquals("a,b,c,d,e", base.join(","));
        assertEquals("", empty.join(","));

        // keys / values / entries
        assertNotNull(base.keys());
        assertNotNull(base.values());
        assertNotNull(base.entries());

        // some / every
        assertTrue(base.some(JSFunction.fromArgs("x", "return x === 'd';")));
        assertFalse(base.every(JSFunction.fromArgs("x", "return x === 'a';")));

        // sort / toSorted
        JSArray unsorted = JSArray.of("c", "a", "b");
        JSArray sorted = unsorted.sort();
        assertEquals("a", sorted.at(0, String.class));
        JSArray toSorted = unsorted.toSorted();
        assertEquals("a", toSorted.at(0, String.class));

        // toLocaleString / toString
        JSArray localArr = JSArray.of(123456.789, 987654.321);
        String localized = localArr.toLocaleString();
        assertTrue(localized.matches("\\d{3}[,.]\\d{3}[,.]\\d{3},\\d{3}[,.]\\d{3}[,.]\\d{3}"));
        assertEquals("", empty.toLocaleString());
        assertEquals("[a,b,c,d,e]", base.toString());
        assertEquals("[]", empty.toString());

        // with
        JSArray replaced = base.with(0, "replaced");
        assertEquals("replaced", replaced.at(0, String.class));
        try {
            fillTest.with(-5, "oops");
            fail("Expected with() to fail");
        } catch (Exception _) {
        }

        // filter
        JSArray filterTest = JSArray.of("apple", "banana", "cherry");
        JSArray filtered1 = filterTest.filter(JSFunction.fromArgs("x", "return x.startsWith('b');"));
        assertEquals(1, filtered1.length);
        assertEquals("banana", filtered1.at(0, String.class));
        JSArray filtered2 = mapUndefined.filter(JSFunction.fromArgs("x", "return false;"));
        assertEquals(0, filtered2.length);

        // entries
        JSArray entryTest = JSArray.of("x", "y", "z");
        JSArray entries = entryTest.entries().toArray();
        JSArray pair1 = JSValue.checkedCoerce(entries.get(0), JSArray.class);
        JSArray pair2 = JSValue.checkedCoerce(entries.get(1), JSArray.class);
        JSArray pair3 = JSValue.checkedCoerce(entries.get(2), JSArray.class);
        assertEquals(Integer.valueOf(0), JSValue.checkedCoerce(pair1.get(0), Integer.class));
        assertEquals("x", JSValue.checkedCoerce(pair1.get(1), String.class));
        assertEquals(Integer.valueOf(1), JSValue.checkedCoerce(pair2.get(0), Integer.class));
        assertEquals("y", JSValue.checkedCoerce(pair2.get(1), String.class));
        assertEquals(Integer.valueOf(2), JSValue.checkedCoerce(pair3.get(0), Integer.class));
        assertEquals("z", JSValue.checkedCoerce(pair3.get(1), String.class));
    }
}