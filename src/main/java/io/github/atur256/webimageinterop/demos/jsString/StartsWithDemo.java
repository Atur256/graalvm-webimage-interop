package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class StartsWithDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.startsWith Demo ===");

        JSString text = JSString.of("To be, or not to be, that is the question.");

        System.out.println("startsWith(\"To be\"): " + text.startsWith("To be"));
        System.out.println("startsWith(\"to be\"): " + text.startsWith("to be"));
        System.out.println("startsWith(JSString.of(\"To be\")): " + text.startsWith(JSString.of("To be")));
        System.out.println("startsWith(JSString.of(\"question\")): " + text.startsWith(JSString.of("question")));
        System.out.println("startsWith(\"not\", 10): " + text.startsWith("not", 10));
        System.out.println("startsWith(\"To\", 3): " + text.startsWith("To", 3));
        System.out.println("startsWith(JSString.of(\"not\"), 10): " + text.startsWith(JSString.of("not"), 10));
        System.out.println("startsWith(JSString.of(\"To\"), 3): " + text.startsWith(JSString.of("To"), 3));
        System.out.println("startsWith(\"To\", 100): " + text.startsWith("To", 100));
        System.out.println("startsWith(JSString.of(\"To\"), 100): " + text.startsWith(JSString.of("To"), 100));
        // Expected:
        // startsWith("To be"): true
        // startsWith("to be"): false
        // startsWith(JSString.of("To be")): true
        // startsWith(JSString.of("question")): false
        // startsWith("not", 10): true
        // startsWith("To", 3): false
        // startsWith(JSString.of("not"), 10): true
        // startsWith(JSString.of("To"), 3): false
        // startsWith("To", 100): false
        // startsWith(JSString.of("To"), 100): false
    }
}
