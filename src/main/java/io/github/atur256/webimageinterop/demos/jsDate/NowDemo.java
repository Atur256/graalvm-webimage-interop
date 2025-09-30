package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import static org.junit.Assert.assertTrue;


public class NowDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.now Demo ===");

        long before = System.currentTimeMillis();
        long jsNow = JSDate.now();
        long after = System.currentTimeMillis();

        System.out.println("Current timestamp: " + jsNow);
        // Expected: Current timestamp: <milliseconds since epoch>

        // Assert values
        assertTrue(jsNow >= before);
        assertTrue(jsNow <= after);
    }
}