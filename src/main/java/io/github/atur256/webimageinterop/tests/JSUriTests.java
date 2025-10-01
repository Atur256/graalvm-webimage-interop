package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSUri;

import static org.junit.Assert.assertEquals;


public class JSUriTests {

    public static void main(String[] args) {

        String encodedUri1 = JSUri.encodeURI("https://example.com?name=John Doe&age=30");
        assertEquals("https://example.com?name=John%20Doe&age=30", encodedUri1);

        String encodedUri2 = JSUri.encodeURI("Hello World!");
        assertEquals("Hello%20World!", encodedUri2);

        String decodedUri1 = JSUri.decodeURI(encodedUri1);
        assertEquals("https://example.com?name=John Doe&age=30", decodedUri1);

        String decodedUri2 = JSUri.decodeURI(encodedUri2);
        assertEquals("Hello World!", decodedUri2);

        String encodedUriComponent1 = JSUri.encodeURIComponent("John Doe & Co.");
        assertEquals("John%20Doe%20%26%20Co.", encodedUriComponent1);

        String encodedUriComponent2 = JSUri.encodeURIComponent("a+b=c&d");
        assertEquals("a%2Bb%3Dc%26d", encodedUriComponent2);

        String decodedUriComponent1 = JSUri.decodeURIComponent(encodedUriComponent1);
        assertEquals("John Doe & Co.", decodedUriComponent1);

        String decodedUriComponent2 = JSUri.decodeURIComponent(encodedUriComponent2);
        assertEquals("a+b=c&d", decodedUriComponent2);
    }
}