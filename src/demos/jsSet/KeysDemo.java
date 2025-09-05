package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.keys Demo ===");

        JSSet set = new JSSet();
        set.add(JSString.of("apple")).add(JSString.of("banana"));

        System.out.println("Entries object: " + set.keys());
        // Expected: JS iterable object (not yet wrapped as Iterator)
    }
}
