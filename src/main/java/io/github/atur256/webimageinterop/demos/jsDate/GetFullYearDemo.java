package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.Year;

import static org.junit.Assert.assertEquals;


public class GetFullYearDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getFullYear Demo ===");

        JSDate date = new JSDate();
        int year = date.getFullYear();

        System.out.println("Full year: " +year);
        // Expected: Full year: 2025

        // Assert values
        assertEquals(Year.now().getValue(), year);
    }
}
