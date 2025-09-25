package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetMonthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setMonth Demo ===");
        JSDate date = new JSDate();
        date.setMonth(0);
        System.out.println("Updated month: " + date.getMonth());
        // Expected: Updated month: 0
    }
}
