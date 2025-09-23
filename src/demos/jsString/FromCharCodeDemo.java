package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class FromCharCodeDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.fromCharCode Demo ===");

        // Zero-argument call
        JSString empty = JSString.fromCharCode();
        System.out.println("fromCharCode(): \"" + empty.as(String.class) + "\"");
        // Expected: fromCharCode(): ""

        // Single character
        JSString single = JSString.fromCharCode(65);
        System.out.println("fromCharCode(65): \"" + single.as(String.class) + "\"");
        // Expected: fromCharCode(65): "A"

        // Multiple characters
        JSString hello = JSString.fromCharCode(72, 101, 108, 108, 111);
        System.out.println("fromCharCode(72,101,108,108,111): \"" + hello.as(String.class) + "\"");
        // Expected: fromCharCode(72,101,108,108,111): "Hello"

        // Unicode symbols
        JSString symbols = JSString.fromCharCode(36, 169, 174);
        System.out.println("fromCharCode(36,169,174): \"" + symbols.as(String.class) + "\"");
        // Expected: fromCharCode(36,169,174): "$©®"

        // Emoji (surrogate pair)
        JSString emoji = JSString.fromCharCode(0xD83D, 0xDE00);
        System.out.println("fromCharCode(0xD83D,0xDE00): \"" + emoji.as(String.class) + "\"");
        // Expected: fromCharCode(0xD83D,0xDE00): "😀"
    }
}
