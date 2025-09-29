package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class LastIndexOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.lastIndexOf Demo ===");

        // ASCII: "Hello Hello"
        JSString phrase = JSString.of("Hello Hello");
        int result1 = phrase.lastIndexOf("Hello");
        int result2 = phrase.lastIndexOf("Hello", 5);
        int result3 = phrase.lastIndexOf("lo");
        System.out.println("\"Hello Hello\".lastIndexOf(\"Hello\"): " + result1);
        System.out.println("\"Hello Hello\".lastIndexOf(\"Hello\", 5): " + result2);
        System.out.println("\"Hello Hello\".lastIndexOf(\"lo\"): " + result3);
        // Expected:
        // "Hello Hello".lastIndexOf("Hello"): 6
        // "Hello Hello".lastIndexOf("Hello", 5): 0
        // "Hello Hello".lastIndexOf("lo"): 9

        // Unicode arrows: ←↑→↓←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193, 0x2190, 0x2191, 0x2192, 0x2193);
        int result4 = arrows.lastIndexOf(JSString.fromCodePoint(0x2192));
        int result5 = arrows.lastIndexOf(JSString.fromCodePoint(0x2192), 6);
        System.out.println("\"←↑→↓←↑→↓\".lastIndexOf(\"→\"): " + result4);
        System.out.println("\"←↑→↓←↑→↓\".lastIndexOf(\"→\", 6): " + result5);
        // Expected:
        // "←↑→↓←↑→↓".lastIndexOf("→"): 6
        // "←↑→↓←↑→↓".lastIndexOf("→", 6): 6

        // Assert values
        assertEquals(6, result1);
        assertEquals(0, result2);
        assertEquals(9, result3);
        assertEquals(6, result4);
        assertEquals(6, result5);
    }
}