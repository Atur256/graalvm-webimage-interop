package demos.jsMap;

import builtin.JSFunction;
import builtin.JSMap;
import org.graalvm.webimage.api.*;


public class SetDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.set Demo ===");

        JSMap map = new JSMap();

        // JSValue key
        map.set(JSString.of("language"), JSString.of("JavaScript"));
        map.set(JSString.of("year"), 1995);
        map.set(JSString.of("version"), 1.8);
        map.set(JSString.of("isPopular"), true);
        map.set(JSString.of("creator"), "Brendan Eich");

        // int key
        map.set(1, JSString.of("one"));
        map.set(2, 200);
        map.set(3, 3.14);
        map.set(4, false);
        map.set(5, "five");

        // double key
        map.set(1.1, JSString.of("pi-ish"));
        map.set(2.2, 220);
        map.set(3.3, 33.33);
        map.set(4.4, true);
        map.set(5.5, "double-key");

        // boolean key
        map.set(true, JSString.of("yes"));
        map.set(false, 0);
        map.set(true, 1.0);
        map.set(false, false);
        map.set(true, "truthy");

        // Object key
        map.set("customKey", JSString.of("customValue"));
        map.set("intKey", 123);
        map.set("doubleKey", 456.789);
        map.set("boolKey", true);
        map.set("objectKey", "objectValue");

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
