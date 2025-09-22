package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class FromCodePointDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.fromCodePoint Demo ===");

        // Zero-argument call (should return empty string)
        JSString empty = JSString.fromCodePoint();
        System.out.println("fromCodePoint() → \"" + empty.as(String.class) + "\"");
        // Expected: fromCodePoint() → ""

        // Basic ASCII
        JSString single = JSString.fromCodePoint(65);
        System.out.println("fromCodePoint(65) → \"" + single.as(String.class) + "\"");
        // Expected: fromCodePoint(65) → "A"

        // Multiple characters
        JSString hello = JSString.fromCodePoint(72, 101, 108, 108, 111);
        System.out.println("fromCodePoint(72,101,108,108,111) → \"" + hello.as(String.class) + "\"");
        // Expected: fromCodePoint(72,101,108,108,111) → "Hello"

        // Unicode symbols
        JSString symbols = JSString.fromCodePoint(36, 169, 174);
        System.out.println("fromCodePoint(36,169,174) → \"" + symbols.as(String.class) + "\"");
        // Expected: fromCodePoint(36,169,174) → "$©®"

        // Emoji (code point)
        JSString emoji = JSString.fromCodePoint(0x1F600);
        System.out.println("fromCodePoint(0x1F600) → \"" + emoji.as(String.class) + "\"");
        // Expected: fromCodePoint(0x1F600) → "😀"

        // Mixed: Greek letter + emoji
        JSString mixed = JSString.fromCodePoint(0x03A9, 0x1F680);
        System.out.println("fromCodePoint(0x03A9,0x1F680) → \"" + mixed.as(String.class) + "\"");
        // Expected: fromCodePoint(0x03A9,0x1F680) → "Ω🚀"
    }
}
