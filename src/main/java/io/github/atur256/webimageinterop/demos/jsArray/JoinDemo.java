package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class JoinDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.join Demo ===");

        JSArray arr = JSArray.of(JSString.of("apple"), JSString.of("banana"));
        String result1 = arr.join(", ");
        System.out.println("Joined: " + result1);
        // Expected: Joined: "apple", "banana"

        JSArray javaArr1 = JSArray.of("apple", "banana", "orange");
        String result2 = javaArr1.join(", ");
        System.out.println("Joined: " + result2);
        // Expected: Joined: "apple", "banana", "orange"

        JSArray javaArr2 = JSArray.of(1, 2, 3, 4, 5, 6);
        String result3 = javaArr2.join(" | ");
        System.out.println("Joined: " + result3);
        // Expected: Joined: 1 | 2 | 3 | 4 | 5 | 6

        // Assert values
        assertEquals("apple, banana", result1);
        assertEquals("apple, banana, orange", result2);
        assertEquals("1 | 2 | 3 | 4 | 5 | 6", result3);
    }
}