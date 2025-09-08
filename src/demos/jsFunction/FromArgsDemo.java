package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;


public class FromArgsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromArgs Demo ===");

        JSFunction sum = JSFunction.fromArgs(new String[]{"a", "b", "return a + b;"});
        JSNumber result = sum.apply(null, 5, 7);
        System.out.println("Result: " + result.as(Integer.class));
        // Expected: 12
    }
}