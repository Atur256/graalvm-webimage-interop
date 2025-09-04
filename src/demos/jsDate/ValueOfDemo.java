package demos.jsDate;

import builtin.JSDate;


public class ValueOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.valueOf Demo ===");
        JSDate date = new JSDate();
        System.out.println("Primitive timestamp: " + date.valueOf());
        // Expected: Example: Primitive timestamp: 1756997280000
        // (Represents 2025-09-04T12:08:00.000Z in milliseconds since epoch)
    }
}
