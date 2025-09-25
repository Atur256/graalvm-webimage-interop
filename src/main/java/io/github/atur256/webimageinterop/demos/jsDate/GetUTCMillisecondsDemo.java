package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetUTCMillisecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCMilliseconds Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC milliseconds: " + date.getUTCMilliseconds());
        // Expected: UTC milliseconds: <0–999>
    }
}
