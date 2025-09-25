package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSIterator;
import io.github.atur256.webimageinterop.builtin.JSSet;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.keys Demo ===");

        JSSet set = new JSSet().add("apple").add("banana").add("cherry");

        JSIterator keys = set.keys();
        System.out.println("Keys iterator: " + keys.toArray().toString());
        // Expected: Keys iterator: ["apple","banana","cherry"]
    }
}
