package demos.jsRegExp;

import builtin.JSRegExp;


public class DotAllDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.dotAll Demo ===");

        JSRegExp regex = JSRegExp.of(".", "s");
        System.out.println("dotAll enabled? " + regex.dotAll);
        // Expected: dotAll enabled? true
    }
}
