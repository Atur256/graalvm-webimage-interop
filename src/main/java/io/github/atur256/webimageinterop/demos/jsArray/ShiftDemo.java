package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;


public class ShiftDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.shift Demo ===");

        JSArray arr = JSArray.of(JSString.of("first"), JSString.of("second"));
        String shifted1 = arr.shift(String.class);
        System.out.println("Shifted: " + shifted1);
        // Expected: Shifted: "first"

        JSArray javaArr = JSArray.of(1, 2, 3);
        int shifted2 = javaArr.shift(Integer.class);
        System.out.println("Shifted: " + shifted2);
        // Expected: Shifted: 1
    }
}
