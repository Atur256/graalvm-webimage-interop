package demos.jsMap;

import builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class DeleteDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.delete Demo ===");

        JSMap map = new JSMap();
        map.set(JSString.of("temp"), JSString.of("value"));

        boolean deleted = map.delete(JSString.of("temp"));
        System.out.println("Deleted: " + deleted);
        System.out.println("Has 'temp': " + map.has(JSString.of("temp")));
        // Expected: Deleted: true, Has 'temp': false
    }
}
