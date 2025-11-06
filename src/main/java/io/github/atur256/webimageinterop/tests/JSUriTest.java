package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSUri;

import static org.junit.Assert.assertEquals;


public class JSUriTest {

    private static final String URI1 = "https://example.com?name=John Doe&age=30";
    private static final String URI1_ENCODED = "https://example.com?name=John%20Doe&age=30";
    private static final String URI2 = "Hello World!";
    private static final String URI2_ENCODED = "Hello%20World!";

    private static final String URI1_COMPONENT = "John Doe & Co.";
    private static final String URI1_COMPONENT_ENCODED = "John%20Doe%20%26%20Co.";
    private static final String URI2_COMPONENT = "a+b=c&d";
    private static final String URI2_COMPONENT_ENCODED = "a%2Bb%3Dc%26d";

    public static void main(String[] args) {
        testEndcodeAndDecodeUri();
        testEndcodeAndDecodeUriComponent();
    }

    public static void testEndcodeAndDecodeUri() {
        String encodedUri1 = JSUri.encodeURI(URI1);
        String encodedUri2 = JSUri.encodeURI(URI2);
        String decodedUri1 = JSUri.decodeURI(encodedUri1);
        String decodedUri2 = JSUri.decodeURI(encodedUri2);

        assertEquals(URI1_ENCODED, encodedUri1);
        assertEquals(URI2_ENCODED, encodedUri2);
        assertEquals(URI1, decodedUri1);
        assertEquals(URI2, decodedUri2);
    }

    public static void testEndcodeAndDecodeUriComponent() {
        String encodedUriComponent1 = JSUri.encodeURIComponent(URI1_COMPONENT);
        String encodedUriComponent2 = JSUri.encodeURIComponent(URI2_COMPONENT);
        String decodedUriComponent1 = JSUri.decodeURIComponent(encodedUriComponent1);
        String decodedUriComponent2 = JSUri.decodeURIComponent(encodedUriComponent2);

        assertEquals(URI1_COMPONENT_ENCODED, encodedUriComponent1);
        assertEquals(URI2_COMPONENT_ENCODED, encodedUriComponent2);
        assertEquals(URI1_COMPONENT, decodedUriComponent1);
        assertEquals(URI2_COMPONENT, decodedUriComponent2);
    }
}
