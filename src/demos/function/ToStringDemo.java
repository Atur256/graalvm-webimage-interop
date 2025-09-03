package demos.function;

import builtin.Function;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Function.toStringJS Demo ===");

        Function f = Function.fromBody("return 42;");
        System.out.println("Function source: " + f.toStringJS());
        // Expected: function anonymous(arg) { return 42; }
    }
}
