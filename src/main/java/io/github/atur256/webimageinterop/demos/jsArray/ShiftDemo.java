package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class ShiftDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.shift Demo ===");

        JSArray arr = JSArray.of(JSString.of("first"), JSString.of("second"));
        String result1 = arr.shift(String.class);
        assertEquals("first", result1);
        System.out.println("Shifted: " + result1);
        // Expected: Shifted: "first"

        JSArray javaArr = JSArray.of(1, 2, 3);
        int result2 = javaArr.shift(Integer.class);
        assertEquals(1, result2);
        System.out.println("Shifted: " + result2);
        // Expected: Shifted: 1
    }
}
