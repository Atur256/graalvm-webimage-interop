package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetUTCDateDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setUTCDate Demo ===");
        JSDate date = new JSDate();
        date.setUTCDate(20);
        System.out.println("Updated UTC day of month: " + date.getUTCDate());
        // Expected: Updated UTC day of month: 20
    }
}
