package demos.jsArray;

import builtin.JSArray;
import builtin.JSIterator;


public class ValuesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.values Demo ===");

        JSArray arr = JSArray.of(10, 20);

        JSIterator values = arr.values();
        System.out.println("Values iterator: " + values.toArray().toString());
        // Expected: Values iterator: [10,20]
    }
}
