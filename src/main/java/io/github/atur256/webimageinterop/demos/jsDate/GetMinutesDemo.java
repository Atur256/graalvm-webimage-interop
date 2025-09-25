package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetMinutesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getMinutes Demo ===");
        JSDate date = new JSDate();
        System.out.println("Minutes: " + date.getMinutes());
        // Expected: Minutes: <0-60>
    }
}
