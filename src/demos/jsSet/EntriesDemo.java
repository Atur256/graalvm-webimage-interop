package demos.jsSet;

import builtin.JSIterator;
import builtin.JSSet;


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
