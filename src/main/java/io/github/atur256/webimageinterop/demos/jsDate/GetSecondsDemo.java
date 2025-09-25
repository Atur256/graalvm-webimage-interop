package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetSecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getSeconds Demo ===");
        JSDate date = new JSDate();
        System.out.println("Seconds: " + date.getSeconds());
        // Expected: Seconds: <current seconds>
    }
}
