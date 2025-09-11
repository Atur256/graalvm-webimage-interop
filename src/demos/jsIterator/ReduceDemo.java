package demos.jsIterator;

import builtin.*;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import java.lang.Boolean;
import java.lang.String;


public class ReduceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.reduce Demo ===");

        JSArray sumArray = JSArray.of(new JSNumber[]{JSNumber.of(1), JSNumber.of(2), JSNumber.of(3)});
        JSIterator sumIterator = JSIterator.from(sumArray);
        JSFunction sumFunction = JSFunction.fromArgs("acc", "val", "return acc + val;");
        JSValue sumResult = sumIterator.reduce(sumFunction, JSNumber.of(0));
        System.out.println("Sum of [1, 2, 3]: " + sumResult.as(Integer.class));
        // Expected: Sum of [1, 2, 3]: 6

        JSArray productArray1 = JSArray.of(2, 4, 10);
        JSFunction multiplyFunction1 = JSFunction.fromGeneralBiFunction((JSNumber acc, Integer val) ->
                JSNumber.of(acc.as(Integer.class) * val));
        JSIterator productIterator1 = JSIterator.from(productArray1);
        int productResult1 = productIterator1.reduce(multiplyFunction1, 1);
        System.out.println("Product of [2, 4, 10]: " + productResult1);
        // Expected: Product of [2, 4, 10]: 80

        JSArray productArray2 = JSArray.of(2, 4, 10);
        JSFunction multiplyFunction2 = JSFunction.fromGeneralBiFunction((Integer acc, Integer val) -> acc * val);
        JSIterator productIterator2 = JSIterator.from(productArray2);
        int productResult2 = productIterator2.reduce(multiplyFunction2, Integer.class);
        System.out.println("Product of [2, 4, 10]: " + productResult2);
        // Expected: Product of [2, 4, 10]: 80

        JSArray subtractionArray = JSArray.of(1.4, 2.6, 5.6, 7.0);
        JSFunction subtractFunction = JSFunction.fromGeneralBiFunction((JSNumber acc, Double val) ->
                JSNumber.of(acc.as(Double.class) - val));
        JSIterator subtractionIterator = JSIterator.from(subtractionArray);
        double subtractionResult = subtractionIterator.reduce(subtractFunction, 2.14);
        System.out.println("Result of sequential subtraction: " + subtractionResult);
        // Expected: Result of sequential subtraction: ~-14.46


        JSArray fruitsArray = JSArray.of("apple", "banana", "orange");
        JSFunction concatFunction = JSFunction.fromGeneralBiFunction((JSString acc, String val) ->
                JSString.of(acc.as(String.class) + " | " + val));
        JSIterator stringIterator = JSIterator.from(fruitsArray);
        String concatResult = stringIterator.reduce(concatFunction, "fruits:");
        System.out.println("Concatenated fruit list: " + concatResult);
        // Expected: Concatenated fruit list: fruits: | apple | banana | orange

        JSArray boolArray = JSArray.of(new boolean[]{true, false, true, false});
        JSFunction andFunction = JSFunction.fromGeneralBiFunction((JSBoolean acc, JSBoolean val) ->
                JSBoolean.of(acc.as(Boolean.class) && val.as(Boolean.class)));
        JSIterator booleanIterator = JSIterator.from(boolArray);
        boolean andResult = booleanIterator.reduce(andFunction, true);
        System.out.println("Logical AND of [true, false, true, false]: " + andResult);
        // Expected: Logical AND of [true, false, true, false]: false
    }
}
