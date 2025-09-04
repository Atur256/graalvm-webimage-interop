package demos.jsMap;

import builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.keys Demo ===");

        JSMap map = new JSMap();
        map.set(JSString.of("foo"), JSString.of("bar"));

        System.out.println("Keys object: " + map.keys());
        // Expected: JS iterable object (not yet wrapped as Iterator)
    }
}
