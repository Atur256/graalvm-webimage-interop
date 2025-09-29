package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IsWellFormedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.isWellFormed Demo ===");

        // Well-formed ASCII
        JSString ascii = JSString.of("Hello World");
        boolean result1 = ascii.isWellFormed();
        System.out.println("\"Hello World\".isWellFormed(): " + result1);
        // Excepted: "Hello World".isWellFormed(): true

        // Well-formed Unicode
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        boolean result2 = math.isWellFormed();
        System.out.println("\"∑√π∞\".isWellFormed(): " + result2);
        // Excepted: "∑√π∞".isWellFormed(): true

        // Malformed: high surrogate followed by ASCII
        JSString highPlusAscii = JSString.fromCharCode(0xD800, 0x0041);
        boolean result3 = highPlusAscii.isWellFormed();
        System.out.println("\"\\uD800A\".isWellFormed(): " + result3);
        // Excepted: "\uD800A".isWellFormed(): false

        // Malformed: low surrogate followed by ASCII
        JSString lowPlusAscii = JSString.fromCharCode(0xDC00, 0x0042);
        boolean result4 = lowPlusAscii.isWellFormed();
        System.out.println("\"\\uDC00B\".isWellFormed(): " + result4);
        // Excepted: "\uDC00B".isWellFormed(): false

        // Malformed: reversed surrogate pair
        JSString reversedPair = JSString.fromCharCode(0xDC00, 0xD800);
        boolean result5 = reversedPair.isWellFormed();
        System.out.println("\"\\uDC00\\uD800\".isWellFormed(): " + result5);
        // Excepted: "\uDC00\uD800".isWellFormed(): false

        // Assert values
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertFalse(result5);
    }
}