package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;


public class TestDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.test Demo ===");

        JSRegExp regex = JSRegExp.of("hello", "i");
        boolean result = regex.test("Hello world");
        System.out.println("Match found? " + result);
        // Expected: Match found? true
    }
}
