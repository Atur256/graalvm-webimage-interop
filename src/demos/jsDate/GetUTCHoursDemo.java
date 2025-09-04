package demos.jsDate;

import builtin.JSDate;


public class GetUTCHoursDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCHours Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC hour: " + date.getUTCHours());
        // Expected: UTC hour: <0-24>
    }
}
