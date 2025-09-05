package demos.jsUri;

import builtin.JSURI;


public class EncodeURIDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSURI.encodeURI Demo ===");

        System.out.println("encodeURI(\"https://example.com?name=John Doe&age=30\"): " +
                JSURI.encodeURI("https://example.com?name=John Doe&age=30"));
        // Expected: https://example.com?name=John%20Doe&age=30

        System.out.println("encodeURI(\"Hello World!\"): " +
                JSURI.encodeURI("Hello World!"));
        // Expected: Hello%20World!
    }
}
