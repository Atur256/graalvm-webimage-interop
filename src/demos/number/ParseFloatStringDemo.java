package demos.number;

import builtin.Number;


public class ParseFloatStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Number.parseFloat (String) Demo ===");

        System.out.println("parseFloat(\"3.4\"): " + Number.parseFloat("3.4"));
        // Expected: 3.4

        System.out.println("parseFloat(\"a\"): " + Number.parseFloat("a"));
        // Expected: NaN

        System.out.println("parseFloat(\"123abc\"): " + Number.parseFloat("123abc"));
        // Expected: 123.0 (parses up to non-numeric chars)
    }
}
