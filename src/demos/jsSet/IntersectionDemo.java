package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class IntersectionDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.intersection Demo ===");

        JSSet a = new JSSet();
        a.add(JSString.of("apple")).add(JSString.of("banana"));

        JSSet b = new JSSet();
        b.add(JSString.of("banana")).add(JSString.of("cherry"));

        JSSet result = a.intersection(b);
        System.out.println("Has 'banana'? " + result.has(JSString.of("banana")));
        // Expected Output: Has 'banana'? true
        System.out.println("Has 'apple'? " + result.has(JSString.of("apple")));
        // Expected Output: Has 'apple'? false
    }
}
