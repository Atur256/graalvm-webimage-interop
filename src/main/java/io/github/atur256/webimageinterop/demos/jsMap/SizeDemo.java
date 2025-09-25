package io.github.atur256.webimageinterop.demos.jsMap;

import io.github.atur256.webimageinterop.builtin.JSMap;


public class SizeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.size Demo ===");

        JSMap map = new JSMap();
        map.set("a", "1");
        map.set("b", "2");

        System.out.println("Size: " + map.size);
        // Expected: Size: 2
    }
}
