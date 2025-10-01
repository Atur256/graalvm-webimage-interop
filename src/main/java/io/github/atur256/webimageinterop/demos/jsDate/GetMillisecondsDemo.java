package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import static org.junit.Assert.assertTrue;


public class GetMillisecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getMilliseconds Demo ===");

        long before = System.currentTimeMillis()% 1000;
        JSDate date = new JSDate();
        long after = System.currentTimeMillis()% 1000;
        long milliseconds = date.getMilliseconds();

        System.out.println("Milliseconds: " + milliseconds);
        // Expected: Milliseconds: <0–999>

        // Assert values
        assertTrue(before <= milliseconds);
        assertTrue(after >= milliseconds);
    }
}