package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IncludesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.includes Demo ===");

        JSArray arr = JSArray.of(JSString.of("x"), JSString.of("y"));
        boolean result1 = arr.includes(JSString.of("y"));
        System.out.println("Includes 'y': " + result1);
        assertTrue(result1);
        // Expected:
        // Includes 'y': true

        JSArray javaArr = JSArray.of("x", "y", "z");
        boolean result2 = javaArr.includes("y");
        System.out.println("Includes 'y': " + result2);
        assertTrue(result2);
        boolean result3 = javaArr.includes("a");
        System.out.println("Includes 'a': " + result3);
        assertFalse(result3);
        // Expected:
        // Includes 'y': true
        // Includes 'a': false

        JSArray javaArr2 = JSArray.of(1, 3, 7, 2, 8);
        boolean result4 = javaArr2.includes(4);
        System.out.println("Includes '4': " + result4);
        assertFalse(result4);
        // Expected:
        // Includes '4': false

        JSArray javaArr3 = JSArray.of(1.4, 3.64, 7.0, 2.12, 8.9);
        boolean result5 = javaArr3.includes(4.1);
        System.out.println("Includes '4.1': " + result5);
        assertFalse(result5);
        // Expected:
        // Includes '4.1': false

        JSArray javaArr4 = JSArray.of(true, true);
        boolean result6 = javaArr4.includes(true);
        System.out.println("Includes 'true': " + result6);
        assertTrue(result6);
        boolean result7 = javaArr4.includes(false);
        System.out.println("Includes 'false': " + result7);
        assertFalse(result7);
        // Expected:
        // Includes 'true': true
        // Includes 'false': false
    }
}
