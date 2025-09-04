package demos.jsDate;

import builtin.JSDate;


public class GetHoursDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getHours Demo ===");
        JSDate date = new JSDate();
        System.out.println("Hour of day: " + date.getHours());
        // Expected: Hour of day: <0-24>
    }
}
