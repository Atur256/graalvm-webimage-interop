package io.github.atur256.webimageinterop.demos.jsUri;

import io.github.atur256.webimageinterop.builtin.JSUri;


public class EncodeURIDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSURI.encodeURI Demo ===");

        System.out.println("encodeURI(\"https://example.com?name=John Doe&age=30\"): " +
                JSUri.encodeURI("https://example.com?name=John Doe&age=30"));
        // Expected: encodeURI("https://example.com?name=John Doe&age=30"): https://example.com?name=John%20Doe&age=30

        System.out.println("encodeURI(\"Hello World!\"): " +
                JSUri.encodeURI("Hello World!"));
        // Expected: encodeURI("Hello World!"): Hello%20World!
    }
}
