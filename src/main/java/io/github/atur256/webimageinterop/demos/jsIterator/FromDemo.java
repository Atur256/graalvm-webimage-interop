package io.github.atur256.webimageinterop.demos.jsIterator;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;


public class FromDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.from Demo ===");

        JSArray array = JSArray.of("apple","banana","cherry");

        JSIterator iterator = JSIterator.from(array);
        System.out.println("Converted to iterator, toArray(): " + iterator.toArray());
        // Expected Output:
        // Converted to iterator, toArray(): ["apple", "banana", "cherry"]
    }
}
