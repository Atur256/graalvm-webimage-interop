package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class ToLocaleStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toLocaleString Demo ===");
        JSDate date = new JSDate();
        System.out.println("Locale string: " + date.toLocaleString());
        // Expected: Example: Locale string: 04.09.2025, 13:58:00
    }
}
