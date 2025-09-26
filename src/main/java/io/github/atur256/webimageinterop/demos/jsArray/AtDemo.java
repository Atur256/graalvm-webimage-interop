package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class AtDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.at Demo ===");

        JSArray arr = JSArray.of(JSString.of("a"), JSString.of("b"), JSString.of("c"));
        String result1 = arr.at(-1, String.class);
        assertEquals("c", result1);
        System.out.println("Element at index -1: " + result1);
        // Expected: Element at index -1: "c"

        JSArray scoreArr = JSArray.of(10, 20, 30);
        int result2 = scoreArr.at(0, Integer.class);
        assertEquals(10, result2);
        System.out.println("Element at index 0: " + result2);
        // Expected: Element at index 0: 10

        JSArray stringArr = JSArray.of("apple", "banana", "cherry");
        String result3 = stringArr.at(2, String.class);
        assertEquals("cherry", result3);
        System.out.println("Element at index 2: " + result3);
        // Expected: Element at index 2: "cherry"
    }
}
