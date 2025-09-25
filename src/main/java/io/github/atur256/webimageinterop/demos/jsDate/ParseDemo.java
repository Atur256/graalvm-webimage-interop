package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class ParseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.parse Demo ===");
        double timestamp = JSDate.parse("2025-09-04T13:00:00Z");
        System.out.println("Parsed timestamp: " + timestamp);
        // Expected: Parsed timestamp: <milliseconds since epoch>
    }
}
