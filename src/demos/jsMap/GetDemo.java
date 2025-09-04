package demos.jsMap;

import builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class GetDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.get Demo ===");

        JSMap map = new JSMap();
        map.set(JSString.of("name"), JSString.of("Alice"));

        System.out.println("Name: " + map.get(JSString.of("name")));
        // Expected: Name: Alice
    }
}
