package io.github.atur256.webimageinterop.demos.jsMap;

import io.github.atur256.webimageinterop.builtin.JSMap;


public class ClearDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.clear Demo ===");

        JSMap map = new JSMap();
        map.set("key", "value");
        System.out.println("Size before clear: " + map.size);

        map.clear();
        System.out.println("Size after clear: " + map.size);
        // Expected:
        // Size before clear: 1
        // Size after clear: 0
    }
}
