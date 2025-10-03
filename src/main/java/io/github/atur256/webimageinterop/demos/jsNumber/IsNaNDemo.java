package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.*;


public class IsNaNDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Number.isNaN Demo ===");

        // JSValue examples
        JSValue jsValid = JSNumber.of(42);
        JSValue jsNaN = JSNumber.of(Double.NaN);
        JSValue jsInfinity = JSNumber.of(Double.POSITIVE_INFINITY);

        boolean result1 = JSNumber.isNaN(jsValid);
        boolean result2 = JSNumber.isNaN(jsNaN);
        boolean result3 = JSNumber.isNaN(jsInfinity);
        System.out.println("JSValue 42 isNaN: " + result1);
        System.out.println("JSValue NaN isNaN: " + result2);
        System.out.println("JSValue Infinity isNaN: " + result3);
        // Expected:
        // JSValue 42 isNaN: false
        // JSValue NaN isNaN: true
        // JSValue Infinity isNaN: false

        // Java Number examples
        int javaIntValid = 123;
        double javaDoubleValid = 1.23;
        double javaNaN = Double.NaN;
        double javaInfinity = Double.NEGATIVE_INFINITY;

        boolean result4 = JSNumber.isNaN(javaIntValid);
        boolean result5 = JSNumber.isNaN(javaDoubleValid);
        boolean result6 = JSNumber.isNaN(javaNaN);
        boolean result7 = JSNumber.isNaN(javaInfinity);
        System.out.println("Number 123 isNaN: " + result4);
        System.out.println("Number 1.23 isNaN: " + result5);
        System.out.println("Number NaN isNaN: " + result6);
        System.out.println("Number -Infinity isNaN: " + result7);
        // Expected:
        // Number 123 isNaN: false
        // Number 1.23 isNaN: false
        // Number NaN isNaN: true
        // Number -Infinity isNaN: false

        // Assert values
        assertFalse(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertFalse(result5);
        assertTrue(result6);
        assertFalse(result7);
    }
}