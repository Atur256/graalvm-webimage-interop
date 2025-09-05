package demos.jsRegExp;

import builtin.JSRegExp;

public class IgnoreCaseDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.ignoreCase Demo ===");

        JSRegExp regex = JSRegExp.of("x", "i");
        System.out.println("Ignore case? " + regex.ignoreCase);
        // Expected Output: Ignore case? true
    }
}
