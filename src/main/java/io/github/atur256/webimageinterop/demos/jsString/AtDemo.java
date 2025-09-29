package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class AtDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.at Demo ===");

        // ASCII: "Hello"
        JSString hello = JSString.of("Hello");
        String result1 = hello.at(0).as(String.class);
        String result2 = hello.at(4).as(String.class);
        String result3 = hello.at(-1).as(String.class);
        System.out.println("\"Hello\".at(0): \"" + result1 + "\"");
        System.out.println("\"Hello\".at(4): \"" + result2 + "\"");
        System.out.println("\"Hello\".at(-1): \"" + result3 + "\"");
        // Expected:
        // "Hello".at(0): "H"
        // "Hello".at(4): "o"
        // "Hello".at(-1): "o"

        // Word: "JavaScript"
        JSString js = JSString.of("JavaScript");
        String result4 = js.at(4).as(String.class);
        String result5 = js.at(-3).as(String.class);
        System.out.println("\"JavaScript\".at(4): \"" + result4 + "\"");
        System.out.println("\"JavaScript\".at(-3): \"" + result5 + "\"");
        // Expected:
        // "JavaScript".at(4): "S"
        // "JavaScript".at(-3): "i"

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193); // Use JSString.fromCodePoint to correctly create Unicode strings
        String result6 = arrows.at(1).as(String.class);
        String result7 = arrows.at(-2).as(String.class);
        System.out.println("\"←↑→↓\".at(1): \"" + result6 + "\"");
        System.out.println("\"←↑→↓\".at(-2): \"" + result7 + "\"");
        // Expected:
        // "←↑→↓".at(1): "↑"
        // "←↑→↓".at(-2): "→"

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        String result8 = math.at(0).as(String.class);
        String result9 = math.at(3).as(String.class);
        System.out.println("\"∑√π∞\".at(0): \"" + result8 + "\"");
        System.out.println("\"∑√π∞\".at(3): \"" + result9 + "\"");
        // Expected:
        // "∑√π∞".at(0): "∑"
        // "∑√π∞".at(3): "∞"

        // Unicode currency: €¥₹$
        JSString currency = JSString.fromCodePoint(0x20AC, 0x00A5, 0x20B9, 0x0024);
        String result10 = currency.at(2).as(String.class);
        String result11 = currency.at(-1).as(String.class);
        System.out.println("\"€¥₹$\".at(2): \"" + result10 + "\"");
        System.out.println("\"€¥₹$\".at(-1): \"" + result11 + "\"");
        // Expected:
        // "€¥₹$".at(2): "₹"
        // "€¥₹$".at(-1): "$"

        // Assert values
        assertEquals("H", result1);
        assertEquals("o", result2);
        assertEquals("o", result3);
        assertEquals("S", result4);
        assertEquals("i", result5);
        assertEquals("↑", result6);
        assertEquals("→", result7);
        assertEquals("∑", result8);
        assertEquals("∞", result9);
        assertEquals("₹", result10);
        assertEquals("$", result11);
    }
}