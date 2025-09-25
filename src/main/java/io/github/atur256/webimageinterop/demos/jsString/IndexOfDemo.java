package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class IndexOfDemo {


    public static void main(String[] args) {
        System.out.println("=== JSString.indexOf Demo ===");

        // ASCII: "Hello World"
        JSString phrase = JSString.of("Hello World");
        System.out.println("\"Hello World\".indexOf(\"World\"): " + phrase.indexOf("World"));
        System.out.println("\"Hello World\".indexOf(\"world\"): " + phrase.indexOf("world"));
        System.out.println("\"Hello World\".indexOf(\"l\"): " + phrase.indexOf("l"));
        System.out.println("\"Hello World\".indexOf(\"l\", 4): " + phrase.indexOf("l", 4));
        // Expected:
        // "Hello World".indexOf("World"): 6
        // "Hello World".indexOf("world"): -1
        // "Hello World".indexOf("l"): 2
        // "Hello World".indexOf("l", 4): 9

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193);
        System.out.println("\"←↑→↓\".indexOf(\"↑\"): " + arrows.indexOf(JSString.fromCodePoint(0x2191)));
        System.out.println("\"←↑→↓\".indexOf(\"→\", 2): " + arrows.indexOf(JSString.fromCodePoint(0x2192), 2));
        // Expected:
        // "←↑→↓".indexOf("↑"): 1
        // "←↑→↓".indexOf("→", 2): 2

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        System.out.println("\"∑√π∞\".indexOf(\"π\"): " + math.indexOf(JSString.fromCodePoint(0x03C0)));
        System.out.println("\"∑√π∞\".indexOf(\"√\", 1): " + math.indexOf(JSString.fromCodePoint(0x221A), 1));
        // Expected:
        // "∑√π∞".indexOf("π"): 2
        // "∑√π∞".indexOf("√", 1): 1
    }
}
