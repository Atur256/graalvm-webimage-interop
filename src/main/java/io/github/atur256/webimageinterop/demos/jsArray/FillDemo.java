package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;


public class FillDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.fill Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        arr.fill(JSNumber.of(0), 1, 3);
        System.out.println("After fill: " + arr);
        // Expected: After fill: [1, 0, 0]

        JSArray javaArr1 = JSArray.of(1, 2, 3);
        javaArr1.fill(0, 1, 3);
        System.out.println("After fill: " + javaArr1);
        // Expected: After fill: [1, 0, 0]

        JSArray javaArr2 = JSArray.of(1.1, 2.2, 3.3, 4.4);
        javaArr2.fill(11.1, 1, 2);
        System.out.println("After fill: " + javaArr2);
        // Expected: After fill: [1.1, 11.1, 3.3, 4.4]

        JSArray javaArr3 = JSArray.of(true, true, true, true);
        javaArr3.fill(false, 0, 1);
        System.out.println("After fill: " + javaArr3);
        // Expected: After fill: [false,true,true,true]

        JSArray javaArr4 = JSArray.of("apple", "banana", "orange");
        javaArr4.fill("peach", 1, 2);
        System.out.println("After fill: " + javaArr4);
        // Expected: After fill: [apple,peach,orange]
    }
}
