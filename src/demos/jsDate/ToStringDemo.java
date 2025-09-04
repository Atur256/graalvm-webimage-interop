package demos.jsDate;

import builtin.JSDate;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toString Demo ===");
        JSDate date = new JSDate();
        System.out.println("Default string: " + date.toString());
        // Expected: Example: Default string: Thu Sep 04 2025 13:58:00 GMT+0200 (CEST)
    }
}
