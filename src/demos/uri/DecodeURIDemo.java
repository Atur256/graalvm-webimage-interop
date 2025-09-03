package demos.uri;

import builtin.URI;


public class DecodeURIDemo {

    public static void main(String[] args) {
        System.out.println("\n=== URI.decodeURI Demo ===");

        System.out.println("decodeURI(\"https://example.com?name=John%20Doe&age=30\"): " +
                URI.decodeURI("https://example.com?name=John%20Doe&age=30"));
        // Expected: https://example.com?name=John Doe&age=30

        System.out.println("decodeURI(\"Hello%20World!\"): " +
                URI.decodeURI("Hello%20World!"));
        // Expected: Hello World!
    }
}
