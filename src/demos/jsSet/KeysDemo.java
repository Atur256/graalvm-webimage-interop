package demos.jsSet;

import builtin.JSIterator;
import builtin.JSSet;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.keys Demo ===");

        JSSet set = new JSSet().add("apple").add("banana").add("cherry");

        JSIterator keys = set.keys();
        System.out.println("Keys iterator: " + keys.toArray().toString());
        // Expected: Keys iterator: ["apple","banana","cherry"]
    }
}
