package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class HasDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.has Demo ===");

        JSSet set = new JSSet();
        set.add(JSString.of("cherry"));

        System.out.println("Has 'cherry'? " + set.has(JSString.of("cherry")));
        // Expected Output: Has 'cherry'? true
    }
}
