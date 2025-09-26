package io.github.atur256.webimageinterop.demos.jsUri;

import io.github.atur256.webimageinterop.builtin.JSUri;

import static org.junit.Assert.assertEquals;


public class EncodeURIComponentDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSUri.encodeURIComponent Demo ===");

        String result1 = JSUri.encodeURIComponent("John Doe & Co.");
        assertEquals("John%20Doe%20%26%20Co.", result1);
        System.out.println("encodeURIComponent(\"John Doe & Co.\"): " + result1);
        // Expected: encodeURIComponent("John Doe & Co."): John%20Doe%20%26%20Co.

        String result2 = JSUri.encodeURIComponent("a+b=c&d");
        assertEquals("a%2Bb%3Dc%26d", result2);
        System.out.println("encodeURIComponent(\"a+b=c&d\"): " + result2);
        // Expected: encodeURIComponent("a+b=c&d"): a%2Bb%3Dc%26d
    }
}
