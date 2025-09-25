package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class ToUTCStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toUTCString Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC string: " + date.toUTCString());
        // Expected: Example: UTC string: Thu, 04 Sep 2025 12:08:00 GMT
    }
}
