package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ReduceRightDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reduceRight Demo ===");

        JSArray sumArray = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction sumRightFunction = JSFunction.fromArgs("acc", "val", "return acc + val;");
        int result1 = JSValue.checkedCoerce(sumArray.reduceRight(sumRightFunction, JSNumber.of(0)), Integer.class);
        System.out.println("Sum (right to left) of [1, 2, 3]: " + result1);
        // Expected: Sum (right to left) of [1, 2, 3]: 6

        JSArray productArray1 = JSArray.of(2, 4, 10);
        JSFunction multiplyRightFunction1 = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        int result2 = productArray1.reduceRight(multiplyRightFunction1, 1);
        System.out.println("Product (right to left) of [2, 4, 10]: " + result2);
        // Expected: Product (right to left) of [2, 4, 10]: 80

        JSArray productArray2 = JSArray.of(2, 4, 10);
        JSFunction multiplyRightFunction2 = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        int result3 = productArray2.reduceRight(multiplyRightFunction2, Integer.class);
        System.out.println("Product (right to left) of [2, 4, 10]: " + result3);
        // Expected: Product (right to left) of [2, 4, 10]: 80

        JSArray subtractionArray = JSArray.of(1.4, 2.6, 5.6, 7.0);
        JSFunction subtractRightFunction = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Double.class) - val.as(Double.class)));
        double result4 = subtractionArray.reduceRight(subtractRightFunction, 2.14);
        System.out.println("Sequential subtraction (right to left): " + result4);
        // Expected: Sequential subtraction (right to left): ~-14.46

        JSArray fruitsArray = JSArray.of("apple", "banana", "orange");
        JSFunction concatRightFunction = JSFunction.fromGeneralBiFunction((JSString acc, JSString val) ->
                JSString.of(acc.as(String.class) + " | " + val.as(String.class)));
        String result5 = fruitsArray.reduceRight(concatRightFunction, "fruits:");
        System.out.println("Concatenated fruit list (right to left): " + result5);
        // Expected: Concatenated fruit list (right to left): fruits: | orange | banana | apple

        JSArray boolArray = JSArray.of(false, true, false);
        JSFunction andRightFunction = JSFunction.fromGeneralBiFunction((JSBoolean acc, JSBoolean val) ->
                JSBoolean.of(acc.as(Boolean.class) && val.as(Boolean.class)));
        boolean result6 = boolArray.reduceRight(andRightFunction, true);
        System.out.println("Logical AND (right to left) of [true, false, true, false]: " + result6);
        // Expected: Logical AND (right to left) of [true, false, true, false]: false

        // Assert values
        assertEquals(6, result1);
        assertEquals(80, result2);
        assertEquals(80, result3);
        assertEquals(-14.46, result4, 0.01);
        assertEquals("fruits: | orange | banana | apple", result5);
        assertFalse(result6);
    }
}