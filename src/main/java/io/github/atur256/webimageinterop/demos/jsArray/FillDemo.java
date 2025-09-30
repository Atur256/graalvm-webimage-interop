package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.JSNumber;


public class FillDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.fill Demo ===");

        JSArray arr1 = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        arr1.fill(JSNumber.of(0), 1, 3);
        System.out.println("After fill: " + arr1);
        // Expected: After fill: [1, 0, 0]

        JSArray arr2 = JSArray.of(1, 2, 3);
        arr2.fill(0, 1, 3);
        System.out.println("After fill: " + arr2);
        // Expected: After fill: [1, 0, 0]

        JSArray arr3 = JSArray.of(1.1, 2.2, 3.3, 4.4);
        arr3.fill(11.1, 1, 2);
        System.out.println("After fill: " + arr3);
        // Expected: After fill: [1.1, 11.1, 3.3, 4.4]

        JSArray arr4 = JSArray.of(true, true, true, true);
        arr4.fill(false, 0, 1);
        System.out.println("After fill: " + arr4);
        // Expected: After fill: [false,true,true,true]

        JSArray arr5 = JSArray.of("apple", "banana", "orange");
        arr5.fill("peach", 1, 2);
        System.out.println("After fill: " + arr5);
        // Expected: After fill: [apple,peach,orange]

        // Assert values
        AssertArray.assertArray(arr1, Integer.class, 1, 0, 0);
        AssertArray.assertArray(arr2, Integer.class, 1, 0, 0);
        AssertArray.assertArray(arr3, Double.class, 1.1, 11.1, 3.3, 4.4);
        AssertArray.assertArray(arr4, Boolean.class, false, true, true, true);
        AssertArray.assertArray(arr5, String.class, "apple", "peach", "orange");
    }
}