package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;


public class CopyWithinDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.copyWithin Demo ===");

        JSArray arr = JSArray.of(1, 2, 3, 4);
        arr.copyWithin(0, 2, 4);
        System.out.println("After copyWithin: " + arr);
        // Expected: After copyWithin: [3, 4, 3, 4]
    }
}
