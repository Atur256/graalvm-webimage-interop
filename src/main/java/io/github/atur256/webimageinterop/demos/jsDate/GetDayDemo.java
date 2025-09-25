package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetDayDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getDay Demo ===");
        JSDate date = new JSDate();
        System.out.println("Day of the week (0=Sun): " + date.getDay());
        // Expected: Day of the week: <1-7>
    }
}
