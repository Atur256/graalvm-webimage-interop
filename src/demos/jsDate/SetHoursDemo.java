package demos.jsDate;

import builtin.JSDate;


public class SetHoursDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setHours Demo ===");
        JSDate date = new JSDate();
        date.setHours(9);
        System.out.println("Updated hour: " + date.getHours());
        // Expected: Updated hour: 9
    }
}
