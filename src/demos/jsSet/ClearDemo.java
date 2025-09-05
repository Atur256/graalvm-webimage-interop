package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class ClearDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.clear Demo ===");

        JSSet set = new JSSet();
        set.add(JSString.of("apple"));
        set.clear();

        System.out.println("Has 'apple'? " + set.has(JSString.of("apple")));
        // Expected Output: Has 'apple'? false
    }
}
