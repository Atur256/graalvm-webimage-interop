package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetUTCMonthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setUTCMonth Demo ===");
        JSDate date = new JSDate();
        date.setUTCMonth(0);
        System.out.println("Updated UTC month: " + date.getUTCMonth());
        // Expected: Updated UTC month: 0
    }
}
