package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class SizeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.size Demo ===");

        JSSet set = new JSSet();
        System.out.println("Initial size: " + set.size);
        // Expected Output: Initial size: 0

        set.add(JSString.of("apple"));
        System.out.println("Size after adding 'apple': " + set.size);
        // Expected Output: Size after adding 'apple': 1

        set.add(JSString.of("banana"));
        System.out.println("Size after adding 'banana': " + set.size);
        // Expected Output: Size after adding 'banana': 2

        set.add(JSString.of("apple")); // duplicate
        System.out.println("Size after adding duplicate 'apple': " + set.size);
        // Expected Output: Size after adding duplicate 'apple': 2
    }
}
