package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class EntriesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.entries Demo ===");

        JSSet set = new JSSet();
        set.add(JSString.of("apple")).add(JSString.of("banana"));

        System.out.println("Entries object: " + set.entries());
        // Expected: JS iterable object (not yet wrapped as Iterator)
    }
}
