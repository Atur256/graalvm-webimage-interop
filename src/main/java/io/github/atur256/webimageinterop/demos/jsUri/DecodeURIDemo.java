package io.github.atur256.webimageinterop.demos.jsUri;

import io.github.atur256.webimageinterop.builtin.JSUri;

import static org.junit.Assert.assertEquals;


public class DecodeURIDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSUri.decodeURI Demo ===");

        String result1 = JSUri.decodeURI("https://example.com?name=John%20Doe&age=30");
        assertEquals("https://example.com?name=John Doe&age=30", result1);
        System.out.println("decodeURI(\"https://example.com?name=John%20Doe&age=30\"): " + result1);
        // Expected: decodeURI("https://example.com?name=John%20Doe&age=30"): https://example.com?name=John Doe&age=30

        String result2 = JSUri.decodeURI("Hello%20World!");
        assertEquals("Hello World!", result2);
        System.out.println("decodeURI(\"Hello%20World!\"): " + result2);
        // Expected: decodeURI("Hello%20World!"): Hello World!
    }
}
