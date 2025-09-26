package io.github.atur256.webimageinterop.demos.jsUri;

import io.github.atur256.webimageinterop.builtin.JSUri;

import static org.junit.Assert.assertEquals;


public class DecodeURIComponentDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSUri.decodeURIComponent Demo ===");

        String result1 = JSUri.decodeURIComponent("John%20Doe%20%26%20Co.");
        assertEquals("John Doe & Co.", result1);
        System.out.println("decodeURIComponent(\"John%20Doe%20%26%20Co.\"): " + result1);
        // Expected: decodeURIComponent("John%20Doe%20%26%20Co."): John Doe & Co.

        String result2 = JSUri.decodeURIComponent("a%2Bb%3Dc%26d");
        assertEquals("a+b=c&d", result2);
        System.out.println("decodeURIComponent(\"a%2Bb%3Dc%26d\"): " + result2);
        // Expected: decodeURIComponent("a%2Bb%3Dc%26d"): a+b=c&d
    }
}
