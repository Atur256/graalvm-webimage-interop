package demos.number;

import builtin.Number;


public class ParseFloatNumberDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Number.parseFloat (Number) Demo ===");

        System.out.println("parseFloat(3.4): " + Number.parseFloat(3.4));
        // Expected: 3.4

        System.out.println("parseFloat(3): " + Number.parseFloat(3));
        // Expected: 3.0
    }
}
