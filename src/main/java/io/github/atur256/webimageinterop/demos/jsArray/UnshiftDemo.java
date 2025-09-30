package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class UnshiftDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.unshift Demo ===");

        JSArray arr1 = JSArray.of(JSString.of("b"));
        int newLength1 = arr1.unshift(JSString.of("a"));
        System.out.println("After unshift: " + arr1 + " with length: " + newLength1);
        // Expected: After unshift: ["a", "b"] with length: 2

        JSArray arr2 = JSArray.of(1, 2, 3);
        int newLength2 = arr2.unshift(4);
        System.out.println("After unshift: " + arr2 + " with length: " + newLength2);
        // Expected: After unshift: [4, 1, 2, 3] with length: 4

        JSArray arr3 = JSArray.of(1.1, 2.2, 3.3);
        int newLength3 = arr3.unshift(4.4);
        System.out.println("After unshift: " + arr3 + " with length: " + newLength3);
        // Expected: After unshift: [4.4, 1.1, 2.2, 3.3] with length: 4

        JSArray arr4 = JSArray.of(true, true, true, true);
        int newLength4 = arr4.unshift(false);
        System.out.println("After unshift: " + arr4 + " with length: " + newLength4);
        // Expected: After unshift: [false, true, true, true, true] with length: 5

        JSArray arr5 = JSArray.of("apple", "banana", "orange");
        int newLength5 = arr5.unshift("pear");
        System.out.println("After unshift: " + arr5 + " with length: " + newLength5);
        // Expected: After unshift: ["pear", "apple", "banana", "orange"] with length: 4

        // Assert values
        assertEquals(2, newLength1);
        AssertArray.assertArray(arr1, String.class, "a", "b");
        assertEquals(4, newLength2);
        AssertArray.assertArray(arr2, Integer.class, 4, 1, 2, 3);
        assertEquals(4, newLength3);
        AssertArray.assertArray(arr3, Double.class, 4.4, 1.1, 2.2, 3.3);
        assertEquals(5, newLength4);
        AssertArray.assertArray(arr4, Boolean.class, false, true, true, true, true);
        assertEquals(4, newLength5);
        AssertArray.assertArray(arr5, String.class, "pear", "apple", "banana", "orange");
    }
}