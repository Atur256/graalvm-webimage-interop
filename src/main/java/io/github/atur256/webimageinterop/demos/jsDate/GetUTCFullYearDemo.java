package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetUTCFullYearDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCFullYear Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC full year: " + date.getUTCFullYear());
        // Expected: UTC full year: 2025
    }
}
