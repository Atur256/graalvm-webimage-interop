package demos.jsMap;

import builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class HasDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.has Demo ===");

        JSMap map = new JSMap();
        map.set(JSString.of("exists"), JSString.of("yes"));

        System.out.println("Has 'exists': " + map.has(JSString.of("exists")));
        System.out.println("Has 'missing': " + map.has(JSString.of("missing")));
        // Expected: Has 'exists': true, Has 'missing': false
    }
}
