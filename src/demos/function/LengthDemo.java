package demos.function;

import builtin.Function;


public class LengthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Function.length Demo ===");

        Function f = Function.fromArgs(new String[]{"x", "y", "z", "return x + y + z;"});
        System.out.println("Declared parameters: " + f.length());
        // Expected: 3
    }
}
