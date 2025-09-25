package io.github.atur256.webimageinterop.demos.jsIterator;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;


public class ToArrayDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.toArray Demo ===");

        JSArray array = JSArray.of("red", "green", "blue");
        JSIterator iterator = JSIterator.from(array);

        JSArray resultArray = iterator.toArray();
        System.out.println("Converted iterator to array: " + resultArray);
        // Expected Output: Converted iterator to array: ["red","green","blue"]
    }
}
