package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSIterator;
import io.github.atur256.webimageinterop.builtin.JSSet;


public class ValuesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.values Demo ===");

        JSSet set = new JSSet().add("apple").add("banana");

        JSIterator values = set.values();
        System.out.println("Values iterator: " + values.toArray().toString());
        // Expected: Values iterator: Values iterator: ["apple","banana"]
    }
}
