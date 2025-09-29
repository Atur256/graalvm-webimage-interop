package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class CharCodeAtDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.charCodeAt Demo ===");

        // ASCII: "Hello"
        JSString hello = JSString.of("Hello");
        int result1 = hello.charCodeAt(0);
        int result2 = hello.charCodeAt(4);
        System.out.println("\"Hello\".charCodeAt(0): " + result1);
        System.out.println("\"Hello\".charCodeAt(4): " + result2);
        // Expected:
        // "Hello".codePointAt(0): 72
        // "Hello".codePointAt(4): 111

        // Unicode arrows: ←↑→↓
        JSString arrows = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193);  // Use JSString.fromCodePoint to correctly create Unicode strings
        int result3 = arrows.charCodeAt(0);
        int result4 = arrows.charCodeAt(2);
        System.out.println("\"←↑→↓\".charCodeAt(0): " + result3);
        System.out.println("\"←↑→↓\".charCodeAt(2): " + result4);
        // Expected:
        // "←↑→↓".codePointAt(0): 8592
        // "←↑→↓".codePointAt(2): 8594

        // Unicode math symbols: ∑√π∞
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        int result5 = math.charCodeAt(1);
        int result6 = math.charCodeAt(3);
        System.out.println("\"∑√π∞\".charCodeAt(1): " + result5);
        System.out.println("\"∑√π∞\".charCodeAt(3): " + result6);
        // Expected:
        // "∑√π∞".codePointAt(1): 8730
        // "∑√π∞".codePointAt(3): 8734

        // Currency symbols: €¥₹$
        JSString currency = JSString.fromCodePoint(0x20AC, 0x00A5, 0x20B9, 0x0024);
        int result7 = currency.charCodeAt(2);
        int result8 = currency.charCodeAt(3);
        System.out.println("\"€¥₹$\".charCodeAt(2): " + result7);
        System.out.println("\"€¥₹$\".charCodeAt(3): " + result8);
        // Expected:
        // "€¥₹$".codePointAt(2): 8377
        // "€¥₹$".codePointAt(3): 36

        // Assert values
        assertEquals(72, result1);
        assertEquals(111, result2);
        assertEquals(8592, result3);
        assertEquals(8594, result4);
        assertEquals(8730, result5);
        assertEquals(8734, result6);
        assertEquals(8377, result7);
        assertEquals(36, result8);
    }
}