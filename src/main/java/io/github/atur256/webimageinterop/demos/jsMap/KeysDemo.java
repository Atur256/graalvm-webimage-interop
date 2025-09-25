package io.github.atur256.webimageinterop.demos.jsMap;

import io.github.atur256.webimageinterop.builtin.JSIterator;
import io.github.atur256.webimageinterop.builtin.JSMap;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.keys Demo ===");

        JSMap map = new JSMap();
        map.set("foo", "bar");
        map.set("0", "zero");
        map.set(1, "one");

        JSIterator keys = map.keys();
        System.out.println("Keys iterator: " + keys.toArray().toString());
        // Expected: Keys iterator: Keys iterator: [foo,0,1]
    }
}
