package demos.function;

import builtin.Function;


public class NameDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Function.name Demo ===");

        Function f = Function.fromBody("return 'test';");
        System.out.println("Function name: " + f.name());
        // Expected: "anonymous"
    }
}
