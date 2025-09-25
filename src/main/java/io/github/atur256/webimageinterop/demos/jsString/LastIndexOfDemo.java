package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class LastIndexOfDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.lastIndexOf Demo ===");

        // ASCII: "Hello Hello"
        JSString phrase = JSString.of("Hello Hello");
        System.out.println("\"Hello Hello\".lastIndexOf(\"Hello\"): " + phrase.lastIndexOf("Hello"));
        System.out.println("\"Hello Hello\".lastIndexOf(\"Hello\", 5): " + phrase.lastIndexOf("Hello", 5));
        System.out.println("\"Hello Hello\".lastIndexOf(\"lo\"): " + phrase.lastIndexOf("lo"));
        // Expected:
        // "Hello Hello".lastIndexOf("Hello"): 6
        // "Hello Hello".lastIndexOf("Hello", 5): 0
        // "Hello Hello".lastIndexOf("lo"): 9

        // Unicode arrows: ←↑→↓←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193, 0x2190, 0x2191, 0x2192, 0x2193);
        System.out.println("\"←↑→↓←↑→↓\".lastIndexOf(\"→\"): " + arrows.lastIndexOf(JSString.fromCodePoint(0x2192)));
        System.out.println("\"←↑→↓←↑→↓\".lastIndexOf(\"→\", 6): " + arrows.lastIndexOf(JSString.fromCodePoint(0x2192), 6));
        // Expected:
        // "←↑→↓←↑→↓".lastIndexOf("→"): 6
        // "←↑→↓←↑→↓".lastIndexOf("→", 6): 6
    }
}
