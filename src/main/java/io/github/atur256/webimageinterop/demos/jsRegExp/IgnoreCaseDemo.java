package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;

public class IgnoreCaseDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.ignoreCase Demo ===");

        JSRegExp regex = JSRegExp.of("x", "i");
        System.out.println("Ignore case? " + regex.ignoreCase);
        // Expected: Ignore case? true
    }
}
