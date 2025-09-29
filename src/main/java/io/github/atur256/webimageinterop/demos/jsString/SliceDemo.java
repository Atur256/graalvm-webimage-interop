package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class SliceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.slice Demo ===");

        JSString text = JSString.of("The quick brown fox jumps over the lazy dog.");

        String result1 = text.slice(31).as(String.class);
        String result2 = text.slice(-4).as(String.class);
        String result3 = text.slice(4, 19).as(String.class);
        String result4 = text.slice(-9, -5).as(String.class);
        System.out.printf("\"%s\".slice(31): %s\n", text.asString(), result1);
        System.out.printf("\"%s\".slice(-4): %s\n", text.asString(), result2);
        System.out.printf("\"%s\".slice(4, 19): %s\n", text.asString(), result3);
        System.out.printf("\"%s\".slice(-9, -5): %s\n", text.asString(), result4);
        // Expected:
        // "The quick brown fox jumps over the lazy dog.".slice(31): the lazy dog.
        // "The quick brown fox jumps over the lazy dog.".slice(-4): dog.
        // "The quick brown fox jumps over the lazy dog.".slice(4, 19): quick brown fox"
        // The quick brown fox jumps over the lazy dog.".slice(-9, -5): lazy

        // Assert values
        assertEquals("the lazy dog.", result1);
        assertEquals("dog.", result2);
        assertEquals("quick brown fox", result3);
        assertEquals("lazy", result4);
    }
}