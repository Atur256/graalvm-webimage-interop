package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class ToFixedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toFixed Demo ===");

        JSNumber value1 = JSNumber.of(3.1415926535);
        JSNumber value2 = JSNumber.of(123.456);
        JSNumber value3 = JSNumber.of(0.00001234);

        String result1 = value1.toFixed();
        String result2 = value2.toFixed();
        String result3 = value3.toFixed();
        System.out.println("Default toFixed:");
        System.out.println("3.1415926535: " + result1);
        System.out.println("123.456: " + result2);
        System.out.println("0.00001234: " + result3);
        // Expected:
        // Default toFixed:
        // 3.1415926535: 3
        // 123.456: 123
        // 0.00001234: 0

        String result4 = value1.toFixed(2);
        String result5 = value2.toFixed(4);
        String result6 = value3.toFixed(8);
        System.out.println("\ntoFixed with precision:");
        System.out.println("3.1415926535: " + result4);
        System.out.println("123.456: " + result5);
        System.out.println("0.00001234: " + result6);
        // Expected:
        // toFixed with precision:
        // 3.1415926535: 3.14
        // 123.456: 123.4560
        // 0.00001234: 0.00001234

        // Assert values
        assertEquals("3", result1);
        assertEquals("123", result2);
        assertEquals("0", result3);
        assertEquals("3.14", result4);
        assertEquals("123.4560", result5);
        assertEquals("0.00001234", result6);
    }
}