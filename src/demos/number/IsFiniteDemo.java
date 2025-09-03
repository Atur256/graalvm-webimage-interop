package demos.number;

import builtin.Number;

public class IsFiniteDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Number.isFinite Demo ===");

        System.out.println("isFinite(1000 / 0.0): " + Number.isFinite(1000 / 0.0));
        // Expected: false (1000 / 0.0 = Infinity)

        System.out.println("isFinite(1.0 / 3.0): " + Number.isFinite(1.0 / 3.0));
        // Expected: true (0.333... is finite)

        System.out.println("isFinite(Double.NaN): " + Number.isFinite(Double.NaN));
        // Expected: false (NaN is not finite)

        System.out.println("isFinite(Double.POSITIVE_INFINITY): " + Number.isFinite(Double.POSITIVE_INFINITY));
        // Expected: false (Infinity is not finite)
    }
}
