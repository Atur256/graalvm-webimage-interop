package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toString Demo ===");

        JSNumber value1 = JSNumber.of(255);
        JSNumber value2 = JSNumber.of(3.14159);
        JSNumber value3 = JSNumber.of(-42);

        // Default toString (base 10)
        System.out.println("255: " + value1.toString());
        System.out.println("3.14159: " + value2.toString());
        System.out.println("-42: " + value3.toString());
        // Expected:
        // 255: 255
        // 3.14159: 3.14159
        // -42: -42

        // toString with radix
        System.out.println("\nRadix conversion:");
        System.out.println("255 in binary: " + value1.toString(2));
        System.out.println("255 in hex: " + value1.toString(16));
        System.out.println("255 in octal: " + value1.toString(8));
        System.out.println("-42 in base 5: " + value3.toString(5));
        // Expected:
        // Radix conversion:
        // 255 in binary: 11111111
        // 255 in hex: ff
        // 255 in octal: 377
        // -42 in base 5: -132
    }
}
