package demos.jsSet;

import builtin.JSIterator;
import builtin.JSSet;


public class ValuesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.values Demo ===");

        JSSet set = new JSSet().add("apple").add("banana");

        JSIterator values = set.values();
        System.out.println("Values iterator: " + values.toArray().toString());
        // Expected: Values iterator: Values iterator: ["apple","banana"]
    }
}
