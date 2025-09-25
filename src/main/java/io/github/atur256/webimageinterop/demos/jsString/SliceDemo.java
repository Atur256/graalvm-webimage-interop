package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class SliceDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.slice Demo ===");

        JSString text = JSString.of("The quick brown fox jumps over the lazy dog.");

        System.out.printf("\"%s\".slice(31): %s\n", text.asString(), text.slice(31).as(String.class));
        System.out.printf("\"%s\".slice(-4): %s\n", text.asString(), text.slice(-4).as(String.class));
        System.out.printf("\"%s\".slice(4, 19): %s\n", text.asString(), text.slice(4, 19).as(String.class));
        System.out.printf("\"%s\".slice(-9, -5): %s\n", text.asString(), text.slice(-9, -5).as(String.class));
        // Expected:
        // "The quick brown fox jumps over the lazy dog.".slice(31): the lazy dog.
        // "The quick brown fox jumps over the lazy dog.".slice(-4): dog.
        // "The quick brown fox jumps over the lazy dog.".slice(4, 19): quick brown fox"
        // The quick brown fox jumps over the lazy dog.".slice(-9, -5): lazy
    }
}
