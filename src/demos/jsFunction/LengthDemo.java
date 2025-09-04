package demos.jsFunction;

import builtin.JSFunction;


public class LengthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.length Demo ===");

        JSFunction f = JSFunction.fromArgs(new String[]{"x", "y", "z", "return x + y + z;"});
        System.out.println("Declared parameters: " + f.length());
        // Expected: 3
    }
}
