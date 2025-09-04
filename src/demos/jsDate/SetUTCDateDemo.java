package demos.jsDate;

import builtin.JSDate;


public class SetUTCDateDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setUTCDate Demo ===");
        JSDate date = new JSDate();
        date.setUTCDate(20);
        System.out.println("Updated UTC day of month: " + date.getUTCDate());
        // Expected: Updated UTC day of month: 20
    }
}
