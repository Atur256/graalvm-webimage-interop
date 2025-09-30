package io.github.atur256.webimageinterop.demos.jsUri;

import io.github.atur256.webimageinterop.builtin.JSUri;

import static org.junit.Assert.assertEquals;


public class EncodeURIDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSUri.encodeURI Demo ===");

        String result1 = JSUri.encodeURI("https://example.com?name=John Doe&age=30");
        System.out.println("encodeURI(\"https://example.com?name=John Doe&age=30\"): " + result1);
        // Expected: encodeURI("https://example.com?name=John Doe&age=30"): https://example.com?name=John%20Doe&age=30

        String result2 = JSUri.encodeURI("Hello World!");
        System.out.println("encodeURI(\"Hello World!\"): " + result2);
        // Expected: encodeURI("Hello World!"): Hello%20World!

        // Assert values
        assertEquals("https://example.com?name=John%20Doe&age=30", result1);
        assertEquals("Hello%20World!", result2);
    }
}