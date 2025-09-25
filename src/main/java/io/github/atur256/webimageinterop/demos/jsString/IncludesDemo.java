package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class IncludesDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.includes Demo ===");

        // ASCII: "Hello World"
        JSString phrase = JSString.of("Hello World");
        System.out.println("\"Hello World\".includes(\"World\"): " + phrase.includes("World"));
        System.out.println("\"Hello World\".includes(\"world\"): " + phrase.includes("world"));
        System.out.println("\"Hello World\".includes(\"lo\"): " + phrase.includes("lo"));
        System.out.println("\"Hello World\".includes(\"lo\", 5): " + phrase.includes("lo", 5));
        // Expected:
        // "Hello World".includes("World"): true
        // "Hello World".includes("world"): false
        // "Hello World".includes("lo"): true
        // "Hello World".includes("lo", 5): false

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193);
        System.out.println("\"←↑→↓\".includes(\"↑\"): " + arrows.includes(JSString.fromCodePoint(0x2191)));
        System.out.println("\"←↑→↓\".includes(\"↑\", 1): " + arrows.includes(JSString.fromCodePoint(0x2191), 1));
        // Expected:
        // "←↑→↓".includes("↑"): true
        // "←↑→↓".includes("↑", 1): true

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        System.out.println("\"∑√π∞\".includes(\"√\"): " + math.includes(JSString.fromCodePoint(0x221A)));
        System.out.println("\"∑√π∞\".includes(\"π\", 2): " + math.includes(JSString.fromCodePoint(0x03C0), 2));
        // Expected:
        // "∑√π∞".includes("√"): true
        // "∑√π∞".includes("π", 2): true
    }
}
