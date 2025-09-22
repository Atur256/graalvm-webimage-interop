package demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class IsNaNDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Number.isNaN Demo ===");

        // JSValue examples
        JSValue jsValid = JSNumber.of(42);
        JSValue jsNaN = JSNumber.of(Double.NaN);
        JSValue jsInfinity = JSNumber.of(Double.POSITIVE_INFINITY);

        System.out.println("JSValue 42 isNaN: " + JSNumber.isNaN(jsValid));
        System.out.println("JSValue NaN isNaN: " + JSNumber.isNaN(jsNaN));
        System.out.println("JSValue Infinity isNaN: " + JSNumber.isNaN(jsInfinity));
        // Expected:
        // JSValue 42 isNaN: false
        // JSValue NaN isNaN: true
        // JSValue Infinity isNaN: false

        // Java Number examples
        Number javaIntValid = 123;
        Number javaDoubleValid = 1.23;
        Number javaNaN = Double.NaN;
        Number javaInfinity = Double.NEGATIVE_INFINITY;

        System.out.println("Number 123 isNaN: " + JSNumber.isNaN(javaDoubleValid));
        System.out.println("Number 1.23 isNaN: " + JSNumber.isNaN(javaDoubleValid));
        System.out.println("Number NaN isNaN: " + JSNumber.isNaN(javaNaN));
        System.out.println("Number -Infinity isNaN: " + JSNumber.isNaN(javaInfinity));
        // Expected:
        // Number 123 isNaN: false
        // Number 1.23 isNaN: false
        // Number NaN isNaN: true
        // Number -Infinity isNaN: false
    }
}
