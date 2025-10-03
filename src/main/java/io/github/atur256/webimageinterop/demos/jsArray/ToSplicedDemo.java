package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;


public class ToSplicedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toSpliced Demo ===");

        JSArray arr = JSArray.of("a", "b", "c");

        JSArray spliced = arr.toSpliced(1, 1);
        System.out.println("Original array: " + arr);
        System.out.println("Spliced copy: " + spliced.toString());
        // Expected:
        // Original array: ["a", "b", "c"]
        // Spliced copy: ["a", "c"]

        // Assert values
        AssertArray.assertArray(spliced, String.class, "a", "c");
    }
}