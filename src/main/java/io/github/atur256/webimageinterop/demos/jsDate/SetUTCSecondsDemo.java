package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetUTCSecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setUTCSeconds Demo ===");
        JSDate date = new JSDate();
        date.setUTCSeconds(30);
        System.out.println("Updated UTC seconds: " + date.getUTCSeconds());
        // Expected: Updated UTC seconds: 30
    }
}
