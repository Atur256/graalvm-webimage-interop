package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.demos.AssertArray;


public class SortDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.sort Demo ===");

        JSArray arr = JSArray.of("banana", "apple", "cherry");

        arr.sort();
        System.out.println("Sorted array: " + arr);
        // Expected: Sorted array: ["apple", "banana", "cherry"]

        // Assert values
        AssertArray.assertArray(arr, String.class, "apple", "banana", "cherry");
    }
}