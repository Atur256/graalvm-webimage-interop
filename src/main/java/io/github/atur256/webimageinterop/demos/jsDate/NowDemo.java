package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class NowDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.now Demo ===");
        System.out.println("Current timestamp: " + JSDate.now());
        // Expected: Current timestamp: <milliseconds since epoch>
    }
}
