package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;


public class AtDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.at Demo ===");

        JSArray arr = JSArray.of(JSString.of("a"), JSString.of("b"), JSString.of("c"));
        System.out.println("Element at index -1: " + arr.at(-1, String.class));
        // Expected: Element at index -1: "c"

        JSArray scoreArr = JSArray.of(10, 20, 30);
        System.out.println("Element at index 0: " + scoreArr.at(0, Integer.class));
        // Expected: Element at index 0: 10

        JSArray stringArr = JSArray.of("apple","banana","cherry");
        System.out.println("Element at index 2: " + stringArr.at(2, String.class));
        // Expected: Element at index 2: "cherry"
    }
}
