package demos.uri;

import builtin.URI;


public class EncodeURIDemo {

    public static void main(String[] args) {
        System.out.println("\n=== URI.encodeURI Demo ===");

        System.out.println("encodeURI(\"https://example.com?name=John Doe&age=30\"): " +
                URI.encodeURI("https://example.com?name=John Doe&age=30"));
        // Expected: https://example.com?name=John%20Doe&age=30

        System.out.println("encodeURI(\"Hello World!\"): " +
                URI.encodeURI("Hello World!"));
        // Expected: Hello%20World!
    }
}
