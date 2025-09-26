package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class PopDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.pop Demo ===");

        JSArray arr = JSArray.of(JSString.of("x"), JSString.of("y"));
        String result1 = arr.pop(String.class);
        assertEquals("y", result1);
        System.out.println("Popped: " + result1);
        // Expected: Popped: "y"

        JSArray javaArr = JSArray.of(1, 2, 3);
        int result2 = javaArr.pop(Integer.class);
        assertEquals(3, result2);
        System.out.println("Popped: " + result2);
        // Expected: Popped: 3
    }
}
