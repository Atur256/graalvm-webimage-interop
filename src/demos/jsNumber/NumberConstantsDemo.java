package demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class NumberConstantsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber Constants Demo ===");

        print("EPSILON", JSNumber.EPSILON());
        print("MAX_SAFE_INTEGER", JSNumber.MAX_SAFE_INTEGER());
        print("MAX_VALUE", JSNumber.MAX_VALUE());
        print("MIN_SAFE_INTEGER", JSNumber.MIN_SAFE_INTEGER());
        print("MIN_VALUE", JSNumber.MIN_VALUE());
        print("NaN", JSNumber.NaN());
        print("NEGATIVE_INFINITY", JSNumber.NEGATIVE_INFINITY());
        print("POSITIVE_INFINITY", JSNumber.POSITIVE_INFINITY());
        // Expected:
        // EPSILON: double: 2.220446e-16 | int: 0
        // MAX_SAFE_INTEGER: double: 9.007199e+15 | int: 2147483647
        // MAX_VALUE: double: 1.797693e+308 | int: 2147483647
        // MIN_SAFE_INTEGER: double: -9.007199e+15 | int: -2147483648
        // MIN_VALUE: double: 4.900000e-324 | int: 0
        // NaN: double: NaN | int: 0
        // NEGATIVE_INFINITY: double: -Infinity | int: -2147483648
        // POSITIVE_INFINITY: double: Infinity | int: 2147483647
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
