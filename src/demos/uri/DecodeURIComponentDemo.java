package demos.uri;

import builtin.URI;


public class DecodeURIComponentDemo {

    public static void main(String[] args) {
        System.out.println("\n=== URI.decodeURIComponent Demo ===");

        System.out.println("decodeURIComponent(\"John%20Doe%20%26%20Co.\"): " +
                URI.decodeURIComponent("John%20Doe%20%26%20Co."));
        // Expected: John Doe & Co.

        System.out.println("decodeURIComponent(\"a%2Bb%3Dc%26d\"): " +
                URI.decodeURIComponent("a%2Bb%3Dc%26d"));
        // Expected: a+b=c&d
    }
}
