package demos.jsDate;

import builtin.JSDate;


public class ToLocaleTimeStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toLocaleTimeString Demo ===");
        JSDate date = new JSDate();
        System.out.println("Locale time: " + date.toLocaleTimeString());
        // Expected: Example: Locale time: 13:58:00
    }

}
