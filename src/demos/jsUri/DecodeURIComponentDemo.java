package demos.jsUri;

import builtin.JSURI;


public class DecodeURIComponentDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSURI.decodeURIComponent Demo ===");

        System.out.println("decodeURIComponent(\"John%20Doe%20%26%20Co.\"): " +
                JSURI.decodeURIComponent("John%20Doe%20%26%20Co."));
        // Expected: John Doe & Co.

        System.out.println("decodeURIComponent(\"a%2Bb%3Dc%26d\"): " +
                JSURI.decodeURIComponent("a%2Bb%3Dc%26d"));
        // Expected: a+b=c&d
    }
}
