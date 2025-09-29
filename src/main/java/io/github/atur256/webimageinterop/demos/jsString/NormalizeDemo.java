package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class NormalizeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.normalize Demo ===");

        // é as composed (U+00E9)
        JSString composed = JSString.fromCodePoint(0x00E9);
        // é as decomposed (U+0065 + U+0301)
        JSString decomposed = JSString.fromCodePoint(0x0065, 0x0301);

        String result1 = composed.as(String.class);
        String result2 = decomposed.as(String.class);
        System.out.println("Original composed: " + result1);
        System.out.println("Original decomposed: " + result2);
        // Expected:
        // Original composed: é
        // Original decomposed: é

        // normalize() defaults to NFC
        String result3 = decomposed.normalize().as(String.class);
        System.out.println("decomposed.normalize(): " + result3);
        // Expected:
        // decomposed.normalize(): é

        // normalize(form)
        String result4 = decomposed.normalize("NFD").as(String.class);
        String result5 = composed.normalize("NFD").as(String.class);
        String result6 = composed.normalize("NFC").as(String.class);
        String result7 = decomposed.normalize("NFC").as(String.class);
        System.out.println("decomposed.normalize(\"NFD\"): " + result4);
        System.out.println("composed.normalize(\"NFD\"): " + result5);
        System.out.println("composed.normalize(\"NFC\"): " + result6);
        System.out.println("decomposed.normalize(\"NFC\"): " + result7);
        // Expected:
        // decomposed.normalize("NFD"): é
        // composed.normalize("NFD"): é
        // composed.normalize("NFC"): é
        // decomposed.normalize("NFC"): é

        // Compatibility normalization
        JSString fullWidth = JSString.fromCodePoint(0xFF21);
        String result8 = fullWidth.as(String.class);
        String result9 = fullWidth.normalize("NFKC").as(String.class);
        System.out.println("Full-width A: " + result8);
        System.out.println("fullWidth.normalize(\"NFKC\"): " + result9);
        // Expected:
        // Full-width A: Ａ
        // fullWidth.normalize("NFKC"): A

        // Assert values
        assertEquals("é", result1);
        assertEquals("é", result2);
        assertEquals("é", result3);
        assertEquals("é", result4);
        assertEquals("é", result5);
        assertEquals("é", result6);
        assertEquals("é", result7);
        assertEquals("Ａ", result8);
        assertEquals("A", result9);
    }
}