package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IncludesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.includes Demo ===");

        // ASCII: "Hello World"
        JSString phrase = JSString.of("Hello World");
        boolean result1 = phrase.includes("World");
        boolean result2 = phrase.includes("world");
        boolean result3 = phrase.includes("lo");
        boolean result4 = phrase.includes("lo", 5);
        System.out.println("\"Hello World\".includes(\"World\"): " + result1);
        System.out.println("\"Hello World\".includes(\"world\"): " + result2);
        System.out.println("\"Hello World\".includes(\"lo\"): " + result3);
        System.out.println("\"Hello World\".includes(\"lo\", 5): " + result4);
        // Expected:
        // "Hello World".includes("World"): true
        // "Hello World".includes("world"): false
        // "Hello World".includes("lo"): true
        // "Hello World".includes("lo", 5): false

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193);
        boolean result5 = arrows.includes(JSString.fromCodePoint(0x2191));
        boolean result6 = arrows.includes(JSString.fromCodePoint(0x2191), 1);
        System.out.println("\"←↑→↓\".includes(\"↑\"): " + result5);
        System.out.println("\"←↑→↓\".includes(\"↑\", 1): " + result6);
        // Expected:
        // "←↑→↓".includes("↑"): true
        // "←↑→↓".includes("↑", 1): true

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        boolean result7 = math.includes(JSString.fromCodePoint(0x221A));
        boolean result8 = math.includes(JSString.fromCodePoint(0x03C0), 2);
        System.out.println("\"∑√π∞\".includes(\"√\"): " + result7);
        System.out.println("\"∑√π∞\".includes(\"π\", 2): " + result8);
        // Expected:
        // "∑√π∞".includes("√"): true
        // "∑√π∞".includes("π", 2): true

        // Assert values
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertTrue(result5);
        assertTrue(result6);
        assertTrue(result7);
        assertTrue(result8);
    }
}