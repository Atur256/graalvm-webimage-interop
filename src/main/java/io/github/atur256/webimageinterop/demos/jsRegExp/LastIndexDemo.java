package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;


public class LastIndexDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.lastIndex Demo ===");

        JSRegExp regex = JSRegExp.of("a", "g");
        System.out.println("Initial lastIndex: " + regex.lastIndex);
        // Expected: Initial lastIndex: 0
    }
}
