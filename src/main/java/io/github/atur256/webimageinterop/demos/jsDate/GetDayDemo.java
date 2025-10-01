package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;


public class GetDayDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getDay Demo ===");

        int before = LocalDate.now().getDayOfWeek().getValue();
        JSDate date = new JSDate();
        int after = LocalDate.now().getDayOfWeek().getValue();
        int day = date.getDay();

        System.out.println("Day of the week (0=Sun): " + day);
        // Expected: Day of the week: <0-6>

        // Assert values
        before = before == 7 ? 0 : before; // Correct Sunday as js code returns 0 and java code 7 for sundays
        after = after == 7 ? 0 : after; // Correct Sunday as js code returns 0 and java code 7 for sundays
        assertTrue(before <= day);
        assertTrue(after >= day);
    }
}