package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class AtDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.at Demo ===");

        // ASCII: "Hello"
        JSString hello = JSString.of("Hello");
        System.out.println("\"Hello\".at(0): \"" + hello.at(0).as(String.class) + "\"");
        System.out.println("\"Hello\".at(4): \"" + hello.at(4).as(String.class) + "\"");
        System.out.println("\"Hello\".at(-1): \"" + hello.at(-1).as(String.class) + "\"");
        // Expected:
        // "Hello".at(0): "H"
        // "Hello".at(4): "o"
        // "Hello".at(-1): "o"

        // Word: "JavaScript"
        JSString js = JSString.of("JavaScript");
        System.out.println("\"JavaScript\".at(4): \"" + js.at(4).as(String.class) + "\"");
        System.out.println("\"JavaScript\".at(-3): \"" + js.at(-3).as(String.class) + "\"");
        // Expected:
        // "JavaScript".at(4): "S"
        // "JavaScript".at(-3): "i"

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193); // Use JSString.fromCodePoint to correctly create Unicode strings
        System.out.println("\"←↑→↓\".at(1): \"" + arrows.at(1).as(String.class) + "\"");
        System.out.println("\"←↑→↓\".at(-2): \"" + arrows.at(-2).as(String.class) + "\"");
        // Expected:
        // "←↑→↓".at(1): "↑"
        // "←↑→↓".at(-2): "→"

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        System.out.println("\"∑√π∞\".at(0): \"" + math.at(0).as(String.class) + "\"");
        System.out.println("\"∑√π∞\".at(3): \"" + math.at(3).as(String.class) + "\"");
        // Expected:
        // "∑√π∞".at(0): "∑"
        // "∑√π∞".at(3): "∞"

        // Unicode currency: €¥₹$
        JSString currency = JSString.fromCodePoint(0x20AC, 0x00A5, 0x20B9, 0x0024);
        System.out.println("\"€¥₹$\".at(2): \"" + currency.at(2).as(String.class) + "\"");
        System.out.println("\"€¥₹$\".at(-1): \"" + currency.at(-1).as(String.class) + "\"");
        // Expected:
        // "€¥₹$".at(2): "₹"
        // "€¥₹$".at(-1): "$"
    }
}
