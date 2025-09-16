package demos.jsRegExp;

import builtin.JSRegExp;

public class GlobalDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.global Demo ===");

        JSRegExp regex = JSRegExp.of("x", "g");
        System.out.println("Global? " + regex.global);
        // Expected: Global? true
    }
}
