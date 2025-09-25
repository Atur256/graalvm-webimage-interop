package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetUTCDateDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCDate Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC day of month: " + date.getUTCDate());
        // Expected: UTC day of month: <1-31>
    }
}
