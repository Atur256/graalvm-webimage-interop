package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class ToTimeStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toTimeString Demo ===");
        JSDate date = new JSDate();
        System.out.println("Time string: " + date.toTimeString());
        // Expected: Example: Time string: 14:08:00 GMT+0200 (Central European Summer Time)
    }
}
