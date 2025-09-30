package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertTrue;


public class EveryDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Array.every Demo ===");

        JSArray arr = JSArray.of(2, 4, 6);
        JSFunction isEven = JSFunction.fromGeneralFunction((JSNumber value) ->
                JSBoolean.of(value.as(Integer.class) % 2 == 0));
        boolean result = arr.every(isEven);
        System.out.println("All even: " + result);
        // Expected: All even: true

        // Assert values
        assertTrue(result);
    }
}