package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IsIntegerDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.isInteger Demo ===");

        // JSNumber examples
        JSNumber jsInt = JSNumber.of(42);
        JSNumber jsFloat = JSNumber.of(3.14);
        JSNumber jsNaN = JSNumber.of(Double.NaN);
        JSNumber jsInfinity = JSNumber.of(Double.POSITIVE_INFINITY);

        boolean result1 = JSNumber.isInteger(jsInt);
        boolean result2 = JSNumber.isInteger(jsFloat);
        boolean result3 = JSNumber.isInteger(jsNaN);
        boolean result4 = JSNumber.isInteger(jsInfinity);
        System.out.println("JSNumber 42 isInteger: " + result1);
        System.out.println("JSNumber 3.14 isInteger: " + result2);
        System.out.println("JSNumber NaN isInteger: " + result3);
        System.out.println("JSNumber Infinity isInteger: " + result4);
        // Expected:
        // JSNumber 42 isInteger: true
        // JSNumber 3.14 isInteger: false
        // JSNumber NaN isInteger: false
        // JSNumber Infinity isInteger: false

        // Java Number examples
        int javaInt = 100;
        double javaFloat = 2.718;
        double javaNaN = Double.NaN;
        double javaInfinity = Double.NEGATIVE_INFINITY;

        boolean result5 = JSNumber.isInteger(javaInt);
        boolean result6 = JSNumber.isInteger(javaFloat);
        boolean result7 = JSNumber.isInteger(javaNaN);
        boolean result8 = JSNumber.isInteger(javaInfinity);
        System.out.println("Number 100 isInteger: " + result5);
        System.out.println("Number 2.718 isInteger: " + result6);
        System.out.println("Number NaN isInteger: " + result7);
        System.out.println("Number -Infinity isInteger: " + result8);
        // Expected:
        // Number 100 isInteger: true
        // Number 2.718 isInteger: false
        // Number NaN isInteger: false
        // Number -Infinity isInteger: false

        // Assert values
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertTrue(result5);
        assertFalse(result6);
        assertFalse(result7);
        assertFalse(result8);
    }
}