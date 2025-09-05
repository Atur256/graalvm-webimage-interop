package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class SymmetricDifferenceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.symmetricDifference Demo ===");

        JSSet setA = new JSSet();
        setA.add(JSString.of("apple")).add(JSString.of("banana"));

        JSSet setB = new JSSet();
        setB.add(JSString.of("banana")).add(JSString.of("cherry"));

        JSSet result = setA.symmetricDifference(setB);

        System.out.println("Has 'apple'? " + result.has(JSString.of("apple")));
        // Expected Output: Has 'apple'? true

        System.out.println("Has 'banana'? " + result.has(JSString.of("banana")));
        // Expected Output: Has 'banana'? false

        System.out.println("Has 'cherry'? " + result.has(JSString.of("cherry")));
        // Expected Output: Has 'cherry'? true
    }
}
