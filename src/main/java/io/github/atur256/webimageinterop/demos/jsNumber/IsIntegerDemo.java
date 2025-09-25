package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class IsIntegerDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.isInteger Demo ===");

        // JSNumber examples
        JSNumber jsInt = JSNumber.of(42);
        JSNumber jsFloat = JSNumber.of(3.14);
        JSNumber jsNaN = JSNumber.of(Double.NaN);
        JSNumber jsInfinity = JSNumber.of(Double.POSITIVE_INFINITY);

        System.out.println("JSNumber 42 isInteger: " + JSNumber.isInteger(jsInt));
        System.out.println("JSNumber 3.14 isInteger: " + JSNumber.isInteger(jsFloat));
        System.out.println("JSNumber NaN isInteger: " + JSNumber.isInteger(jsNaN));
        System.out.println("JSNumber Infinity isInteger: " + JSNumber.isInteger(jsInfinity));
        // Expected:
        // JSNumber 42 isInteger: true
        // JSNumber 3.14 isInteger: false
        // JSNumber NaN isInteger: false
        // JSNumber Infinity isInteger: false

        // Java Number examples
        Number javaInt = 100;
        Number javaFloat = 2.718;
        Number javaNaN = Double.NaN;
        Number javaInfinity = Double.NEGATIVE_INFINITY;

        System.out.println("Number 100 isInteger: " + JSNumber.isInteger(javaInt));
        System.out.println("Number 2.718 isInteger: " + JSNumber.isInteger(javaFloat));
        System.out.println("Number NaN isInteger: " + JSNumber.isInteger(javaNaN));
        System.out.println("Number -Infinity isInteger: " + JSNumber.isInteger(javaInfinity));
        // Expected:
        // Number 100 isInteger: true
        // Number 2.718 isInteger: false
        // Number NaN isInteger: false
        // Number -Infinity isInteger: false

    }
}
