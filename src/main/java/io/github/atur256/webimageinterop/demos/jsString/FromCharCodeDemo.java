package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class FromCharCodeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.fromCharCode Demo ===");

        // Zero-argument call
        String empty = JSString.fromCharCode().as(String.class);
        System.out.println("fromCharCode(): \"" + empty + "\"");
        // Expected: fromCharCode(): ""

        // Single character
        String single = JSString.fromCharCode(65).as(String.class);
        System.out.println("fromCharCode(65): \"" + single + "\"");
        // Expected: fromCharCode(65): "A"

        // Multiple characters
        String multi = JSString.fromCharCode(72, 101, 108, 108, 111).as(String.class);
        System.out.println("fromCharCode(72,101,108,108,111): \"" + multi + "\"");
        // Expected: fromCharCode(72,101,108,108,111): "Hello"

        // Unicode symbols
        String symbols = JSString.fromCharCode(36, 169, 174).as(String.class);
        System.out.println("fromCharCode(36,169,174): \"" + symbols + "\"");
        // Expected: fromCharCode(36,169,174): "$©®"

        // Emoji (surrogate pair)
        String emoji = JSString.fromCharCode(0xD83D, 0xDE00).as(String.class);
        System.out.println("fromCharCode(0xD83D,0xDE00): \"" + emoji + "\"");
        // Expected: fromCharCode(0xD83D,0xDE00): "😀"

        // Assert values
        assertEquals("", empty);
        assertEquals("A", single);
        assertEquals("Hello", multi);
        assertEquals("$©®", symbols);
        assertEquals("😀", emoji);
    }
}