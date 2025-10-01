package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalTime;

import static org.junit.Assert.assertTrue;


public class GetHoursDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getHours Demo ===");

        int before = LocalTime.now().getHour();
        JSDate date = new JSDate();
        int after = LocalTime.now().getHour();
        int hour = date.getHours();

        System.out.println("Hour of day: " + hour);
        // Expected: Hour of day: <0-23>

        // Assert values
        assertTrue(before <= hour);
        assertTrue(after >= hour);
    }
}