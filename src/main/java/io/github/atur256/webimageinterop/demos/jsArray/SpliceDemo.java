package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;


public class SpliceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.splice Demo ===");

        JSArray arr = JSArray.of("a", "b", "c", "d");

        JSArray removed = arr.splice(1, 2);
        System.out.println("Removed elements: " + removed.toString());
        System.out.println("Remaining array: " + arr);
        // Expected:
        // Removed elements: ["b", "c"]
        // Remaining array: ["a", "d"]
    }
}
