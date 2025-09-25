package io.github.atur256.webimageinterop.demos.jsIterator;

import io.github.atur256.webimageinterop.builtin.*;
import org.graalvm.webimage.api.JSString;

import java.lang.String;


public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.forEach Demo ===");

        JSArray array = JSArray.of("x", "y", "z");
        JSFunction fun = JSFunction.fromGeneralConsumer((JSString arg) -> System.out.println("Item: " + arg.asString()));
        JSIterator iterator = JSIterator.from(array);

        iterator.forEach(fun);
        // Expected Output: Item: x, Item: y, Item: z
    }
}
