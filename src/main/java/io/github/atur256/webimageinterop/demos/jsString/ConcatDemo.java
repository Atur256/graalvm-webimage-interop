package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class ConcatDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.concat Demo ===");

        // Base string: "Hello"
        JSString base = JSString.of("Hello");

        // Suffixes: ", ", "World", "!"
        JSString comma = JSString.of(", ");
        JSString world = JSString.of("World");
        JSString exclaim = JSString.of("!");

        String result = base.concat(comma, world, exclaim).as(String.class);
        System.out.println("concat(\"Hello\", \", \", \"World\", \"!\"): \"" + result + "\"");
        // Expected: concat("Hello", ", ", "World", "!"): "Hello, World!"

        // Unicode symbols: arrows ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193); // Use JSString.fromCodePoint to correctly create Unicode strings
        JSString label = JSString.of("Arrows: ");
        String arrowLine = label.concat(arrows).as(String.class);
        System.out.println("concat(\"Arrows: \", \"←↑→↓\"): \"" + arrowLine + "\"");
        // Expected: concat("Arrows: ", "←↑→↓"): "Arrows: ←↑→↓"

        // Math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        JSString mathLabel = JSString.of("Math: ");
        String mathLine = mathLabel.concat(math).as(String.class);
        System.out.println("concat(\"Math: \", \"∑√π∞\"): \"" + mathLine + "\"");
        // Expected: concat("Math: ", "∑√π∞"): "Math: ∑√π∞"

        // Assert values
        assertEquals("Hello, World!", result);
        assertEquals("Arrows: ←↑→↓", arrowLine);
        assertEquals("Math: ∑√π∞", mathLine);
    }
}