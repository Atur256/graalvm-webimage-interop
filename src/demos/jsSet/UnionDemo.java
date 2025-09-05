package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class UnionDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSetunion Demo ===");

        JSSet setA = new JSSet();
        setA.add(JSString.of("apple")).add(JSString.of("banana"));

        JSSet setB = new JSSet();
        setB.add(JSString.of("banana")).add(JSString.of("cherry"));

        JSSet union = setA.union(setB);

        System.out.println("Has 'apple'? " + union.has(JSString.of("apple")));
        // Expected Output: Has 'apple'? true

        System.out.println("Has 'banana'? " + union.has(JSString.of("banana")));
        // Expected Output: Has 'banana'? true

        System.out.println("Has 'cherry'? " + union.has(JSString.of("cherry")));
        // Expected Output: Has 'cherry'? true
    }
}
