package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class ValueOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.valueOfDemo ===");

        JSString text = JSString.of("To be, or not to be");

        String result = text.valueOf().as(String.class);
        System.out.println("valueOf(): " + result);
        // Expected: valueOf(): To be, or not to be

        // Assert values
        assertEquals("To be, or not to be", result);
    }
}