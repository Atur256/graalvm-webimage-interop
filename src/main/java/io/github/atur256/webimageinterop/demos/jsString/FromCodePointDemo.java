package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class FromCodePointDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.fromCodePoint Demo ===");

        // Zero-argument call (should return empty string)
        String empty = JSString.fromCodePoint().as(String.class);
        System.out.println("fromCodePoint() → \"" + empty + "\"");
        // Expected: fromCodePoint() → ""

        // Basic ASCII
        String single = JSString.fromCodePoint(65).as(String.class);
        System.out.println("fromCodePoint(65) → \"" + single + "\"");
        // Expected: fromCodePoint(65) → "A"

        // Multiple characters
        String multi = JSString.fromCodePoint(72, 101, 108, 108, 111).as(String.class);
        System.out.println("fromCodePoint(72,101,108,108,111) → \"" + multi + "\"");
        // Expected: fromCodePoint(72,101,108,108,111) → "Hello"

        // Unicode symbols
        String symbols = JSString.fromCodePoint(36, 169, 174).as(String.class);
        System.out.println("fromCodePoint(36,169,174) → \"" + symbols + "\"");
        // Expected: fromCodePoint(36,169,174) → "$©®"

        // Emoji (code point)
        String emoji = JSString.fromCodePoint(0x1F600).as(String.class);
        System.out.println("fromCodePoint(0x1F600) → \"" + emoji + "\"");
        // Expected: fromCodePoint(0x1F600) → "😀"

        // Mixed: Greek letter + emoji
        String mixed = JSString.fromCodePoint(0x03A9, 0x1F680).as(String.class);
        System.out.println("fromCodePoint(0x03A9,0x1F680) → \"" + mixed + "\"");
        // Expected: fromCodePoint(0x03A9,0x1F680) → "Ω🚀"

        // Assert values
        assertEquals("", empty);
        assertEquals("A", single);
        assertEquals("Hello", multi);
        assertEquals("$©®", symbols);
        assertEquals("😀", emoji);
        assertEquals("Ω🚀", mixed);
    }
}