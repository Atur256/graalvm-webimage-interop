package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class IndexOfDemo {


    public static void main(String[] args) {
        System.out.println("\n=== JSString.indexOf Demo ===");

        // ASCII: "Hello World"
        JSString phrase = JSString.of("Hello World");
        int result1 = phrase.indexOf("World");
        int result2 = phrase.indexOf("world");
        int result3 = phrase.indexOf("l");
        int result4 = phrase.indexOf("l", 4);
        System.out.println("\"Hello World\".indexOf(\"World\"): " + result1);
        System.out.println("\"Hello World\".indexOf(\"world\"): " + result2);
        System.out.println("\"Hello World\".indexOf(\"l\"): " + result3);
        System.out.println("\"Hello World\".indexOf(\"l\", 4): " + result4);
        // Expected:
        // "Hello World".indexOf("World"): 6
        // "Hello World".indexOf("world"): -1
        // "Hello World".indexOf("l"): 2
        // "Hello World".indexOf("l", 4): 9

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193);
        int result5 = arrows.indexOf(JSString.fromCodePoint(0x2191));
        int result6 = arrows.indexOf(JSString.fromCodePoint(0x2192), 2);
        System.out.println("\"←↑→↓\".indexOf(\"↑\"): " + result5);
        System.out.println("\"←↑→↓\".indexOf(\"→\", 2): " + result6);
        // Expected:
        // "←↑→↓".indexOf("↑"): 1
        // "←↑→↓".indexOf("→", 2): 2

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        int result7 = math.indexOf(JSString.fromCodePoint(0x03C0));
        int result8 = math.indexOf(JSString.fromCodePoint(0x221A), 1);
        System.out.println("\"∑√π∞\".indexOf(\"π\"): " + result7);
        System.out.println("\"∑√π∞\".indexOf(\"√\", 1): " + result8);
        // Expected:
        // "∑√π∞".indexOf("π"): 2
        // "∑√π∞".indexOf("√", 1): 1

        // Assert values
        assertEquals(6, result1);
        assertEquals(-1, result2);
        assertEquals(2, result3);
        assertEquals(9, result4);
        assertEquals(1, result5);
        assertEquals(2, result6);
        assertEquals(2, result7);
        assertEquals(1, result8);
    }
}