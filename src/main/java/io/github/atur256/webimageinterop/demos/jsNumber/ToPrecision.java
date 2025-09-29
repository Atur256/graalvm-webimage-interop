package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class ToPrecision {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toPrecision Demo ===");

        JSNumber value1 = JSNumber.of(123.456789);
        JSNumber value2 = JSNumber.of(0.0000123456789);
        JSNumber value3 = JSNumber.of(987654321.123);

        String result1 = value1.toPrecision();
        String result2 = value2.toPrecision();
        String result3 = value3.toPrecision();
        System.out.println("Default precision:");
        System.out.println("123.456789: " + result1);
        System.out.println("0.0000123456789: " + result2);
        System.out.println("987654321.123: " + result3);
        // Expected:
        // Default precision:
        // 123.456789: 123.456789
        // 0.0000123456789: 0.0000123456789
        // 987654321.123: 987654321.123

        String result4 = value1.toPrecision(4);
        String result5 = value2.toPrecision(3);
        String result6 = value3.toPrecision(6);
        System.out.println("\nWith specified precision:");
        System.out.println("123.456789: " + result4);
        System.out.println("0.0000123456789: " + result5);
        System.out.println("987654321.123: " + result6);
        // Expected:
        // With specified precision:
        // 123.456789: 123.5
        // 0.0000123456789: 0.0000123
        // 987654321.123: 9.87654e+8

        // Assert values
        assertEquals("123.456789", result1);
        assertEquals("0.0000123456789", result2);
        assertEquals("987654321.123", result3);
        assertEquals("123.5", result4);
        assertEquals("0.0000123", result5);
        assertEquals("9.87654e+8", result6);
    }
}