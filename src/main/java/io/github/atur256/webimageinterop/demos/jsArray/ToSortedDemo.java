package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;


public class ToSortedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toSorted Demo ===");

        JSArray arr = JSArray.of("zebra", "apple", "mango");

        JSArray sorted = arr.toSorted();
        System.out.println("Original array: " + arr);
        System.out.println("Sorted copy: " + sorted.toString());
        // Expected:
        // Original array: ["zebra", "apple", "mango"]
        // Sorted copy: ["apple", "mango", "zebra"]
    }
}
