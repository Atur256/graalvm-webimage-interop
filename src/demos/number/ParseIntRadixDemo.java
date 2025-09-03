package demos.number;

import builtin.Number;


public class ParseIntRadixDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Number.parseInt with Radix Demo ===");

        System.out.println("parseInt(\"0xF4\", 16): " + Number.parseInt("0xF4", 16));
        // Expected: 244

        System.out.println("parseInt(\"1010\", 2): " + Number.parseInt("1010", 2));
        // Expected: 10

        System.out.println("parseInt(\"77\", 8): " + Number.parseInt("77", 8));
        // Expected: 63
    }
}
