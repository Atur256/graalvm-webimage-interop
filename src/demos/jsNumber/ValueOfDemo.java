package demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class ValueOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.valueOf Demo ===");

        JSNumber jsNum1 = JSNumber.of(42);
        JSNumber jsNum2 = JSNumber.of(3.14159);
        JSNumber jsNum3 = JSNumber.of(Double.NaN);

        System.out.println("JSNumber 42 valueOf: " + jsNum1.valueOf());
        System.out.println("JSNumber π valueOf: " + jsNum2.valueOf());
        System.out.println("JSNumber NaN valueOf: " + jsNum3.valueOf());
        // Expected:
        // JSNumber 42 valueOf: 42.0
        // JSNumber π valueOf: 3.14159
        // JSNumber NaN valueOf: NaN
    }
}
