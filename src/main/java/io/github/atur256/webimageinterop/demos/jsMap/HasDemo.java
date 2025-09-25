package io.github.atur256.webimageinterop.demos.jsMap;

import io.github.atur256.webimageinterop.builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class HasDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.has Demo ===");

        JSMap map = new JSMap();

        // JSValue key
        map.set(JSString.of("exists"), JSString.of("yes"));
        System.out.println("Has (JSValue) 'exists': " + map.has(JSString.of("exists")));
        System.out.println("Has (JSValue) 'missing': " + map.has(JSString.of("missing")));
        // Expected:
        // Has (JSValue) 'exists': true
        // Has (JSValue) 'missing': false

        // int key
        map.set(42, "int-value");
        System.out.println("Has (int) 42: " + map.has(42));
        System.out.println("Has (int) 99: " + map.has(99));
        // Expected:
        // Has (int) 42: true
        // Has (int) 99: false

        // double key
        map.set(3.14, "pi-value");
        System.out.println("Has (double) 3.14: " + map.has(3.14));
        System.out.println("Has (double) 2.71: " + map.has(2.71));
        // Expected:
        // Has (double) 3.14: true
        // Has (double) 2.71: false

        // boolean key
        map.set(true, "truthy");
        map.set(false, "falsy");
        System.out.println("Has (boolean) true: " + map.has(true));
        System.out.println("Has (boolean) false: " + map.has(false));
        System.out.println("Has (boolean) !true: " + map.has(false));
        // Expected:
        // Has (boolean) true: true
        // Has (boolean) false: true
        // Has (boolean) !true: true

        // Object key
        map.set("customKey", "customValue");
        System.out.println("Has (Object) 'customKey': " + map.has("customKey"));
        System.out.println("Has (Object) 'unknownKey': " + map.has("unknownKey"));
        // Expected:
        // Has (Object) 'customKey': true
        // Has (Object) 'unknownKey': false
    }
}
