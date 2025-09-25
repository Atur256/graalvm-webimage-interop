package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSSet;


public class IsSubsetOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.isSubsetOf Demo ===");

        JSSet a = new JSSet().add("apple");
        JSSet b = new JSSet().add("apple").add("banana");
        JSSet c = new JSSet().add("orange");

        boolean aIsSubsetOfb = a.isSubsetOf(b);
        boolean bIsSubsetOfa = b.isSubsetOf(a);
        boolean aIsSubsetOfc = a.isSubsetOf(c);
        System.out.println("Set a is subset of set b?: " + aIsSubsetOfb);
        System.out.println("Set b is subset of set a?: " + bIsSubsetOfa);
        System.out.println("Set a is subset of set c?: " + aIsSubsetOfc);
        // Expected Output:
        // Set a is subset of set b?: true
        // Set b is subset of set a?: false
        // Set a is subset of set c?: false
    }
}
