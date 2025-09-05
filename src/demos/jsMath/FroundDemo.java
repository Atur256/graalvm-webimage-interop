package demos.jsMath;

import builtin.JSMath;


public class FroundDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMath.fround Demo ===");
        System.out.println("Math.fround(1.337) = " + JSMath.fround(1.337));
        // Expected Output: Rounded to nearest 32-bit float
    }
}
