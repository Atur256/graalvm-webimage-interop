package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ReduceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reduce Demo ===");

        JSArray sumArray = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction sumFunction = JSFunction.fromArgs("acc", "val", "return acc + val;");
        int result1 = JSValue.checkedCoerce(sumArray.reduce(sumFunction, JSNumber.of(0)), Integer.class);
        assertEquals(6, result1);
        System.out.println("Sum of [1, 2, 3]: " + result1);
        // Expected: Sum of [1, 2, 3]: 6

        JSArray productArray1 = JSArray.of(2, 4, 10);
        JSFunction multiplyFunction1 = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        int result2 = productArray1.reduce(multiplyFunction1, 1);
        assertEquals(80, result2);
        System.out.println("Product of [2, 4, 10]: " + result2);
        // Expected: Product of [2, 4, 10]: 80

        JSArray productArray2 = JSArray.of(2, 4, 10);
        JSFunction multiplyFunction2 = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        int result3 = productArray2.reduce(multiplyFunction2, Integer.class);
        assertEquals(80, result3);
        System.out.println("Product of [2, 4, 10]: " + result3);
        // Expected: Product of [2, 4, 10]: 80

        JSArray subtractionArray = JSArray.of(1.4, 2.6, 5.6, 7.0);
        JSFunction subtractFunction = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Double.class) - val.as(Double.class)));
        double result4 = subtractionArray.reduce(subtractFunction, 2.14);
        assertEquals(-14.46, result4, 0.01);
        System.out.println("Result of sequential subtraction: " + result4);
        // Expected: Result of sequential subtraction: ~-14.46


        JSArray fruitsArray = JSArray.of("apple", "banana", "orange");
        JSFunction concatFunction = JSFunction.fromGeneralBiFunction((JSString acc, JSString val) ->
                JSString.of(acc.as(String.class) + " | " + val.as(String.class)));
        String result5 = fruitsArray.reduce(concatFunction, "fruits:");
        assertEquals("fruits: | apple | banana | orange", result5);
        System.out.println("Concatenated fruit list: " + result5);
        // Expected: Concatenated fruit list: fruits: | apple | banana | orange

        JSArray boolArray = JSArray.of(true, false, true, false);
        JSFunction andFunction = JSFunction.fromGeneralBiFunction((JSBoolean acc, JSBoolean val) ->
                JSBoolean.of(acc.as(Boolean.class) && val.as(Boolean.class)));
        boolean result6 = boolArray.reduce(andFunction, true);
        System.out.println("Logical AND of [true, false, true, false]: " + result6);
        assertFalse(result6);
        // Expected: Logical AND of [true, false, true, false]: false
    }
}