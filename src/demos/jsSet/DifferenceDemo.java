package demos.jsSet;

import builtin.JSSet;


public class DifferenceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.difference Demo ===");

        JSSet a = new JSSet();
        a.add("apple").add("banana");

        JSSet b = new JSSet();
        b.add("banana");

        JSSet diff = a.difference(b);
        System.out.println("Has 'apple'?: " + diff.has("apple"));
        System.out.println("Has 'banana'?: " + diff.has("banana"));
        // Expected Output:
        // Has 'apple'?: true
        // Has 'banana'?: false
    }
}
