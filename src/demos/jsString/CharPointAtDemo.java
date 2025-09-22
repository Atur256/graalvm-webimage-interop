package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class CharPointAtDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.codePointAt Demo ===");

        // ASCII: "Hello"
        JSString hello = JSString.of("Hello");
        System.out.println("\"Hello\".codePointAt(0): " + hello.codePointAt(0));
        System.out.println("\"Hello\".codePointAt(4): " + hello.codePointAt(4));
        // Expected:
        // "Hello".charCodeAt(0): 72
        // "Hello".charCodeAt(4): 111

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193); // Use JSString.fromCodePoint to correctly create Unicode strings
        System.out.println("\"←↑→↓\".codePointAt(0): " + arrows.codePointAt(0));
        System.out.println("\"←↑→↓\".codePointAt(2): " + arrows.codePointAt(2));
        // Expected:
        // "←↑→↓".charCodeAt(0): 8592
        // "←↑→↓".charCodeAt(2): 8594

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        System.out.println("\"∑√π∞\".codePointAt(1): " + math.codePointAt(1));
        System.out.println("\"∑√π∞\".codePointAt(3): " + math.codePointAt(3));
        // Expected:
        // "∑√π∞".charCodeAt(1): 8730
        // "∑√π∞".charCodeAt(3): 8734

        // Currency symbols: €¥₹$
        JSString currency = JSString.fromCodePoint(0x20AC, 0x00A5, 0x20B9, 0x0024);
        System.out.println("\"€¥₹$\".codePointAt(2): " + currency.codePointAt(2));
        System.out.println("\"€¥₹$\".codePointAt(3): " + currency.codePointAt(3));
        // Expected:
        // "€¥₹$".charCodeAt(2): 8377
        // "€¥₹$".charCodeAt(3): 36
    }
}
