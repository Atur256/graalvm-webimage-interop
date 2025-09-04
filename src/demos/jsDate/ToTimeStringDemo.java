package demos.jsDate;

import builtin.JSDate;


public class ToTimeStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toTimeString Demo ===");
        JSDate date = new JSDate();
        System.out.println("Time string: " + date.toTimeString());
        // Expected: Example: Time string: 14:08:00 GMT+0200 (Central European Summer Time)
    }
}
