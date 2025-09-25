package io.github.atur256.webimageinterop.demos.jsIterator;

import io.github.atur256.webimageinterop.builtin.*;
import org.graalvm.webimage.api.JSNumber;

import java.lang.String;


public class MapDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.map Demo ===");

        JSArray array = JSArray.of(1, 2, 3);
        JSFunction fun = JSFunction.fromGeneralFunction((JSNumber arg) -> arg.as(Integer.class) * 10);
        JSIterator iterator = JSIterator.from(array).map(fun);

        System.out.println("Mapped to x * 10: " + iterator.toArray());
        // Expected Output: Mapped to x * 10: [10, 20, 30]
    }
}
