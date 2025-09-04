package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class FindLastIndexDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.findLastIndex Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSNumber.of(3), JSNumber.of(7), JSNumber.of(9) });
        JSFunction isOdd = JSFunction.fromBody("return arg % 2 !== 0;");
        int index = arr.findLastIndex(isOdd);
        System.out.println("Last odd index: " + index); // Expected: 2
    }
}
