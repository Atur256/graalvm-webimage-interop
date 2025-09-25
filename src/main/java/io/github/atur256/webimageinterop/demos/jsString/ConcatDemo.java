package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class ConcatDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.concat Demo ===");

        // Base string: "Hello"
        JSString base = JSString.of("Hello");

        // Suffixes: ", ", "World", "!"
        JSString comma = JSString.of(", ");
        JSString world = JSString.of("World");
        JSString exclaim = JSString.of("!");

        JSString result = base.concat(comma, world, exclaim);
        System.out.println("concat(\"Hello\", \", \", \"World\", \"!\"): \"" + result.as(String.class) + "\"");
        // Expected: concat("Hello", ", ", "World", "!"): "Hello, World!"

        // Unicode symbols: arrows ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193); // Use JSString.fromCodePoint to correctly create Unicode strings
        JSString label = JSString.of("Arrows: ");
        JSString arrowLine = label.concat(arrows);
        System.out.println("concat(\"Arrows: \", \"←↑→↓\"): \"" + arrowLine.as(String.class) + "\"");
        // Expected: concat("Arrows: ", "←↑→↓"): "Arrows: ←↑→↓"

        // Math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        JSString mathLabel = JSString.of("Math: ");
        JSString mathLine = mathLabel.concat(math);
        System.out.println("concat(\"Math: \", \"∑√π∞\"): \"" + mathLine.as(String.class) + "\"");
        // Expected: concat("Math: ", "∑√π∞"): "Math: ∑√π∞"
    }
}
