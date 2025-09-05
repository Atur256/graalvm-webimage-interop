package demos.jsRegExp;

import builtin.JSRegExp;


public class LastIndexDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.lastIndex Demo ===");

        JSRegExp regex = JSRegExp.of("a", "g");
        System.out.println("Initial lastIndex: " + regex.lastIndex);
        // Expected Output: Initial lastIndex: 0
    }
}
