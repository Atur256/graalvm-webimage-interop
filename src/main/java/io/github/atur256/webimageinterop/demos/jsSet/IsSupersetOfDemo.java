package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSSet;


public class IsSupersetOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.isSupersetOf Demo ===");

        JSSet a = new JSSet().add("apple").add("banana");
        JSSet b = new JSSet().add("apple");
        JSSet c = new JSSet().add("orange").add("banana");

        boolean aIsSupersetOfb = a.isSupersetOf(b);
        boolean bIsSupersetOfa = b.isSupersetOf(a);
        boolean aIsSupersetOfc = a.isSupersetOf(c);
        System.out.println("Set a is superset of set b?: " + aIsSupersetOfb);
        System.out.println("Set b is superset of set a?: " + bIsSupersetOfa);
        System.out.println("Set a is superset of set c?: " + aIsSupersetOfc);
        // Expected Output:
        // Set a is superset of set b?: true
        // Set b is superset of set a?: false
        // Set a is superset of set c?: false
    }
}
