package demos.jsMap;

import builtin.JSIterator;
import builtin.JSMap;


public class EntriesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.entries Demo ===");

        JSMap map = new JSMap();
        map.set("a", 1);
        map.set("b", 2);


        JSIterator entries = map.entries();
        System.out.println("Entries iterator: " + entries.toArray().toString());
        // Expected: Entries iterator: [a,1,b,2]
    }
}
