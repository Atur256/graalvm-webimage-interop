package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class PadStartDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.padStart Demo ===");

        JSString base = JSString.of("Hi");

        String result1 = base.padStart(5).as(String.class);
        String result2 = base.padStart(5, "-").as(String.class);
        String result3 = base.padStart(7, JSString.of("-")).as(String.class);
        System.out.println("padStart(5): " + result1);
        System.out.println("padStart(5, '-'): " + result2);
        System.out.println("padStart(7, JSString('-')): " + result3);
        // Expected:
        // padStart(5):    Hi
        // padStart(5, '-'): ---Hi
        // padStart(7, JSString('-')): -----Hi

        // Assert values
        assertEquals("   Hi", result1);
        assertEquals("---Hi", result2);
        assertEquals("-----Hi", result3);
    }
}