package demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class IsFiniteDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.isFinite Demo ===");

        // JSNumber examples
        JSNumber jsFinite = JSNumber.of(42);
        JSNumber jsInfinite = JSNumber.of(Double.POSITIVE_INFINITY);
        JSNumber jsNaN = JSNumber.of(Double.NaN);

        System.out.println("JSNumber 42 isFinite: " + JSNumber.isFinite(jsFinite));
        System.out.println("JSNumber Infinity isFinite: " + JSNumber.isFinite(jsInfinite));
        System.out.println("JSNumber NaN isFinite: " + JSNumber.isFinite(jsNaN));
        // Expected:
        // JSNumber 42 isFinite: true
        // JSNumber Infinity isFinite: false
        // JSNumber NaN isFinite: false

        // Java Number examples
        Number javaIntFinite = 123;
        Number javaDoubleFinite = 1.23;
        Number javaInfinite = Double.NEGATIVE_INFINITY;
        Number javaNaN = Double.NaN;

        System.out.println("Number 123 isFinite: " + JSNumber.isFinite(javaIntFinite));
        System.out.println("Number 1.23 isFinite: " + JSNumber.isFinite(javaDoubleFinite));
        System.out.println("Number -Infinity isFinite: " + JSNumber.isFinite(javaInfinite));
        System.out.println("Number NaN isFinite: " + JSNumber.isFinite(javaNaN));
        // Expected:
        // Number 123 isFinite: true
        // Number 1.23 isFinite: true
        // Number -Infinity isFinite: false
        // Number NaN isFinite: false
    }
}
