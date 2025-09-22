package demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class ToExponentialDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toExponential Demo ===");

        JSNumber value1 = JSNumber.of(0.00001234);
        JSNumber value2 = JSNumber.of(123456789);
        JSNumber value3 = JSNumber.of(3.14159265358979);

        System.out.println("Default exponential:");
        System.out.println("0.00001234: " + value1.toExponential());
        System.out.println("123456789: " + value2.toExponential());
        System.out.println("π: " + value3.toExponential());
        // Expected:
        // Default exponential:
        // 0.00001234: 1.234e-5
        // 123456789: 1.23456789e+8
        // π: 3.14159265358979e+0

        System.out.println("\nExponential with precision:");
        System.out.println("0.00001234: " + value1.toExponential(2));
        System.out.println("123456789: " + value2.toExponential(4));
        System.out.println("π: " + value3.toExponential(6));
        // Expected:
        // Exponential with precision:
        // 0.00001234: 1.23e-5
        // 123456789: 1.2346e+8
        // π: 3.141593e+0
    }
}
