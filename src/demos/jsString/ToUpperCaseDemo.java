package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class ToUpperCaseDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.toUpperCase Demo ===");

        JSString text = JSString.of("The quick brown fox jumps over the lazy dog.");

        System.out.println("toUpperCase(): " + text.toUpperCase().as(String.class));
        // Expected: toUpperCase(): THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.
    }
}
