package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class StringIsWellFormedDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.isWellFormed Demo ===");

        // Well-formed ASCII
        JSString ascii = JSString.of("Hello World");
        System.out.println("\"Hello World\".isWellFormed(): " + ascii.isWellFormed());
        // Excepted: "Hello World".isWellFormed(): true

        // Well-formed Unicode
        JSString math = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
        System.out.println("\"∑√π∞\".isWellFormed(): " + math.isWellFormed());
        // Excepted: "∑√π∞".isWellFormed(): true

        // Malformed: high surrogate followed by ASCII
        JSString highPlusAscii = JSString.fromCharCode(0xD800, 0x0041);
        System.out.println("\"\\uD800A\".isWellFormed(): " + highPlusAscii.isWellFormed());
        // Excepted: "\uD800A".isWellFormed(): false

        // Malformed: low surrogate followed by ASCII
        JSString lowPlusAscii = JSString.fromCharCode(0xDC00, 0x0042);
        System.out.println("\"\\uDC00B\".isWellFormed(): " + lowPlusAscii.isWellFormed());
        // Excepted: "\uDC00B".isWellFormed(): false

        // Malformed: reversed surrogate pair
        JSString reversedPair = JSString.fromCharCode(0xDC00, 0xD800);
        System.out.println("\"\\uDC00\\uD800\".isWellFormed(): " + reversedPair.isWellFormed());
        // Excepted: "\uDC00\uD800".isWellFormed(): false
    }
}
