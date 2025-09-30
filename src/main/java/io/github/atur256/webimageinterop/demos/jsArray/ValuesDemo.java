package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;
import io.github.atur256.webimageinterop.demos.AssertArray;


public class ValuesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.values Demo ===");

        JSArray arr = JSArray.of(10, 20);

        JSIterator values = arr.values();
        JSArray result = values.toArray();
        System.out.println("Values iterator: " + result.toString());
        // Expected: Values iterator: [10,20]

        // Assert values
        AssertArray.assertArray(result, Integer.class, 10, 20);
    }
}