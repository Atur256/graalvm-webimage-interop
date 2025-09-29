package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toString Demo ===");

        JSNumber value1 = JSNumber.of(255);
        JSNumber value2 = JSNumber.of(3.14159);
        JSNumber value3 = JSNumber.of(-42);

        // Default toString (base 10)
        String result1 = value1.toString();
        String result2 = value2.toString();
        String result3 = value3.toString();
        System.out.println("255: " + result1);
        System.out.println("3.14159: " + result2);
        System.out.println("-42: " + result3);
        // Expected:
        // 255: 255
        // 3.14159: 3.14159
        // -42: -42

        // toString with radix
        String result4 = value1.toString(2);
        String result5 = value1.toString(16);
        String result6 = value1.toString(8);
        String result7 = value3.toString(5);
        System.out.println("\nRadix conversion:");
        System.out.println("255 in binary: " + result4);
        System.out.println("255 in hex: " + result5);
        System.out.println("255 in octal: " + result6);
        System.out.println("-42 in base 5: " + result7);
        // Expected:
        // Radix conversion:
        // 255 in binary: 11111111
        // 255 in hex: ff
        // 255 in octal: 377
        // -42 in base 5: -132

        // Assert values
        assertEquals("255", result1);
        assertEquals("3.14159", result2);
        assertEquals("-42", result3);
        assertEquals("11111111", result4);
        assertEquals("ff", result5);
        assertEquals("377", result6);
        assertEquals("-132", result7);
    }
}