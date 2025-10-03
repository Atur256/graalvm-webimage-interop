package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.JSNumber;


public class WithDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.with Demo ===");

        JSArray arr1 = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));

        JSArray updated1 = arr1.with(1, JSNumber.of(99));
        System.out.println("Original array: " + arr1);
        System.out.println("Updated copy: " + updated1);
        // Expected:
        // Original array: [1,2,3]
        // Updated copy: [1,99,3]

        JSArray arr2 = JSArray.of(2, 4, 10);
        JSArray updated2 = arr2.with(0, 3);
        System.out.println("Original array: " + arr2);
        System.out.println("Updated copy: " + updated2);
        // Expected:
        // Original array: [2,4,10]
        // Updated copy: [3,4,10]

        JSArray arr3 = JSArray.of(1.4, 2.6, 5.6, 7.0);
        JSArray updated3 = arr3.with(3, 11.45);
        System.out.println("Original array: " + arr3);
        System.out.println("Updated copy: " + updated3);
        // Expected:
        // Original array: [1.4,2.6,5.6,7.0]
        // Updated copy: [1.4,2.6,5.6,11.45]

        JSArray arr4 = JSArray.of("apple", "banana", "orange");
        JSArray updated4 = arr4.with(1, "pear");
        System.out.println("Original array: " + arr4);
        System.out.println("Updated copy: " + updated4);
        // Expected:
        // Original array: [apple,banana,orange]
        // Updated copy: [apple,pear,orange]

        JSArray arr5 = JSArray.of(true, false, true, false);
        JSArray updated5 = arr5.with(3, true);
        System.out.println("Original array: " + arr5);
        System.out.println("Updated javaUpdated4: " + updated5);
        // Expected:
        // Original array: [true,false,true,false]
        // Updated javaUpdated4: [true,false,true,true]

        // Assert values
        AssertArray.assertArray(updated1, Integer.class, 1, 99, 3);
        AssertArray.assertArray(updated2, Integer.class, 3, 4, 10);
        AssertArray.assertArray(updated3, Double.class, 1.4, 2.6, 5.6, 11.45);
        AssertArray.assertArray(updated4, String.class, "apple", "pear", "orange");
        AssertArray.assertArray(updated5, Boolean.class, true, false, true, true);
    }
}