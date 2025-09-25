package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSIterator;
import io.github.atur256.webimageinterop.builtin.JSSet;


public class EntriesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.entries Demo ===");

        JSSet set = new JSSet();
        set.add("apple").add("banana");

        JSIterator entries = set.entries();
        System.out.println("Entries iterator: " + entries.toArray().toString());
        // Expected: Entries iterator: ["apple","apple","banana","banana"]
    }
}
