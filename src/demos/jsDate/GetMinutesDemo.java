package demos.jsDate;

import builtin.JSDate;


public class GetMinutesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getMinutes Demo ===");
        JSDate date = new JSDate();
        System.out.println("Minutes: " + date.getMinutes());
        // Expected: Minutes: <0-60>
    }
}
