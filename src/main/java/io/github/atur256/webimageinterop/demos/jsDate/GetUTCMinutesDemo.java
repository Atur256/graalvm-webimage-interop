package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetUTCMinutesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCMinutes Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC minutes: " + date.getUTCMinutes());
        // Expected: UTC minutes: <0-60>
    }
}
