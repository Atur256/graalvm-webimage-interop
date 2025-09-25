package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;

public class MultilineDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.multiline Demo ===");

        JSRegExp regex = JSRegExp.of("^x", "m");
        System.out.println("Multiline? " + regex.multiline);
        // Expected: Multiline? true
    }
}
