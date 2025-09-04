package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class ReduceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reduce Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSNumber.of(1), JSNumber.of(2), JSNumber.of(3)});
        JSFunction sumFn = JSFunction.fromArgs(new String[]{"acc", "val", "return acc + val;"});
        JSValue result = arr.reduce(sumFn, JSNumber.of(0));
        System.out.println("Sum: " + result); // Expected: 6
    }
}
