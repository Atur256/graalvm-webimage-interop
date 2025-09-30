package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.demos.AssertArray;


public class SliceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.slice Demo ===");

        JSArray arr1 = JSArray.of(1, 2, 3);
        JSArray result1 = arr1.slice(1, 3);
        System.out.println("Sliced: " + result1.toString());
        // Expected: Sliced: [2, 3]

        JSArray arr2 = JSArray.of("apple", "banana", "cherry");
        JSArray result2 = arr2.slice(1, 2);
        System.out.println("Sliced: " + result2.toString());
        // Expected: Sliced: ["banana"]

        // Assert values
        AssertArray.assertArray(result1, Integer.class, 2, 3);
        AssertArray.assertArray(result2, String.class, "banana");
    }
}