package demos.jsRegExp;

import builtin.JSRegExp;

public class StickyDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.sticky Demo ===");

        JSRegExp regex = JSRegExp.of("x", "y");
        System.out.println("Sticky? " + regex.sticky);
        // Expected Output: Sticky? true
    }
}
