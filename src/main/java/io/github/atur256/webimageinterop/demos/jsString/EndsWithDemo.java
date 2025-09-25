package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class EndsWithDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.endsWith Demo ===");

        // ASCII: "Hello World"
        JSString phrase = JSString.of("Hello World");
        System.out.println("\"Hello World\".endsWith(\"World\"): " + phrase.endsWith("World"));
        System.out.println("\"Hello World\".endsWith(\"world\"): " + phrase.endsWith("world"));
        System.out.println("\"Hello World\".endsWith(\"Hello\"): " + phrase.endsWith("Hello"));
        System.out.println("\"Hello World\".endsWith(\"Hello\", 5): " + phrase.endsWith("Hello", 5)); // true
        // Expected:
        // "Hello World".endsWith("World"): true
        // "Hello World".endsWith("world"): false
        // "Hello World".endsWith("Hello"): false
        // "Hello World".endsWith("Hello", 5): true

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193); // Use JSString.fromCodePoint to correctly create Unicode strings
        System.out.println("\"←↑→↓\".endsWith(\"→↓\"): " + arrows.endsWith(JSString.fromCodePoint(0x2192, 0x2193)));
        System.out.println("\"←↑→↓\".endsWith(\"↑\", 2): " + arrows.endsWith(JSString.fromCodePoint(0x2191), 2));
        // Expected:
        // "←↑→↓".endsWith("→↓"): true
        // "←↑→↓".endsWith("↑", 2): true

        // Unicode math: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        System.out.println("\"∑√π∞\".endsWith(\"π∞\"): " + math.endsWith(JSString.fromCodePoint(0x03C0, 0x221E)));
        System.out.println("\"∑√π∞\".endsWith(\"√\", 2): " + math.endsWith(JSString.fromCodePoint(0x221A), 2));
        System.out.println("\"∑√π∞\".endsWith(\"∞\", 3): " + math.endsWith(JSString.fromCodePoint(0x221E), 3));
        // Expected:
        // "∑√π∞".endsWith("π∞"): true
        // "∑√π∞".endsWith("√", 2): true
        // "∑√π∞".endsWith("∞", 3): false
    }
}
