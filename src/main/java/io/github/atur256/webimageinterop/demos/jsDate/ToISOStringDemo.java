package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class ToISOStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toISOString Demo ===");
        JSDate date = new JSDate();
        System.out.println("ISO string: " + date.toISOString());
        // Expected: Example: ISO string: 2025-09-04T11:58:00.000Z
    }
}
