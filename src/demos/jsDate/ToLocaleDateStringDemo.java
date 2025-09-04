package demos.jsDate;

import builtin.JSDate;


public class ToLocaleDateStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toLocaleDateString Demo ===");
        JSDate date = new JSDate();
        System.out.println("Locale date: " + date.toLocaleDateString());
        // Expected: Locale date: Example: 04.09.2025
    }
}
