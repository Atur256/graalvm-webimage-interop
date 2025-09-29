package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class NumberConstantsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber Constants Demo ===");

        double epsilon = JSNumber.EPSILON();
        double maxSafeInteger = JSNumber.MAX_SAFE_INTEGER();
        double maxValue = JSNumber.MAX_VALUE();
        double minSafeInteger = JSNumber.MIN_SAFE_INTEGER();
        double minValue = JSNumber.MIN_VALUE();
        double nan = JSNumber.NaN();
        double negativeInfinity = JSNumber.NEGATIVE_INFINITY();
        double positiveInfinity = JSNumber.POSITIVE_INFINITY();

        print("EPSILON", epsilon);
        print("MAX_SAFE_INTEGER", maxSafeInteger);
        print("MAX_VALUE", maxValue);
        print("MIN_SAFE_INTEGER", minSafeInteger);
        print("MIN_VALUE", minValue);
        print("NaN", nan);
        print("NEGATIVE_INFINITY", negativeInfinity);
        print("POSITIVE_INFINITY", positiveInfinity);
        // Expected:
        // EPSILON: double: 2.220446e-16 | int: 0
        // MAX_SAFE_INTEGER: double: 9.007199e+15 | int: 2147483647
        // MAX_VALUE: double: 1.797693e+308 | int: 2147483647
        // MIN_SAFE_INTEGER: double: -9.007199e+15 | int: -2147483648
        // MIN_VALUE: double: 4.900000e-324 | int: 0
        // NaN: double: NaN | int: 0
        // NEGATIVE_INFINITY: double: -Infinity | int: -2147483648
        // POSITIVE_INFINITY: double: Infinity | int: 2147483647

        // Assert values
        assertEquals(2.220446e-16, epsilon, 1e-16);
        assertEquals(9.007199e+15, maxSafeInteger, 0.000001e+15);
        assertEquals(1.797693e+308, maxValue, 0.000001e+308);
        assertEquals(-9.007199e+15, minSafeInteger, 0.000001e+15);
        assertEquals(4.900000e-324, minValue, 1e-16);
        assertEquals(Double.NaN, nan, 0.0);
        assertEquals(Double.NEGATIVE_INFINITY, negativeInfinity, 0.0);
        assertEquals(Double.POSITIVE_INFINITY, positiveInfinity, 0.0);
    }

    private static void print(String label, double value) {
        System.out.printf("%s: double: %e", label, value);
        try {
            int asInt = (int) value;
            System.out.printf(" | int: %d%n", asInt);
        } catch (Exception e) {
            System.out.printf(" | int: [error: %s]%n", e.getMessage());
        }
    }
}