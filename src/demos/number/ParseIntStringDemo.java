package demos.number;

import builtin.Number;


public class ParseIntStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Number.parseInt (String) Demo ===");

        System.out.println("parseInt(\"3\"): " + Number.parseInt("3"));
        // Expected: 3

        System.out.println("parseInt(\"Hello\"): " + Number.parseInt("Hello"));
        // Expected: NaN

        System.out.println("parseInt(\"123abc\"): " + Number.parseInt("123abc"));
        // Expected: 123 (parses until non-numeric chars)
    }
}
