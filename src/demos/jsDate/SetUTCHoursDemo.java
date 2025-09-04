package demos.jsDate;

import builtin.JSDate;


public class SetUTCHoursDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setUTCHours Demo ===");
        JSDate date = new JSDate();
        date.setUTCHours(10);
        System.out.println("Updated UTC hour: " + date.getUTCHours());
        // Expected: Updated UTC hour: 10
    }
}
