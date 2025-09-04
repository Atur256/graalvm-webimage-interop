package demos.jsDate;

import builtin.JSDate;


public class GetFullYearDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getFullYear Demo ===");
        JSDate date = new JSDate();
        System.out.println("Full year: " + date.getFullYear());
        // Expected: Full year: 2025
    }
}
