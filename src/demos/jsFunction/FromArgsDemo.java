package demos.jsFunction;

import builtin.JSArray;
import builtin.JSFunction;


public class FromArgsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromArgs Demo ===");

        JSFunction sum = JSFunction.fromArgs("a", "b", "return a + b;");
        Integer result = sum.applyJS(null, JSArray.of(5, 7), Integer.class);
        System.out.println("Result: " + result);
        // Expected: 12
    }
}