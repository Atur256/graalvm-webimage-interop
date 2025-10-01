package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalTime;

import static org.junit.Assert.assertTrue;


public class GetSecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getSeconds Demo ===");

        int before = LocalTime.now().getSecond();
        JSDate date = new JSDate();
        int after = LocalTime.now().getSecond();
        int seconds = date.getSeconds();

        System.out.println("Seconds: " + seconds);
        // Expected: Seconds: <current seconds>

        // Assert values
        assertTrue(before <= seconds);
        assertTrue(after >= seconds);
    }
}