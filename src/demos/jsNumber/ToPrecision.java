package demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class ToPrecision {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toPrecision Demo ===");

        JSNumber value1 = JSNumber.of(123.456789);
        JSNumber value2 = JSNumber.of(0.0000123456789);
        JSNumber value3 = JSNumber.of(987654321.123);

        System.out.println("Default precision:");
        System.out.println("123.456789: " + value1.toPrecision());
        System.out.println("0.0000123456789: " + value2.toPrecision());
        System.out.println("987654321.123: " + value3.toPrecision());
        // Expected:
        // Default precision:
        // 123.456789: 123.456789
        // 0.0000123456789: 0.0000123456789
        // 987654321.123: 987654321.123

        System.out.println("\nWith specified precision:");
        System.out.println("123.456789: " + value1.toPrecision(4));
        System.out.println("0.0000123456789: " + value2.toPrecision(3));
        System.out.println("987654321.123: " + value3.toPrecision(6));
        // Expected:
        // With specified precision:
        // 123.456789: 123.5
        // 0.0000123456789: 0.0000123
        // 987654321.123: 9.87654e+8
    }
}
