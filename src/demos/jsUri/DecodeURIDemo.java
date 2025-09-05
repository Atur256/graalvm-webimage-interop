package demos.jsUri;

import builtin.JSURI;


public class DecodeURIDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSURI.decodeURI Demo ===");

        System.out.println("decodeURI(\"https://example.com?name=John%20Doe&age=30\"): " +
                JSURI.decodeURI("https://example.com?name=John%20Doe&age=30"));
        // Expected: https://example.com?name=John Doe&age=30

        System.out.println("decodeURI(\"Hello%20World!\"): " +
                JSURI.decodeURI("Hello%20World!"));
        // Expected: Hello World!
    }
}
