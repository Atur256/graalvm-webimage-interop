package io.github.atur256.webimageinterop.demos.jsIterator;

import io.github.atur256.webimageinterop.builtin.*;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;

import java.lang.String;


public class EveryDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.every Demo ===");

        JSIterator iterator1 = JSIterator.from(JSArray.of(2, 4, 6));
        JSIterator iterator2 = JSIterator.from(JSArray.of(2, 3, 6));
        JSFunction isEven = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) % 2 == 0));

        boolean allEven1 = iterator1.every(isEven);
        System.out.println("All elements are even: " + allEven1);
        // Expected Output: All elements are even: true

        boolean allEven2 = iterator2.every(isEven);
        System.out.println("All elements are even: " + allEven2);
        // Expected Output: All elements are even: false
    }
}
