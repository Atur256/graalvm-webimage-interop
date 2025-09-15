package demos.jsSet;

import builtin.JSSet;


public class SizeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.size Demo ===");

        JSSet set = new JSSet();

        System.out.println("Initial size: " + set.size);
        set.add("apple");
        System.out.println("Size after adding 'apple': " + set.size);
        set.add("banana");
        System.out.println("Size after adding 'banana': " + set.size);
        set.add("apple"); // duplicate
        System.out.println("Size after adding duplicate 'apple': " + set.size);
        // Expected:
        // Initial size: 0
        // Size after adding 'apple': 1
        // Size after adding 'banana': 2
        // Size after adding duplicate 'apple': 2
    }
}
