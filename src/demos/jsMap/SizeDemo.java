package demos.jsMap;

import builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class SizeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.size Demo ===");

        JSMap map = new JSMap();
        map.set(JSString.of("a"), JSString.of("1"));
        map.set(JSString.of("b"), JSString.of("2"));

        System.out.println("Size: " + map.size());
        // Expected: Size: 2
    }
}
