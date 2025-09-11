package demos.jsIterator;

import builtin.*;

import java.lang.String;


public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.forEach Demo ===");

        JSArray array = JSArray.of("x", "y", "z");
        JSFunction fun = JSFunction.fromGeneralConsumer((String arg) -> System.out.println("Item: " + arg));
        JSIterator iterator = JSIterator.from(array);

        iterator.forEach(fun);
        // Expected Output: Item: x, Item: y, Item: z
    }
}
