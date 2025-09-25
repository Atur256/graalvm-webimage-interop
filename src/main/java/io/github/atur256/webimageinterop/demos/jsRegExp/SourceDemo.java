package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;

public class SourceDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.source Demo ===");

        JSRegExp regex = JSRegExp.of("abc", "");
        System.out.println("Source: " + regex.source);
        // Expected: Source: abc
    }
}
