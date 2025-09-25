package io.github.atur256.webimageinterop.demos.jsUri;

import io.github.atur256.webimageinterop.builtin.JSUri;


public class EncodeURIComponentDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSURI.encodeURIComponent Demo ===");

        System.out.println("encodeURIComponent(\"John Doe & Co.\"): " +
                JSUri.encodeURIComponent("John Doe & Co."));
        // Expected: encodeURIComponent("John Doe & Co."): John%20Doe%20%26%20Co.

        System.out.println("encodeURIComponent(\"a+b=c&d\"): " +
                JSUri.encodeURIComponent("a+b=c&d"));
        // Expected: encodeURIComponent("a+b=c&d"): a%2Bb%3Dc%26d
    }
}
