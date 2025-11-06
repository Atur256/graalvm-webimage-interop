package io.github.atur256.webimageinterop;

import io.github.atur256.webimageinterop.tests.*;


/**
 * Entry point for running all WebImage interop tests.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Starting WebImage interop test suite...\n");
        RunAllTests.main(args);
        System.out.println("\nTest suite completed.");
    }
}
