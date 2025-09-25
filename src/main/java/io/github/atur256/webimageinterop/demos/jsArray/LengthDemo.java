package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class LengthDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSArray.length Property Demo ===");

        JSArray arr = JSArray.of(new JSValue[] {
                JSString.of("x"), JSString.of("y"), JSString.of("z")
        });

        System.out.println("Array length: " + arr.length);
        // Expected: Array length: 3
    }
}
