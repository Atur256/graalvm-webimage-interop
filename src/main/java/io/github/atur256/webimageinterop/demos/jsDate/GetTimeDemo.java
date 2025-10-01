package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import static org.junit.Assert.assertTrue;


public class GetTimeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getTime Demo ===");

        long before = System.currentTimeMillis();
        JSDate date = new JSDate();
        long after = System.currentTimeMillis();
        long time = date.getTime();

        System.out.println("Milliseconds since epoch: " + time);
        // Expected: Milliseconds since epoch: <timestamp>

        // Assert values
        assertTrue(before <= time);
        assertTrue(after >= time);
    }
}