package demos.jsMap;

import builtin.JSMap;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;


public class ValuesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.values Demo ===");

        JSMap map = new JSMap();
        map.set(JSString.of("one"), JSNumber.of(1));
        map.set(JSString.of("two"), JSNumber.of(2));

        System.out.println("Values object: " + map.values());
        // Expected: JS iterable object (not yet wrapped as Iterator)
    }
}
