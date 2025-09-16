package demos.jsDate;

import builtin.JSDate;


public class GetUTCDayDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCDay Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC day of week (0=Sun): " + date.getUTCDay());
        // Expected: UTC day of week (0=Sun): <1-7>
    }
}
