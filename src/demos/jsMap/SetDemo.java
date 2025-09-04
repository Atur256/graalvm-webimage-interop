package demos.jsMap;

import builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class SetDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.set Demo ===");

        JSMap map = new JSMap();
        map.set(JSString.of("language"), JSString.of("JavaScript"));

        System.out.println("Language: " + map.get(JSString.of("language")));
        // Expected: Language: JavaScript
    }
}
