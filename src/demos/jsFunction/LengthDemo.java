package demos.jsFunction;

import builtin.JSFunction;


public class LengthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.length Demo ===");

        JSFunction jsF = JSFunction.fromArgs(new String[]{"x", "y", "z", "return x + y + z;"});
        System.out.println("Declared parameters: " + jsF.length);
        // Expected: 3

        JSFunction javaF = JSFunction.fromFunction((String arg) -> "Hello, " + arg);
        System.out.println("Declared parameters: " + javaF.length);
        // Expected: 3
    }
}
