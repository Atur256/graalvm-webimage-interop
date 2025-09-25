package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class CharAtDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.charAt Demo ===");

        // ASCII: "Hello"
        JSString hello = JSString.of("Hello");
        System.out.println("\"Hello\".charAt(0): \"" + hello.charAt(0).as(String.class) + "\"");
        System.out.println("\"Hello\".charAt(4): \"" + hello.charAt(4).as(String.class) + "\"");
        // Expected:
        // "Hello".charAt(0): "H"
        // "Hello".charAt(4): "o"

        // Word: "JavaScript"
        JSString js = JSString.of("JavaScript");
        System.out.println("\"JavaScript\".charAt(4): \"" + js.charAt(4).as(String.class) + "\"");
        System.out.println("\"JavaScript\".charAt(9): \"" + js.charAt(9).as(String.class) + "\"");
        // Expected:
        // "JavaScript".charAt(4): "S"
        // "JavaScript".charAt(9): "t"

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193); // Use JSString.fromCodePoint to correctly create Unicode strings
        System.out.println("\"←↑→↓\".charAt(0): \"" + arrows.charAt(0).as(String.class) + "\"");
        System.out.println("\"←↑→↓\".charAt(2): \"" + arrows.charAt(2).as(String.class) + "\"");
        // Expected:
        // "←↑→↓".charAt(0): "←"
        // "←↑→↓".charAt(2): "→"

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        System.out.println("\"∑√π∞\".charAt(1): \"" + math.charAt(1).as(String.class) + "\"");
        System.out.println("\"∑√π∞\".charAt(3): \"" + math.charAt(3).as(String.class) + "\"");
        // Expected:
        // "∑√π∞".charAt(1): "√"
        // "∑√π∞".charAt(3): "∞"

        // Unicode currency: €¥₹$
        JSString currency = JSString.fromCodePoint(0x20AC, 0x00A5, 0x20B9, 0x0024);
        System.out.println("\"€¥₹$\".charAt(2): \"" + currency.charAt(2).as(String.class) + "\"");
        System.out.println("\"€¥₹$\".charAt(3): \"" + currency.charAt(3).as(String.class) + "\"");
        // Expected:
        // "€¥₹$".charAt(2): "₹"
        // "€¥₹$".charAt(3): "$"
    }
}
