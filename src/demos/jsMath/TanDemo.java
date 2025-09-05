package demos.jsMath;

import builtin.JSMath;


public class TanDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMath.tan Demo ===");

        System.out.println("Math.tan(Math.PI / 4) = " + JSMath.tan(JSMath.PI() / 4));
        // Expected Output: Math.tan(π/4) ≈ 1.0
    }
}
