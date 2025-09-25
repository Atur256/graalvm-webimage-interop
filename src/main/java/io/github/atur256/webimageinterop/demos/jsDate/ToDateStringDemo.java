package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class ToDateStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toDateString Demo ===");
        JSDate date = new JSDate();
        System.out.println("Date string: " + date.toDateString());
        // Expected: Example: Date string: Thu Sep 04 2025
    }
}
