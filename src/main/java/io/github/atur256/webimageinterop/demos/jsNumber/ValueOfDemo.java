package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class ValueOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.valueOf Demo ===");

        JSNumber jsNum1 = JSNumber.of(42);
        JSNumber jsNum2 = JSNumber.of(3.14159);
        JSNumber jsNum3 = JSNumber.of(Double.NaN);

        double result1 = jsNum1.valueOf();
        double result2 = jsNum2.valueOf();
        double result3 = jsNum3.valueOf();

        System.out.println("JSNumber 42 valueOf: " + result1);
        System.out.println("JSNumber π valueOf: " + result2);
        System.out.println("JSNumber NaN valueOf: " + result3);
        // Expected:
        // JSNumber 42 valueOf: 42.0
        // JSNumber π valueOf: 3.14159
        // JSNumber NaN valueOf: NaN

        // Assert values
        assertEquals(42.0, result1, 0.0);
        assertEquals(3.14159, result2, 0.000001);
        assertEquals(Double.NaN, result3, 0.0);
    }
}