package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GetUTCDateDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCDate Demo ===");

        JSDate date = JSDate.create(2025, 10, 1);
        int dayOfMonth = date.getUTCDate();

        System.out.println("UTC day of month: " + dayOfMonth);
        // Expected: UTC day of month: 1

        // Assert values
        assertEquals(1, dayOfMonth);
    }
}