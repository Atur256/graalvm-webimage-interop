package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class ToLowerCaseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.toLowerCase Demo ===");

        JSString text = JSString.of("The quick brown fox jumps over the lazy dog.");

        String result = text.toLowerCase().as(String.class);
        System.out.println("toLowerCase(): " + result);
        // Expected: toLowerCase(): the quick brown fox jumps over the lazy dog.

        // Assert values
        assertEquals("the quick brown fox jumps over the lazy dog.", result);
    }
}