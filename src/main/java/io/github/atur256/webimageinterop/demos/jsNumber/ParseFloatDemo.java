package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class ParseFloatDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.parseFloat Demo ===");

        // Number inputs
        double result1 = JSNumber.parseFloat(42);
        double result2 = JSNumber.parseFloat(3.1415);
        System.out.println("parseFloat(42): " + result1);
        System.out.println("parseFloat(3.1415): " + result2);
        // Expected:
        // parseFloat(42): 42.0
        // parseFloat(3.1415): 3.1415

        // String inputs
        double result3 = JSNumber.parseFloat("123.456");
        double result4 = JSNumber.parseFloat("3.14abc");
        double result5 = JSNumber.parseFloat("abc");
        System.out.println("parseFloat(\"123.456\"): " + result3);
        System.out.println("parseFloat(\"3.14abc\"): " + result4);
        System.out.println("parseFloat(\"abc\"): " + result5);
        // Expected:
        // parseFloat("123.456"): 123.456
        // parseFloat("3.14abc"): 3.14
        // parseFloat("abc"): NaN

        // Assert values
        assertEquals(42.0, result1, 0.0);
        assertEquals(3.1415, result2, 0.001);
        assertEquals(123.456, result3, 0.001);
        assertEquals(3.14, result4, 0.001);
        assertEquals(Double.NaN, result5, 0.0);
    }
}