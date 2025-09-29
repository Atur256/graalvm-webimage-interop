package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StartsWithDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.startsWith Demo ===");

        JSString text = JSString.of("To be, or not to be, that is the question.");

        boolean result1 = text.startsWith("To be");
        boolean result2 = text.startsWith("to be");
        boolean result3 = text.startsWith(JSString.of("To be"));
        boolean result4 = text.startsWith(JSString.of("question"));
        boolean result5 = text.startsWith("not", 10);
        boolean result6 = text.startsWith("To", 3);
        boolean result7 = text.startsWith(JSString.of("not"), 10);
        boolean result8 = text.startsWith(JSString.of("To"), 3);
        boolean result9 = text.startsWith("To", 100);
        boolean result10 = text.startsWith(JSString.of("To"), 100);

        System.out.println("startsWith(\"To be\"): " + result1);
        System.out.println("startsWith(\"to be\"): " + result2);
        System.out.println("startsWith(JSString.of(\"To be\")): " + result3);
        System.out.println("startsWith(JSString.of(\"question\")): " + result4);
        System.out.println("startsWith(\"not\", 10): " + result5);
        System.out.println("startsWith(\"To\", 3): " + result6);
        System.out.println("startsWith(JSString.of(\"not\"), 10): " + result7);
        System.out.println("startsWith(JSString.of(\"To\"), 3): " + result8);
        System.out.println("startsWith(\"To\", 100): " + result9);
        System.out.println("startsWith(JSString.of(\"To\"), 100): " + result10);
        // Expected:
        // startsWith("To be"): true
        // startsWith("to be"): false
        // startsWith(JSString.of("To be")): true
        // startsWith(JSString.of("question")): false
        // startsWith("not", 10): true
        // startsWith("To", 3): false
        // startsWith(JSString.of("not"), 10): true
        // startsWith(JSString.of("To"), 3): false
        // startsWith("To", 100): false
        // startsWith(JSString.of("To"), 100): false

        // Assert values
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertTrue(result5);
        assertFalse(result6);
        assertTrue(result7);
        assertFalse(result8);
        assertFalse(result9);
        assertFalse(result10);
    }
}