package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetUTCMinutesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setUTCMinutes Demo ===");
        JSDate date = new JSDate();
        date.setUTCMinutes(45);
        System.out.println("Updated UTC minutes: " + date.getUTCMinutes());
        // Expected: Updated UTC minutes: 45
    }
}
