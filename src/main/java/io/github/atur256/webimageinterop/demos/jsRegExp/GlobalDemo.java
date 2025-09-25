package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;

public class GlobalDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.global Demo ===");

        JSRegExp regex = JSRegExp.of("x", "g");
        System.out.println("Global? " + regex.global);
        // Expected: Global? true
    }
}
