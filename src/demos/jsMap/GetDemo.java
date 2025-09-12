package demos.jsMap;

import builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class GetDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.get Demo ===");

        JSMap map = new JSMap();

        // JSValue key
        map.set(JSString.of("name"), JSString.of("Alice"));
        String name = map.get(JSString.of("name"), String.class);
        System.out.println("Name (JSValue): " + name);
        // Expected: Name (JSValue): Alice

        // int key
        map.set(42, "Answer to everything");
        String answer = map.get(42, String.class);
        System.out.println("Answer (int): " + answer);
        // Expected: Answer (int): Answer to everything

        // double key
        map.set(3.14, "Pi");
        String pi = map.get(3.14, String.class);
        System.out.println("Pi (double): " + pi);
        // Expected: Pi (double): Pi

        // boolean key
        map.set(true, "Yes");
        map.set(false, "No");
        String yes = map.get(true, String.class);
        String no = map.get(false, String.class);
        System.out.println("True (boolean): " + yes);
        System.out.println("False (boolean): " + no);
        // Expected:
        // True (boolean): Yes
        // False (boolean): No

        // Object key
        map.set("customKey", "CustomValue");
        String custom = map.get("customKey", String.class);
        System.out.println("Custom (Object): " + custom);
        // Expected: Custom (Object): CustomValue
    }
}
