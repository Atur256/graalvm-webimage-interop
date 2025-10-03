package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IsFiniteDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.isFinite Demo ===");

        // JSNumber examples
        JSNumber jsFinite = JSNumber.of(42);
        JSNumber jsInfinite = JSNumber.of(Double.POSITIVE_INFINITY);
        JSNumber jsNaN = JSNumber.of(Double.NaN);

        boolean result1 = JSNumber.isFinite(jsFinite);
        boolean result2 = JSNumber.isFinite(jsInfinite);
        boolean result3 = JSNumber.isFinite(jsNaN);
        System.out.println("JSNumber 42 isFinite: " + result1);
        System.out.println("JSNumber Infinity isFinite: " + result2);
        System.out.println("JSNumber NaN isFinite: " + result3);
        // Expected:
        // JSNumber 42 isFinite: true
        // JSNumber Infinity isFinite: false
        // JSNumber NaN isFinite: false

        // Java Number examples
        int javaIntFinite = 123;
        double javaDoubleFinite = 1.23;
        double javaInfinite = Double.NEGATIVE_INFINITY;
        double javaNaN = Double.NaN;

        boolean result4 = JSNumber.isFinite(javaIntFinite);
        boolean result5 = JSNumber.isFinite(javaDoubleFinite);
        boolean result6 = JSNumber.isFinite(javaInfinite);
        boolean result7 = JSNumber.isFinite(javaNaN);

        System.out.println("Number 123 isFinite: " + result4);
        System.out.println("Number 1.23 isFinite: " + result5);
        System.out.println("Number -Infinity isFinite: " + result6);
        System.out.println("Number NaN isFinite: " + result7);
        // Expected:
        // Number 123 isFinite: true
        // Number 1.23 isFinite: true
        // Number -Infinity isFinite: false
        // Number NaN isFinite: false

        // Assert values
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertTrue(result4);
        assertTrue(result5);
        assertFalse(result6);
        assertFalse(result7);
    }
}