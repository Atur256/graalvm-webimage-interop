package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class GetDateDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getDate Demo ===");

        JSDate date = new JSDate();
        int day = date.getDate();
        System.out.println("Day of the month: " + day);
        // Expected: Day of the month: <1-31>

        // Assert values
        assertEquals(LocalDate.now().getDayOfMonth(), day);
    }
}