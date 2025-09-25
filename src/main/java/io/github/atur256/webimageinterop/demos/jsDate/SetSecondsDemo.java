package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetSecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setSeconds Demo ===");
        JSDate date = new JSDate();
        date.setSeconds(10);
        System.out.println("Updated seconds: " + date.getSeconds());
        // Expected: Updated seconds: 10
    }
}
