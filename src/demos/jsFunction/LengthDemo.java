package demos.jsFunction;

import builtin.JSFunction;


public class LengthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.length Demo ===");

        JSFunction jsF = JSFunction.fromArgs("x", "y", "z", "return x + y + z;");
        System.out.println("Declared parameters: " + jsF.length);
        // Expected: Declared parameters: 3

        JSFunction javaF = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);
        System.out.println("Declared parameters: " + javaF.length);
        // Expected: Declared parameters: 1
    }
}
