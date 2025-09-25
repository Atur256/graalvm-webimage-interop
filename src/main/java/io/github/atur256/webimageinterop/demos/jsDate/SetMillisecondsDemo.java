package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetMillisecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setMilliseconds Demo ===");
        JSDate date = new JSDate();
        date.setMilliseconds(123);
        System.out.println("Updated milliseconds: " + date.getMilliseconds());
        // Expected: Updated milliseconds: 123
    }
}
