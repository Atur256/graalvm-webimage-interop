package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;


public class UnicodeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.unicode Demo ===");

        JSRegExp regex = JSRegExp.of("\\u{1F600}", "u");
        System.out.println("Unicode? " + regex.unicode);
        // Expected: Unicode? true
    }
}
