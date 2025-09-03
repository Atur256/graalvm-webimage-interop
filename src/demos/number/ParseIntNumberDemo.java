package demos.number;

import builtin.Number;


public class ParseIntNumberDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Number.parseInt (Number) Demo ===");

        System.out.println("parseInt(3.4): " + Number.parseInt(3.4));
        // Expected: 3 (decimal truncated)

        System.out.println("parseInt(3): " + Number.parseInt(3));
        // Expected: 3
    }
}
