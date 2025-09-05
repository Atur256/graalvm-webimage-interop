package demos.jsRegExp;

import builtin.JSRegExp;


public class HasIndicesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.hasIndices Demo ===");

        JSRegExp regex = JSRegExp.of("x", "d");
        System.out.println("Has indices? " + regex.hasIndices);
        // Expected Output: Has indices? true
    }
}
