package demos.jsRegExp;

import builtin.JSRegExp;

public class SourceDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.source Demo ===");

        JSRegExp regex = JSRegExp.of("abc", "");
        System.out.println("Source: " + regex.source);
        // Expected Output: Source: abc
    }
}
