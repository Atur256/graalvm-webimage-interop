package demos.jsUri;

import builtin.JSUri;


public class DecodeURIDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSURI.decodeURI Demo ===");

        System.out.println("decodeURI(\"https://example.com?name=John%20Doe&age=30\"): " +
                JSUri.decodeURI("https://example.com?name=John%20Doe&age=30"));
        // Expected: decodeURI("https://example.com?name=John%20Doe&age=30"): https://example.com?name=John Doe&age=30

        System.out.println("decodeURI(\"Hello%20World!\"): " +
                JSUri.decodeURI("Hello%20World!"));
        // Expected: decodeURI("Hello%20World!"): Hello World!
    }
}
