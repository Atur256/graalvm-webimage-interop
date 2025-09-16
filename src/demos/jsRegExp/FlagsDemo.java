package demos.jsRegExp;

import builtin.JSRegExp;


public class FlagsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.flags Demo ===");

        JSRegExp regex = JSRegExp.of("x", "gim");
        System.out.println("Flags: " + regex.flags);
        // Expected: Flags: gim
    }
}
