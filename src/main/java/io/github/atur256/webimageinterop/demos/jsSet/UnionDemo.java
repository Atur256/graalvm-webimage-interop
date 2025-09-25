package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class UnionDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSetunion Demo ===");

        JSSet setA = new JSSet().add("apple").add("banana");
        JSSet setB = new JSSet().add("banana").add("cherry");

        JSSet union = setA.union(setB);
        System.out.println("Has 'apple'?: " + union.has(JSString.of("apple")));
        System.out.println("Has 'banana'?: " + union.has(JSString.of("banana")));
        System.out.println("Has 'cherry'?: " + union.has(JSString.of("cherry")));
        System.out.println("Has 'peach'?: " + union.has(JSString.of("peach")));
        // Expected Output:
        // Has 'apple'?: true
        // Has 'banana'?: true
        // Has 'cherry'?: true
        // Has 'peach'?: false
    }
}
