package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class ToUpperCaseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.toUpperCase Demo ===");

        JSString text = JSString.of("The quick brown fox jumps over the lazy dog.");

        String result = text.toUpperCase().as(String.class);
        System.out.println("toUpperCase(): " + result);
        // Expected: toUpperCase(): THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.

        // Assert values
        assertEquals("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.", result);
    }
}