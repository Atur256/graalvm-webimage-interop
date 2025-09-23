package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class ToLowerCaseDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.toLowerCase Demo ===");

        JSString text = JSString.of("The quick brown fox jumps over the lazy dog.");

        System.out.println("toLowerCase(): " + text.toLowerCase().as(String.class));
        // Expected: toLowerCase(): the quick brown fox jumps over the lazy dog.
    }
}
