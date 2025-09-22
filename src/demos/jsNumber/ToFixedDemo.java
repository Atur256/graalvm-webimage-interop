package demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class ToFixedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toFixed Demo ===");

        JSNumber value1 = JSNumber.of(3.1415926535);
        JSNumber value2 = JSNumber.of(123.456);
        JSNumber value3 = JSNumber.of(0.00001234);

        System.out.println("Default toFixed:");
        System.out.println("3.1415926535: " + value1.toFixed());
        System.out.println("123.456: " + value2.toFixed());
        System.out.println("0.00001234: " + value3.toFixed());
        // Expected:
        // Default toFixed:
        // 3.1415926535: 3
        // 123.456: 123
        // 0.00001234: 0

        System.out.println("\ntoFixed with precision:");
        System.out.println("3.1415926535: " + value1.toFixed(2));
        System.out.println("123.456: " + value2.toFixed(4));
        System.out.println("0.00001234: " + value3.toFixed(8));
        // Expected:
        // toFixed with precision:
        // 3.1415926535: 3.14
        // 123.456: 123.4560
        // 0.00001234: 0.00001234
    }
}