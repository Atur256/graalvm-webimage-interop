package demos.uri;

import builtin.URI;


public class EncodeURIComponentDemo {

    public static void main(String[] args) {
        System.out.println("\n=== URI.encodeURIComponent Demo ===");

        System.out.println("encodeURIComponent(\"John Doe & Co.\"): " +
                URI.encodeURIComponent("John Doe & Co."));
        // Expected: John%20Doe%20%26%20Co.

        System.out.println("encodeURIComponent(\"a+b=c&d\"): " +
                URI.encodeURIComponent("a+b=c&d"));
        // Expected: a%2Bb%3Dc%26d
    }
}
