package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;


public class ToReversedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toReversed Demo ===");

        JSArray arr = JSArray.of(1, 2, 3);

        JSArray reversed = arr.toReversed();
        System.out.println("Original array: " + arr);
        System.out.println("Reversed copy: " + reversed);
        // Expected:
        // Original array: [1, 2, 3]
        // Reversed copy: [3, 2, 1]

        // Assert values
        AssertArray.assertArray(reversed, Integer.class, 3, 2, 1);
    }
}