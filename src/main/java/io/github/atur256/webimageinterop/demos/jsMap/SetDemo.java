package io.github.atur256.webimageinterop.demos.jsMap;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.builtin.JSMap;
import org.graalvm.webimage.api.*;


public class SetDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.set Demo ===");

        JSMap map = new JSMap();

        // JSValue key
        map
                .set(JSString.of("language"), JSString.of("JavaScript"))
                .set(JSString.of("year"), 1995)
                .set(JSString.of("version"), 1.8)
                .set(JSString.of("isPopular"), true)
                .set(JSString.of("creator"), "Brendan Eich");

        // int key
        map
                .set(1, JSString.of("one"))
                .set(2, 200)
                .set(3, 3.14)
                .set(4, false)
                .set(5, "five");

        // double key
        map
                .set(1.1, JSString.of("pi-ish"))
                .set(2.2, 220)
                .set(3.3, 33.33)
                .set(4.4, true)
                .set(5.5, "double-key");

        // boolean key
        map
                .set(true, JSString.of("yes"))
                .set(false, 0)
                .set(true, 1.0)
                .set(false, false)
                .set(true, "truthy");

        // Object key
        map
                .set("customKey", JSString.of("customValue"))
                .set("intKey", 123)
                .set("doubleKey", 456.789)
                .set("boolKey", true)
                .set("objectKey", "objectValue");

        JSFunction printFun = JSFunction.fromGeneralBiConsumer((JSValue value, JSValue key) -> System.out.println(key + ": " + value));

        map.forEach(printFun);
        // Expected Output:
        // JavaScript<string; language>: JavaScript<string; JavaScript>
        // JavaScript<string; year>: JavaScript<number; 1995.0>
        // JavaScript<string; version>: JavaScript<number; 1.8>
        // JavaScript<string; isPopular>: JavaScript<boolean; true>
        // JavaScript<string; creator>: JavaScript<string; Brendan Eich>
        // JavaScript<number; 1.0>: JavaScript<string; one>
        // JavaScript<number; 2.0>: JavaScript<number; 200.0>
        // JavaScript<number; 3.0>: JavaScript<number; 3.14>
        // JavaScript<number; 4.0>: JavaScript<boolean; false>
        // JavaScript<number; 5.0>: JavaScript<string; five>
        // JavaScript<number; 1.1>: JavaScript<string; pi-ish>
        // JavaScript<number; 2.2>: JavaScript<number; 220.0>
        // JavaScript<number; 3.3>: JavaScript<number; 33.33>
        // JavaScript<number; 4.4>: JavaScript<boolean; true>
        // JavaScript<number; 5.5>: JavaScript<string; double-key>
        // JavaScript<boolean; true>: JavaScript<string; truthy>
        // JavaScript<boolean; false>: JavaScript<boolean; false>
        // JavaScript<string; customKey>: JavaScript<string; customValue>
        // JavaScript<string; intKey>: JavaScript<number; 123.0>
        // JavaScript<string; doubleKey>: JavaScript<number; 456.789>
        // JavaScript<string; boolKey>: JavaScript<boolean; true>
        // JavaScript<string; objectKey>: JavaScript<string; objectValue>
    }
}
