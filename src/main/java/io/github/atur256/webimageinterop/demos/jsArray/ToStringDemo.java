package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toStringJS Demo ===");

        JSArray arr = JSArray.of("apple", "banana", "cherry");

        String result = arr.toString();
        System.out.println("Array as string: " + result);
        // Expected: Array as string: ["apple","banana","cherry"]
    }
}
