package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class ReduceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reduce Demo ===");

        JSArray sumArray = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction sumFunction = JSFunction.fromArgs("acc", "val", "return acc + val;");
        JSValue sumResult = sumArray.reduce(sumFunction, JSNumber.of(0));
        System.out.println("Sum of [1, 2, 3]: " + sumResult.as(Integer.class));
        // Expected: Sum of [1, 2, 3]: 6

        JSArray productArray1 = JSArray.of(2, 4, 10);
        JSFunction multiplyFunction1 = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        int productResult1 = productArray1.reduce(multiplyFunction1, 1);
        System.out.println("Product of [2, 4, 10]: " + productResult1);
        // Expected: Product of [2, 4, 10]: 80

        JSArray productArray2 = JSArray.of(2, 4, 10);
        JSFunction multiplyFunction2 = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        int productResult2 = productArray2.reduce(multiplyFunction2, Integer.class);
        System.out.println("Product of [2, 4, 10]: " + productResult2);
        // Expected: Product of [2, 4, 10]: 80

        JSArray subtractionArray = JSArray.of(1.4, 2.6, 5.6, 7.0);
        JSFunction subtractFunction = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Double.class) - val.as(Double.class)));
        double subtractionResult = subtractionArray.reduce(subtractFunction, 2.14);
        System.out.println("Result of sequential subtraction: " + subtractionResult);
        // Expected: Result of sequential subtraction: ~-14.46


        JSArray fruitsArray = JSArray.of("apple", "banana", "orange");
        JSFunction concatFunction = JSFunction.fromGeneralBiFunction((JSString acc, JSString val) ->
                JSString.of(acc.as(String.class) + " | " + val.as(String.class)));
        String concatResult = fruitsArray.reduce(concatFunction, "fruits:");
        System.out.println("Concatenated fruit list: " + concatResult);
        // Expected: Concatenated fruit list: fruits: | apple | banana | orange

        JSArray boolArray = JSArray.of(true, false, true, false);
        JSFunction andFunction = JSFunction.fromGeneralBiFunction((JSBoolean acc, JSBoolean val) ->
                JSBoolean.of(acc.as(Boolean.class) && val.as(Boolean.class)));
        boolean andResult = boolArray.reduce(andFunction, true);
        System.out.println("Logical AND of [true, false, true, false]: " + andResult);
        // Expected: Logical AND of [true, false, true, false]: false
    }
}