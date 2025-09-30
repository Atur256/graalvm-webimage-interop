package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;


public class GetHoursDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getHours Demo ===");

        JSDate date = new JSDate();
        int hour = date.getHours();
        System.out.println("Hour of day: " + hour);
        // Expected: Hour of day: <0-24>

        // Assert values
        assertEquals(LocalTime.now().getHour(), hour);
    }
}