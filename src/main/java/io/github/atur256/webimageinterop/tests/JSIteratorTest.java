package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.*;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class JSIteratorTest {

    public static void main(String[] args) {
        testFromAndToArray();
        testDropAndTake();
        testMapAndFlatMap();
        testFilterAndFind();
        testEveryAndSome();
        testReduce();
        testForEach();
        testNextAndNextValue();
    }

    public static void testFromAndToArray() {
        JSValue array1 = JSEval.eval("[1, 2, 3]", JSValue.class);
        JSValue array2 = JSArray.of("apple", "banana", "cherry");

        JSIterator iterator1 = JSIterator.from(array1);
        JSIterator iterator2 = JSIterator.from(array2);
        JSArray result1 = iterator1.toArray();
        JSArray result2 = iterator2.toArray();

        AssertArray.assertArray(result1, Integer.class, 1, 2, 3);
        AssertArray.assertArray(result2, String.class, "apple", "banana", "cherry");
    }

    public static void testDropAndTake() {
        JSIterator iterator1 = JSIterator.from(JSArray.of(10, 20, 30, 40));
        JSIterator iterator2 = JSIterator.from(JSArray.of("apple", "banana", "cherry"));

        JSArray dropped1 = iterator1.drop(2).toArray();
        JSArray taken1 = iterator2.take(2).toArray();
        JSArray dropped2 = iterator1.drop(3).toArray();
        JSArray taken2 = iterator2.take(10).toArray();

        assertThrows(ThrownFromJavaScript.class, () -> iterator1.drop(-3));
        assertThrows(ThrownFromJavaScript.class, () -> iterator2.take(-1));
        AssertArray.assertArray(dropped1, Integer.class, 30, 40);
        AssertArray.assertArray(taken1, String.class, "apple", "banana");
        AssertArray.assertArray(dropped2, Integer.class);
        AssertArray.assertArray(taken2, String.class, "cherry");
    }

    public static void testMapAndFlatMap() {
        JSArray arr = JSArray.of(1, 2, 3);
        JSFunction mapFn = JSFunction.fromFunc((JSNumber arg) -> arg.as(Integer.class) * 2);
        JSFunction flatMapFn = JSFunction.fromFunc((JSNumber arg) ->
                JSArray.of(arg.as(Integer.class), arg.as(Integer.class) * 2));
        JSFunction errorFun = JSFunction.fromFunc((JSNumber _) -> JSString.of("Error"));

        JSArray mapped1 = JSIterator.from(arr).map(mapFn).toArray();
        JSArray mapped2 = JSIterator.from(JSArray.of()).map(mapFn).toArray();
        JSArray flatMapped1 = JSIterator.from(arr).flatMap(flatMapFn).toArray();

        assertThrows(ThrownFromJavaScript.class, () -> JSIterator.from(JSArray.of()).map(null));
        assertThrows(ThrownFromJavaScript.class, () -> JSIterator.from(arr).flatMap(errorFun).toArray());
        AssertArray.assertArray(mapped1, Integer.class, 2, 4, 6);
        AssertArray.assertArray(mapped2, Integer.class);
        AssertArray.assertArray(flatMapped1, Integer.class, 1, 2, 2, 4, 3, 6);
    }

    public static void testFilterAndFind() {
        JSArray arr = JSArray.of(1, 2, 3, 4, 5, 6);
        JSFunction gt3 = JSFunction.fromFunc((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) > 3));
        JSFunction gt10 = JSFunction.fromFunc((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) > 10));

        JSArray filtered1 = JSIterator.from(arr).filter(gt3).toArray();
        JSArray filtered2 = JSIterator.from(arr).filter(gt10).toArray();
        int found1 = JSIterator.from(arr).find(gt3, Integer.class);
        JSUndefined found2 = JSIterator.from(arr).find(gt10, JSUndefined.class);

        AssertArray.assertArray(filtered1, Integer.class, 4, 5, 6);
        AssertArray.assertArray(filtered2, Integer.class);
        assertEquals(4, found1);
        assertEquals(JSUndefined.undefined(), found2);
    }

    public static void testEveryAndSome() {
        JSArray arr1 = JSArray.of(2, 4, 6);
        JSArray arr2 = JSArray.of(2, 3, 6);
        JSFunction isEven = JSFunction.fromFunc((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) % 2 == 0));

        assertTrue(JSIterator.from(arr1).every(isEven));
        assertFalse(JSIterator.from(arr2).every(isEven));
        assertTrue(JSIterator.from(arr1).some(isEven));
        assertTrue(JSIterator.from(arr2).some(isEven));
    }

    public static void testReduce() {
        JSArray sumArray = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSArray productArray1 = JSArray.of(2, 4, 10);
        JSArray subtractionArray = JSArray.of(1.4, 2.6, 5.6, 7.0);
        JSArray fruitsArray = JSArray.of("apple", "banana", "orange");
        JSArray boolArray = JSArray.of(true, false, true, false);
        JSFunction sumFunction = JSFunction.fromArgs("acc", "val", "return acc + val;");
        JSFunction multiplyFunction1 = JSFunction.fromBiFunc((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        JSFunction multiplyFunction2 = JSFunction.fromBiFunc((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        JSFunction subtractFunction = JSFunction.fromBiFunc((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Double.class) - val.as(Double.class)));
        JSFunction concatFunction = JSFunction.fromBiFunc((JSString acc, JSString val) ->
                JSString.of(acc.asString() + " | " + val.asString()));
        JSFunction andFunction = JSFunction.fromBiFunc((JSBoolean acc, JSBoolean val) ->
                JSBoolean.of(acc.as(Boolean.class) && val.as(Boolean.class)));

        JSValue sumResult = JSIterator.from(sumArray).reduce(sumFunction, JSNumber.of(0));
        int productResult1 = JSIterator.from(productArray1).reduce(multiplyFunction1, 1);
        JSNumber productResult2 = JSIterator.from(productArray1).reduce(multiplyFunction2, JSNumber.class);
        double subtractionResult = JSIterator.from(subtractionArray).reduce(subtractFunction, 2.14);
        String concatResult = JSIterator.from(fruitsArray).reduce(concatFunction, "fruits:");
        boolean andResult = JSIterator.from(boolArray).reduce(andFunction, true);

        assertEquals(Integer.valueOf(6), sumResult.as(Integer.class));
        assertEquals(80, productResult1);
        assertEquals(Integer.valueOf(80), productResult2.as(Integer.class));
        assertEquals(-14.46, subtractionResult, 0.001);
        assertEquals("fruits: | apple | banana | orange", concatResult);
        assertFalse(andResult);
        try {
            JSIterator.from(JSArray.of()).reduce(andFunction, Boolean.class);
            fail();
        } catch (ThrownFromJavaScript thrownFromJavaScript) {
            assertTrue(thrownFromJavaScript.getMessage().contains("TypeError: Reduce of a done iterator with no initial value"));
        }
    }

    public static void testForEach() {
        JSArray arr = JSArray.of("x", "y", "z");
        JSIterator iter = JSIterator.from(arr);
        JSIterator emptyIter = JSIterator.from(JSArray.of());
        Set<String> collected1 = new HashSet<>();
        Set<String> collected2 = new HashSet<>();
        JSFunction collectFn1 = JSFunction.fromCons((JSString arg) -> collected1.add(arg.asString()));
        JSFunction collectFn2 = JSFunction.fromCons((JSString arg) -> collected2.add(arg.asString()));

        iter.forEach(collectFn1);
        emptyIter.forEach(collectFn2);

        assertEquals(Set.of("x", "y", "z"), collected1);
        assertEquals(Set.of(), collected2);
    }

    public static void testNextAndNextValue() {
        JSArray arr = JSArray.of(10, 20, 30);
        JSIterator iter = JSIterator.from(arr);
        JSIterator iter2 = JSIterator.from(JSArray.of(1, 2));

        JSObject first = iter.next();
        JSObject second = iter.next();
        JSObject third = iter.next();
        JSObject done = iter.next();

        assertFalse(((JSBoolean) first.get("done")).as(Boolean.class));
        assertEquals(Integer.valueOf(10), ((JSNumber) first.get("value")).as(Integer.class));
        assertEquals(Integer.valueOf(20), ((JSNumber) second.get("value")).as(Integer.class));
        assertEquals(Integer.valueOf(30), ((JSNumber) third.get("value")).as(Integer.class));
        assertTrue(((JSBoolean) done.get("done")).as(Boolean.class));
        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(done.get("value"), JSUndefined.class));
        assertEquals(Integer.valueOf(1), iter2.nextValue(Integer.class));
        assertEquals(Integer.valueOf(2), iter2.nextValue(Integer.class));
        assertNull(iter2.nextValue(Integer.class));
    }
}
