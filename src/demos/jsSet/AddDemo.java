package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class AddDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.add Demo ===");

        JSSet set = new JSSet();
        set.add(JSString.of("apple")).add(JSString.of("banana"));

        System.out.println("Has 'apple'? " + set.has(JSString.of("apple")));
        // Expected Output: Has 'apple'? true
    }
}
