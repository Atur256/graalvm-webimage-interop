package demos.jsDate;

import builtin.JSDate;


public class ToISOStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toISOString Demo ===");
        JSDate date = new JSDate();
        System.out.println("ISO string: " + date.toISOString());
        // Expected: Example: ISO string: 2025-09-04T11:58:00.000Z
    }
}
