package io.github.atur256.webimageinterop.demos.jsUri;

import io.github.atur256.webimageinterop.builtin.JSUri;


public class DecodeURIComponentDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSURI.decodeURIComponent Demo ===");

        System.out.println("decodeURIComponent(\"John%20Doe%20%26%20Co.\"): " +
                JSUri.decodeURIComponent("John%20Doe%20%26%20Co."));
        // Expected: decodeURIComponent("John%20Doe%20%26%20Co."): John Doe & Co.

        System.out.println("decodeURIComponent(\"a%2Bb%3Dc%26d\"): " +
                JSUri.decodeURIComponent("a%2Bb%3Dc%26d"));
        // Expected: decodeURIComponent("a%2Bb%3Dc%26d"): a+b=c&d
    }
}
