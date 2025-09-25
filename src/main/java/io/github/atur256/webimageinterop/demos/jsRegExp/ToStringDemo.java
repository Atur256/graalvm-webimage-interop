package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.toString Demo ===");

        JSRegExp regex = JSRegExp.of("abc", "g");
        System.out.println("Regex string: " + regex.toString());
        // Expected: Regex string: /abc/g
    }
}
