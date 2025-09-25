package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSSet;


public class IsDisjointFromDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.isDisjointFrom Demo ===");

        JSSet a = new JSSet().add("apple").add("orange");
        JSSet b = new JSSet().add("banana").add("cherry");
        JSSet c = new JSSet().add("orange").add("peach");

        boolean abDisjoint = a.isDisjointFrom(b);
        boolean bcDisjoint = b.isDisjointFrom(c);
        boolean acDisjoint = a.isDisjointFrom(c);
        System.out.println("Set a and b disjoint?: " + abDisjoint);
        System.out.println("Set b and c disjoint?: " + bcDisjoint);
        System.out.println("Set a and c disjoint?: " + acDisjoint);
        // Expected Output:
        // Set a and b disjoint?: true
        // Set b and c disjoint?: true
        // Set a and c disjoint?: false
    }
}
