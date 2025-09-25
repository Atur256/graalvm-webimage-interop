package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetDateDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getDate Demo ===");
        JSDate date = new JSDate();
        System.out.println("Day of the month: " + date.getDate());
        // Expected: Day of the month: <1-31>
    }
}
