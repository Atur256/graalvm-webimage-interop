package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class NormalizeDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.normalize Demo ===");

        // é as composed (U+00E9)
        JSString composed = JSString.fromCodePoint(0x00E9);
        // é as decomposed (U+0065 + U+0301)
        JSString decomposed = JSString.fromCodePoint(0x0065, 0x0301);

        System.out.println("Original composed: " + composed.as(String.class));
        System.out.println("Original decomposed: " + decomposed.as(String.class));
        // Expected:
        // Original composed: é
        // Original decomposed: é

        // normalize() defaults to NFC
        System.out.println("decomposed.normalize(): " + decomposed.normalize().as(String.class));
        // Expected:
        // decomposed.normalize(): é

        // normalize(form)
        System.out.println("decomposed.normalize(\"NFD\"): " + decomposed.normalize("NFD").as(String.class));
        System.out.println("composed.normalize(\"NFD\"): " + composed.normalize("NFD").as(String.class));
        System.out.println("composed.normalize(\"NFC\"): " + composed.normalize("NFC").as(String.class));
        System.out.println("decomposed.normalize(\"NFC\"): " + decomposed.normalize("NFC").as(String.class));
        // Expected:
        // decomposed.normalize("NFD"): é
        // composed.normalize("NFD"): é
        // composed.normalize("NFC"): é
        // decomposed.normalize("NFC"): é

        // Compatibility normalization
        JSString fullWidth = JSString.fromCodePoint(0xFF21);
        System.out.println("Full-width A: " + fullWidth.as(String.class));
        System.out.println("fullWidth.normalize(\"NFKC\"): " + fullWidth.normalize("NFKC").as(String.class));
        // Expected:
        // Full-width A: Ａ
        // fullWidth.normalize("NFKC"): A
    }
}
