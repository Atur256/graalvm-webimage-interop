package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetTimeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setTime Demo ===");
        JSDate date = new JSDate();
        double newTime = JSDate.UTC(2025, 8, 4, 13, 51, 0);
        date.setTime(newTime);
        System.out.println("Updated ISO: " + date.toISOString());
        // Expected: Updated ISO: 2025-09-04T13:51:00.000Z
    }
}
