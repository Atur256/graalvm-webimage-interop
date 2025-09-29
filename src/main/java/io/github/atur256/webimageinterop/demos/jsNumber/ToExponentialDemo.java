package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class ToExponentialDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toExponential Demo ===");

        JSNumber value1 = JSNumber.of(0.00001234);
        JSNumber value2 = JSNumber.of(123456789);
        JSNumber value3 = JSNumber.of(3.14159265358979);

        String result1 = value1.toExponential();
        String result2 = value2.toExponential();
        String result3 = value3.toExponential();
        System.out.println("Default exponential:");
        System.out.println("0.00001234: " + result1);
        System.out.println("123456789: " + result2);
        System.out.println("π: " + result3);
        // Expected:
        // Default exponential:
        // 0.00001234: 1.234e-5
        // 123456789: 1.23456789e+8
        // π: 3.14159265358979e+0

        String result4 = value1.toExponential(2);
        String result5 = value2.toExponential(4);
        String result6 = value3.toExponential(6);
        System.out.println("\nExponential with precision:");
        System.out.println("0.00001234: " + result4);
        System.out.println("123456789: " + result5);
        System.out.println("π: " + result6);
        // Expected:
        // Exponential with precision:
        // 0.00001234: 1.23e-5
        // 123456789: 1.2346e+8
        // π: 3.141593e+0

        // Assert values
        assertEquals("1.234e-5", result1);
        assertEquals("1.23456789e+8", result2);
        assertEquals("3.14159265358979e+0", result3);
        assertEquals("1.23e-5", result4);
        assertEquals("1.2346e+8", result5);
        assertEquals("3.141593e+0", result6);
    }
}