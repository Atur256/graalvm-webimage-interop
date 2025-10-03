package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.JSNumber;


public class ReverseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reverse Demo ===");

        JSArray arr1 = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        arr1.reverse();
        System.out.println("Reversed: " + arr1);
        // Expected: Reversed: [3, 2, 1]

        JSArray arr2 = JSArray.of("apple", "banana", "orange");
        arr2.reverse();
        System.out.println("Reversed: " + arr2);
        // Expected: Reversed: [orange,banana,apple]

        // Assert values
        AssertArray.assertArray(arr1, Integer.class, 3, 2, 1);
        AssertArray.assertArray(arr2, String.class, "orange", "banana", "apple");
    }
}