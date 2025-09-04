package demos.jsDate;

import builtin.JSDate;


public class SetMinutesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setMinutes Demo ===");
        JSDate date = new JSDate();
        date.setMinutes(45);
        System.out.println("Updated minutes: " + date.getMinutes());
        // Expected: Updated minutes: 45
    }
}
