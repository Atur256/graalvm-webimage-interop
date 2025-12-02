/*
 * Copyright (c) 2025 Arthur Schwaiger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.atur256.graalvmwebimageinterop.tests;

import io.github.atur256.graalvmwebimageinterop.builtin.JSUri;

import static org.junit.jupiter.api.Assertions.*;


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
