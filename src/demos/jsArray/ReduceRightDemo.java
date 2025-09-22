package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class ReduceRightDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reduceRight Demo ===");

        JSArray sumArray = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction sumRightFunction = JSFunction.fromArgs("acc", "val", "return acc + val;");
        JSValue sumRightResult = sumArray.reduceRight(sumRightFunction, JSNumber.of(0));
        System.out.println("Sum (right to left) of [1, 2, 3]: " + sumRightResult.as(Integer.class));
        // Expected: Sum (right to left) of [1, 2, 3]: 6

        JSArray productArray1 = JSArray.of(2, 4, 10);
        JSFunction multiplyRightFunction1 = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        int productRightResult1 = productArray1.reduceRight(multiplyRightFunction1, 1);
        System.out.println("Product (right to left) of [2, 4, 10]: " + productRightResult1);
        // Expected: Product (right to left) of [2, 4, 10]: 80

        JSArray productArray2 = JSArray.of(2, 4, 10);
        JSFunction multiplyRightFunction2 = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        int productRightResult2 = productArray2.reduceRight(multiplyRightFunction2, Integer.class);
        System.out.println("Product (right to left) of [2, 4, 10]: " + productRightResult2);
        // Expected: Product (right to left) of [2, 4, 10]: 80

        JSArray subtractionArray = JSArray.of(1.4, 2.6, 5.6, 7.0);
        JSFunction subtractRightFunction = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Double.class) - val.as(Double.class)));
        double subtractionRightResult = subtractionArray.reduceRight(subtractRightFunction, 2.14);
        System.out.println("Sequential subtraction (right to left): " + subtractionRightResult);
        // Expected: Sequential subtraction (right to left): ~-14.46

        JSArray fruitsArray = JSArray.of("apple", "banana", "orange");
        JSFunction concatRightFunction = JSFunction.fromGeneralBiFunction((JSString acc, JSString val) ->
                JSString.of(acc.as(String.class) + " | " + val.as(String.class)));
        String concatRightResult = fruitsArray.reduceRight(concatRightFunction, "fruits:");
        System.out.println("Concatenated fruit list (right to left): " + concatRightResult);
        // Expected: Concatenated fruit list (right to left): fruits: | orange | banana | apple

        JSArray boolArray = JSArray.of(false, true, false);
        JSFunction andRightFunction = JSFunction.fromGeneralBiFunction((JSBoolean acc, JSBoolean val) ->
                JSBoolean.of(acc.as(Boolean.class) && val.as(Boolean.class)));
        boolean andRightResult = boolArray.reduceRight(andRightFunction, true);
        System.out.println("Logical AND (right to left) of [true, false, true, false]: " + andRightResult);
        // Expected: Logical AND (right to left) of [true, false, true, false]: false
    }
}
