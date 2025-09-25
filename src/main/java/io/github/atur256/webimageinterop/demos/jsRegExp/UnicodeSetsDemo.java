package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;


public class UnicodeSetsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.unicodeSets Demo ===");

        JSRegExp regex = JSRegExp.of("\\p{Script=Latin}", "v");
        System.out.println("Unicode sets? " + regex.unicodeSets);
        // Expected: Unicode sets? true
    }
}
