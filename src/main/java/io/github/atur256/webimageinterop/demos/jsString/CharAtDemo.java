package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class CharAtDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.charAt Demo ===");

        // ASCII: "Hello"
        JSString hello = JSString.of("Hello");
        String result1 = hello.charAt(0).as(String.class);
        String result2 = hello.charAt(4).as(String.class);
        System.out.println("\"Hello\".charAt(0): \"" + result1 + "\"");
        System.out.println("\"Hello\".charAt(4): \"" + result2 + "\"");
        // Expected:
        // "Hello".charAt(0): "H"
        // "Hello".charAt(4): "o"

        // Word: "JavaScript"
        JSString js = JSString.of("JavaScript");
        String result3 = js.charAt(4).as(String.class);
        String result4 = js.charAt(9).as(String.class);
        System.out.println("\"JavaScript\".charAt(4): \"" + result3 + "\"");
        System.out.println("\"JavaScript\".charAt(9): \"" + result4 + "\"");
        // Expected:
        // "JavaScript".charAt(4): "S"
        // "JavaScript".charAt(9): "t"

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193); // Use JSString.fromCodePoint to correctly create Unicode strings
        String result5 = arrows.charAt(0).as(String.class);
        String result6 = arrows.charAt(2).as(String.class);
        System.out.println("\"←↑→↓\".charAt(0): \"" + result5 + "\"");
        System.out.println("\"←↑→↓\".charAt(2): \"" + result6 + "\"");
        // Expected:
        // "←↑→↓".charAt(0): "←"
        // "←↑→↓".charAt(2): "→"

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        String result7 = math.charAt(1).as(String.class);
        String result8 = math.charAt(3).as(String.class);
        System.out.println("\"∑√π∞\".charAt(1): \"" + result7 + "\"");
        System.out.println("\"∑√π∞\".charAt(3): \"" + result8 + "\"");
        // Expected:
        // "∑√π∞".charAt(1): "√"
        // "∑√π∞".charAt(3): "∞"

        // Unicode currency: €¥₹$
        JSString currency = JSString.fromCodePoint(0x20AC, 0x00A5, 0x20B9, 0x0024);
        String result9 = currency.charAt(2).as(String.class);
        String result10 = currency.charAt(3).as(String.class);
        System.out.println("\"€¥₹$\".charAt(2): \"" + result9 + "\"");
        System.out.println("\"€¥₹$\".charAt(3): \"" + result10 + "\"");
        // Expected:
        // "€¥₹$".charAt(2): "₹"
        // "€¥₹$".charAt(3): "$"

        // Assert values
        assertEquals("H", result1);
        assertEquals("o", result2);
        assertEquals("S", result3);
        assertEquals("t", result4);
        assertEquals("←", result5);
        assertEquals("→", result6);
        assertEquals("√", result7);
        assertEquals("∞", result8);
        assertEquals("₹", result9);
        assertEquals("$", result10);
    }
}