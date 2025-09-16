package demos.jsMap;

import builtin.JSIterator;
import builtin.JSMap;


public class ValuesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.values Demo ===");

        JSMap map = new JSMap().set("one", 1).set("two", 2);

        JSIterator values = map.values();
        System.out.println("Values iterator: " + values.toArray().toString());
        // Expected: Values iterator: Values iterator: [1,2]
    }
}
