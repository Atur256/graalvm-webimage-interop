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

        JSArray sumArray = JSArray.of(new JSNumber[]{JSNumber.of(1), JSNumber.of(2), JSNumber.of(3)});
        JSFunction sumFunction = JSFunction.fromArgs(new String[]{"acc", "val", "return acc + val;"});
        JSValue sumResult = sumArray.reduce(sumFunction, JSNumber.of(0));
        System.out.println("Sum of [1, 2, 3]: " + sumResult.as(Integer.class));
        // Expected: 6

        JSArray productArray = JSArray.of(2, 4, 10);
        JSFunction multiplyFunction = JSFunction.fromBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Integer.class) * val.as(Integer.class)));
        JSValue productResult = productArray.reduce(multiplyFunction, 1);
        System.out.println("Product of [2, 4, 10]: " + productResult.as(Integer.class));
        // Expected: 80

        JSArray subtractionArray = JSArray.of(1.4, 2.6, 5.6, 7.0);
        JSFunction subtractFunction = JSFunction.fromBiFunction((JSNumber acc, JSNumber val) ->
                JSNumber.of(acc.as(Double.class) - val.as(Double.class)));
        JSValue subtractionResult = subtractionArray.reduce(subtractFunction, 2.14);
        System.out.println("Result of sequential subtraction: " + subtractionResult.as(Double.class));
        // Expected: ~-14.46

        JSArray fruitsArray = JSArray.of("apple", "banana", "orange");
        JSFunction concatFunction = JSFunction.fromBiFunction((JSString acc, JSString val) ->
                JSString.of(acc.as(String.class) + " | " + val.as(String.class)));
        JSValue concatResult = fruitsArray.reduce(concatFunction, "fruits:");
        System.out.println("Concatenated fruit list: " + concatResult.as(String.class));
        // Expected: fruits: | apple | banana | orange

        JSArray boolArray = JSArray.of(true, false, true, false);
        JSFunction andFunction = JSFunction.fromBiFunction((JSBoolean acc, JSBoolean val) ->
                JSBoolean.of(acc.as(Boolean.class) && val.as(Boolean.class)));
        JSValue andResult = boolArray.reduce(andFunction, true);
        System.out.println("Logical AND of [true, false, true, false]: " + andResult.as(Boolean.class));
        // Expected: false
    }
}
