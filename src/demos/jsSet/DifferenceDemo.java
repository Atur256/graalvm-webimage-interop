package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class DifferenceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.difference Demo ===");

        JSSet a = new JSSet();
        a.add(JSString.of("apple")).add(JSString.of("banana"));

        JSSet b = new JSSet();
        b.add(JSString.of("banana"));

        JSSet diff = a.difference(b);
        System.out.println("Has 'apple'? " + diff.has(JSString.of("apple")));
        // Expected Output: Has 'apple'? true
        System.out.println("Has 'banana'? " + diff.has(JSString.of("banana")));
        // Expected Output: Has 'banana'? false
    }
}
