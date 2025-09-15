package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class SymmetricDifferenceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.symmetricDifference Demo ===");

        JSSet setA = new JSSet().add("apple").add("banana");
        JSSet setB = new JSSet().add("banana").add("cherry");

        JSSet result = setA.symmetricDifference(setB);
        System.out.println("Has 'apple'? " + result.has(JSString.of("apple")));
        System.out.println("Has 'banana'? " + result.has(JSString.of("banana")));
        System.out.println("Has 'cherry'? " + result.has(JSString.of("cherry")));
        // Expected Output:
        // Has 'apple'?: true
        // Has 'banana'?: false
        // Has 'cherry'?: true
    }
}
