package demos.jsSet;

import builtin.JSSet;


public class IntersectionDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.intersection Demo ===");

        JSSet a = new JSSet();
        a.add("apple").add("banana");

        JSSet b = new JSSet();
        b.add("banana").add("cherry");

        JSSet result = a.intersection(b);
        System.out.println("Has 'banana'? " + result.has("banana"));
        System.out.println("Has 'apple'? " + result.has("apple"));
        // Expected Output:
        // Has 'banana'? true
        // Has 'apple'? false
    }
}
