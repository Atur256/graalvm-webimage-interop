package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetTimeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getTime Demo ===");
        JSDate date = new JSDate();
        System.out.println("Milliseconds since epoch: " + date.getTime());
        // Expected: Milliseconds since epoch: <timestamp>
    }
}
