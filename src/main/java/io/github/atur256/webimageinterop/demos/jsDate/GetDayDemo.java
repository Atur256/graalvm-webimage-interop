package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class GetDayDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getDay Demo ===");

        JSDate date = new JSDate();
        int day = date.getDay();
        System.out.println("Day of the week (0=Sun): " + day);
        // Expected: Day of the week: <1-7>

        // Assert values
        assertEquals(LocalDate.now().getDayOfWeek().getValue(), day);
    }
}