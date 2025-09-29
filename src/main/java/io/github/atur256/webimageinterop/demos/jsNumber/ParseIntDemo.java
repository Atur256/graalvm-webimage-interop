package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class ParseIntDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.parseInt Demo ===");

        // Number inputs
        int result1 = JSNumber.parseInt(42.9);
        int result2 = JSNumber.parseInt(-3.99);
        System.out.println("parseInt(42.9): " + result1);
        System.out.println("parseInt(-3.99): " + result2);
        // Expected:
        // parseInt(42.9): 42
        // parseInt(-3.99): -3

        // String inputs
        int result3 = JSNumber.parseInt("123");
        int result4 = JSNumber.parseInt("123.456");
        int result5 = JSNumber.parseInt("abc");
        System.out.println("parseInt(\"123\"): " + result3);
        System.out.println("parseInt(\"123.456\"): " + result4);
        System.out.println("parseInt(\"abc\"): " + result5);
        // Expected:
        // parseInt("123"): 123
        // parseInt("123.456"): 123
        // parseInt("abc"): 0 // Note: returns NaN in JS but gets mapped to 0 in Java

        // String with radix
        int result6 = JSNumber.parseInt("1010", 2);
        int result7 = JSNumber.parseInt("FF", 16);
        int result8 = JSNumber.parseInt("77", 8);
        System.out.println("parseInt(\"1010\", 2): " + result6);
        System.out.println("parseInt(\"FF\", 16): " + result7);
        System.out.println("parseInt(\"77\", 8): " + result8);
        // Expected:
        // parseInt("1010", 2): 10
        // parseInt("FF", 16): 255
        // parseInt("77", 8): 63

        // Assert values
        assertEquals(42, result1);
        assertEquals(-3, result2);
        assertEquals(123, result3);
        assertEquals(123, result4);
        assertEquals(0, result5);
        assertEquals(10, result6);
        assertEquals(255, result7);
        assertEquals(63, result8);
    }
}