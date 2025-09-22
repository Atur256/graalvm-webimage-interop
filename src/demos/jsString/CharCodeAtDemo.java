package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class CharCodeAtDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.charCodeAt Demo ===");

        // ASCII: "Hello"
        JSString hello = JSString.of("Hello");
        System.out.println("\"Hello\".charCodeAt(0): " + hello.charCodeAt(0));
        System.out.println("\"Hello\".charCodeAt(4): " + hello.charCodeAt(4));
        // Expected:
        // "Hello".codePointAt(0): 72
        // "Hello".codePointAt(4): 111

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193);  // Use JSString.fromCodePoint to correctly create Unicode strings
        System.out.println("\"←↑→↓\".charCodeAt(0): " + arrows.charCodeAt(0));
        System.out.println("\"←↑→↓\".charCodeAt(2): " + arrows.charCodeAt(2));
        // Expected:
        // "←↑→↓".codePointAt(0): 8592
        // "←↑→↓".codePointAt(2): 8594

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        System.out.println("\"∑√π∞\".charCodeAt(1): " + math.charCodeAt(1));
        System.out.println("\"∑√π∞\".charCodeAt(3): " + math.charCodeAt(3));
        // Expected:
        // "∑√π∞".codePointAt(1): 8730
        // "∑√π∞".codePointAt(3): 8734

        // Currency symbols: €¥₹$
        JSString currency = JSString.fromCodePoint(0x20AC, 0x00A5, 0x20B9, 0x0024);
        System.out.println("\"€¥₹$\".charCodeAt(2): " + currency.charCodeAt(2));
        System.out.println("\"€¥₹$\".charCodeAt(3): " + currency.charCodeAt(3));
        // Expected:
        // "€¥₹$".codePointAt(2): 8377
        // "€¥₹$".codePointAt(3): 36
    }
}
