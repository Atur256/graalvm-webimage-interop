package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;


public class FilterDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.filter Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction isEven = JSFunction.fromBody("return arg % 2 === 0;");
        JSArray filtered = arr.filter(isEven);
        System.out.println("Filtered: " + filtered.toString());
        // Expected: Filtered: [2]

        JSArray javaArr = JSArray.of(1, 4, 9);
        JSFunction isOdd = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) % 2 != 0));
        JSArray filtered2 = javaArr.filter(isOdd);
        System.out.println("Filtered: " + filtered2.toString());
        // Expected: Filtered: [1,9]
    }
}
