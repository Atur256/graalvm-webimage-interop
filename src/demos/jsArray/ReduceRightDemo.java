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

        JSArray sumArray = JSArray.of(new JSNumber[]{JSNumber.of(1), JSNumber.of(2), JSNumber.of(3)});
        JSFunction sumRightFunction = JSFunction.fromArgs("acc", "val", "return acc + val;");
        JSValue sumRightResult = sumArray.reduceRight(sumRightFunction, JSNumber.of(0));
        System.out.println("Sum (right to left) of [1, 2, 3]: " + sumRightResult.as(Integer.class));
        // Expected: 6

        JSArray productArray = JSArray.of(new int[]{2, 4, 10});
        JSFunction multiplyRightFunction = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        JSValue productRightResult = productArray.reduceRight(multiplyRightFunction, 1);
        System.out.println("Product (right to left) of [2, 4, 10]: " + productRightResult.as(Integer.class));
        // Expected: 80

        JSArray subtractionArray = JSArray.of(new double[]{1.4, 2.6, 5.6, 7.0});
        JSFunction subtractRightFunction = JSFunction.fromGeneralBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Double.class) - val.as(Double.class)));
        JSValue subtractionRightResult = subtractionArray.reduceRight(subtractRightFunction, 2.14);
        System.out.println("Sequential subtraction (right to left): " + subtractionRightResult.as(Double.class));
        // Expected: ~-14.46

        JSArray fruitsArray = JSArray.of("apple", "banana", "orange");
        JSFunction concatRightFunction = JSFunction.fromGeneralBiFunction((JSString acc, String val) ->
               JSString.of (acc.as(String.class) + " | " + val));
        JSValue concatRightResult = fruitsArray.reduceRight(concatRightFunction, "fruits:");
        System.out.println("Concatenated fruit list (right to left): " + concatRightResult.as(String.class));
        // Expected: fruits: | orange | banana | apple

        JSArray boolArray = JSArray.of(new boolean[]{false, true, false});
        JSFunction andRightFunction = JSFunction.fromGeneralBiFunction((JSBoolean acc, JSBoolean val) ->
                JSBoolean.of(acc.as(Boolean.class) && val.as(Boolean.class)));
        JSValue andRightResult = boolArray.reduceRight(andRightFunction, true);
        System.out.println("Logical AND (right to left) of [true, false, true, false]: " + andRightResult.as(Boolean.class));
        // Expected: false
    }
}
