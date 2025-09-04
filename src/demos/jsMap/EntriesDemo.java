package demos.jsMap;

import builtin.JSMap;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;


public class EntriesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.entries Demo ===");

        JSMap map = new JSMap();
        map.set(JSString.of("a"), JSNumber.of(1));
        map.set(JSString.of("b"), JSNumber.of(2));

        System.out.println("Entries object: " + map.entries());
        // Expected: JS iterable object (not yet wrapped as Iterator)
    }
}
