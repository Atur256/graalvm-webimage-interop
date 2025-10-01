package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;


public class GetUTCDayDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCDay Demo ===");


        int before = LocalDate.now().getDayOfWeek().getValue();
        JSDate date = new JSDate();
        int after = LocalDate.now().getDayOfWeek().getValue();
        int dayOfWeek = date.getUTCDay();

        System.out.println("UTC day of week (0=Sun): " + dayOfWeek);
        // Expected: UTC day of week (0=Sun): <1-7>

        // Assert values
        assertTrue(before <= dayOfWeek);
        assertTrue(after >= dayOfWeek);
    }
}