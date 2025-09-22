package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;


public class FindLastIndexDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.findLastIndex Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(3), JSNumber.of(7), JSNumber.of(9));
        JSFunction isOdd = JSFunction.fromBody("return arg % 2 !== 0;");
        int index = arr.findLastIndex(isOdd);
        System.out.println("Last odd index: " + index);
        // Expected: Last odd index: 2

        JSArray javaArr = JSArray.of(4, 6, 9);
        JSFunction isEven = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) % 2 == 0));
        int index2 = javaArr.findLastIndex(isEven);
        System.out.println("Last odd index: " + index2);
        // Expected: Last odd index: 1
    }
}
