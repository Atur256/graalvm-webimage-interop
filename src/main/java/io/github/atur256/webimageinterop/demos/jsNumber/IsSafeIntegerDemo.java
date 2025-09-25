package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class IsSafeIntegerDemo {

    public static void main(String[] args) {
        System.out.println("\n=== isSafeInteger Demo ===");

        // JSValue examples
        JSValue jsSafe = JSNumber.of(9007199254740991L); // Max safe integer
        JSValue jsUnsafe = JSNumber.of(9007199254740992L); // Just beyond safe
        JSValue jsFloat = JSNumber.of(3.14);
        JSValue jsNaN = JSNumber.of(Double.NaN);

        System.out.println("JSValue 9007199254740991 isSafeInteger: " + JSNumber.isSafeInteger(jsSafe));
        System.out.println("JSValue 9007199254740992 isSafeInteger: " + JSNumber.isSafeInteger(jsUnsafe));
        System.out.println("JSValue 3.14 isSafeInteger: " + JSNumber.isSafeInteger(jsFloat));
        System.out.println("JSValue NaN isSafeInteger: " + JSNumber.isSafeInteger(jsNaN));
        // Expected:
        // JSValue 9007199254740991 isSafeInteger: true
        // JSValue 9007199254740992 isSafeInteger: false
        // JSValue 3.14 isSafeInteger: false
        // JSValue NaN isSafeInteger: false

        // Java Number examples
        Number javaSafe = 42;
        Number javaUnsafe = 1e100;
        Number javaFloat = 2.718;
        Number javaNaN = Double.NaN;

        System.out.println("Number 42 isSafeInteger: " + JSNumber.isSafeInteger(javaSafe));
        System.out.println("Number 1e100 isSafeInteger: " + JSNumber.isSafeInteger(javaUnsafe));
        System.out.println("Number 2.718 isSafeInteger: " + JSNumber.isSafeInteger(javaFloat));
        System.out.println("Number NaN isSafeInteger: " + JSNumber.isSafeInteger(javaNaN));
        // Expected:
        // Number 42 isSafeInteger: true
        // Number 1e100 isSafeInteger: false
        // Number 2.718 isSafeInteger: false
        // Number NaN isSafeInteger: false
    }
}
