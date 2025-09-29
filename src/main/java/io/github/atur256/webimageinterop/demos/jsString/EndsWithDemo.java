package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.*;


public class EndsWithDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.endsWith Demo ===");

        // ASCII: "Hello World"
        JSString phrase = JSString.of("Hello World");
        boolean result1 = phrase.endsWith("World");
        boolean result2 = phrase.endsWith("world");
        boolean result3 = phrase.endsWith("Hello");
        boolean result4 = phrase.endsWith("Hello", 5);
        System.out.println("\"Hello World\".endsWith(\"World\"): " + result1);
        System.out.println("\"Hello World\".endsWith(\"world\"): " + result2);
        System.out.println("\"Hello World\".endsWith(\"Hello\"): " + result3);
        System.out.println("\"Hello World\".endsWith(\"Hello\", 5): " + result4);
        // Expected:
        // "Hello World".endsWith("World"): true
        // "Hello World".endsWith("world"): false
        // "Hello World".endsWith("Hello"): false
        // "Hello World".endsWith("Hello", 5): true

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193); // Use JSString.fromCodePoint to correctly create Unicode strings
        boolean result5 = arrows.endsWith(JSString.fromCodePoint(0x2192, 0x2193));
        boolean result6 = arrows.endsWith(JSString.fromCodePoint(0x2191), 2);
        System.out.println("\"←↑→↓\".endsWith(\"→↓\"): " + result5);
        System.out.println("\"←↑→↓\".endsWith(\"↑\", 2): " + result6);
        // Expected:
        // "←↑→↓".endsWith("→↓"): true
        // "←↑→↓".endsWith("↑", 2): true

        // Unicode math: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        boolean result7 = math.endsWith(JSString.fromCodePoint(0x03C0, 0x221E));
        boolean result8 = math.endsWith(JSString.fromCodePoint(0x221A), 2);
        boolean result9 = math.endsWith(JSString.fromCodePoint(0x221E), 3);
        System.out.println("\"∑√π∞\".endsWith(\"π∞\"): " + result7);
        System.out.println("\"∑√π∞\".endsWith(\"√\", 2): " + result8);
        System.out.println("\"∑√π∞\".endsWith(\"∞\", 3): " + result9);
        // Expected:
        // "∑√π∞".endsWith("π∞"): true
        // "∑√π∞".endsWith("√", 2): true
        // "∑√π∞".endsWith("∞", 3): false

        // Assert values
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertTrue(result4);
        assertTrue(result5);
        assertTrue(result6);
        assertTrue(result7);
        assertTrue(result8);
        assertFalse(result9);
    }
}