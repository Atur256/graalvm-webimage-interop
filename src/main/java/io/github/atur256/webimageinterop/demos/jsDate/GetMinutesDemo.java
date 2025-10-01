package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalTime;

import static org.junit.Assert.assertTrue;


public class GetMinutesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getMinutes Demo ===");

        int before = LocalTime.now().getMinute();
        JSDate date = new JSDate();
        int after = LocalTime.now().getMinute();
        int minute = date.getMinutes();

        System.out.println("Minutes: " + minute);
        // Expected: Minutes: <0-59>

        // Assert values
        assertTrue(before <= minute);
        assertTrue(after >= minute);
    }
}