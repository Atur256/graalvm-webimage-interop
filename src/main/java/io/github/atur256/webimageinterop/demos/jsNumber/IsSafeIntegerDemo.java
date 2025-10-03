package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IsSafeIntegerDemo {

    public static void main(String[] args) {
        System.out.println("\n=== isSafeInteger Demo ===");

        // JSValue examples
        JSValue jsSafe = JSNumber.of(9007199254740991L); // Max safe integer
        JSValue jsUnsafe = JSNumber.of(9007199254740992L); // Just beyond safe
        JSValue jsFloat = JSNumber.of(3.14);
        JSValue jsNaN = JSNumber.of(Double.NaN);

        boolean result1 = JSNumber.isSafeInteger(jsSafe);
        boolean result2 = JSNumber.isSafeInteger(jsUnsafe);
        boolean result3 = JSNumber.isSafeInteger(jsFloat);
        boolean result4 = JSNumber.isSafeInteger(jsNaN);
        System.out.println("JSValue 9007199254740991 isSafeInteger: " + result1);
        System.out.println("JSValue 9007199254740992 isSafeInteger: " + result2);
        System.out.println("JSValue 3.14 isSafeInteger: " + result3);
        System.out.println("JSValue NaN isSafeInteger: " + result4);
        // Expected:
        // JSValue 9007199254740991 isSafeInteger: true
        // JSValue 9007199254740992 isSafeInteger: false
        // JSValue 3.14 isSafeInteger: false
        // JSValue NaN isSafeInteger: false

        // Java Number examples
        int javaSafe = 42;
        double javaUnsafe = 1e100;
        double javaFloat = 2.718;
        double javaNaN = Double.NaN;

        boolean result5 = JSNumber.isSafeInteger(javaSafe);
        boolean result6 = JSNumber.isSafeInteger(javaUnsafe);
        boolean result7 = JSNumber.isSafeInteger(javaFloat);
        boolean result8 = JSNumber.isSafeInteger(javaNaN);
        System.out.println("Number 42 isSafeInteger: " + result5);
        System.out.println("Number 1e100 isSafeInteger: " + result6);
        System.out.println("Number 2.718 isSafeInteger: " + result7);
        System.out.println("Number NaN isSafeInteger: " + result8);
        // Expected:
        // Number 42 isSafeInteger: true
        // Number 1e100 isSafeInteger: false
        // Number 2.718 isSafeInteger: false
        // Number NaN isSafeInteger: false

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