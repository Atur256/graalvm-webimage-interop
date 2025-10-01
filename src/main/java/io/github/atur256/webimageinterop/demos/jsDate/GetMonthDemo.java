package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;


public class GetMonthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getMonth Demo ===");

        int before = LocalDate.now().getMonthValue();
        JSDate date = new JSDate();
        int after = LocalDate.now().getMonthValue();
        int month = date.getMonth();

        System.out.println("Month (0=Jan): " + month);
        // Expected: Month (0=Jan): <1-12>

        // Assert values
        month++; // Correct indexing as js code return (0 - 11) and java code return (1 -12)
        assertTrue(before <= month);
        assertTrue(after >= month);
    }
}