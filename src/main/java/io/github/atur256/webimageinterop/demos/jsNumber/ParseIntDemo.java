package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class ParseIntDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.parseInt Demo ===");

        // Number inputs
        System.out.println("parseInt(42.9): " + JSNumber.parseInt(42.9));
        System.out.println("parseInt(-3.99): " + JSNumber.parseInt(-3.99));
        // Expected:
        // parseInt(42.9): 42
        // parseInt(-3.99): -3

        // String inputs
        System.out.println("parseInt(\"123\"): " + JSNumber.parseInt("123"));
        System.out.println("parseInt(\"123.456\"): " + JSNumber.parseInt("123.456"));
        System.out.println("parseInt(\"abc\"): " + JSNumber.parseInt("abc"));
        // Expected:
        // parseInt("123"): 123
        // parseInt("123.456"): 123
        // parseInt("abc"): 0 // Note: returns NaN in JS but gets mapped to 0 in Java

        // String with radix
        System.out.println("parseInt(\"1010\", 2): " + JSNumber.parseInt("1010", 2));
        System.out.println("parseInt(\"FF\", 16): " + JSNumber.parseInt("FF", 16));
        System.out.println("parseInt(\"77\", 8): " + JSNumber.parseInt("77", 8));
        // Expected:
        // parseInt("1010", 2): 10
        // parseInt("FF", 16): 255
        // parseInt("77", 8): 63
    }
}
