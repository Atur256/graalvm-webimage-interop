package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class FindIndexDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.findIndex Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSNumber.of(3), JSNumber.of(7), JSNumber.of(9)});
        JSFunction isOdd = JSFunction.fromBody("return arg % 2 !== 0;");
        int index = arr.findIndex(isOdd);
        System.out.println("First odd index: " + index); // Expected: 0

        JSArray javaArr = JSArray.of(new int[]{3, 7, 8, 9});
        JSFunction isEven = JSFunction.fromFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) % 2 == 0));
        int index2 = javaArr.findIndex(isEven);
        System.out.println("First odd index: " + index2); // Expected: 2
    }
}
