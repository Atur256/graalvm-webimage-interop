package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetUTCSecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCSeconds Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC seconds: " + date.getUTCSeconds());
        // Expected: UTC seconds: <current seconds>
    }
}
