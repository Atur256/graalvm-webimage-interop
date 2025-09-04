package demos.jsDate;

import builtin.JSDate;


public class GetDateDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getDate Demo ===");
        JSDate date = new JSDate();
        System.out.println("Day of the month: " + date.getDate());
        // Expected: Day of the month: <1-31>
    }
}
