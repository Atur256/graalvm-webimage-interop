package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class LastIndexOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.lastIndexOf Demo ===");

        JSArray arr1 = JSArray.of(JSString.of("a"), JSString.of("b"), JSString.of("a"));
        int index1 = arr1.lastIndexOf(JSString.of("a"));
        System.out.println("Last index of 'a': " + index1);
        // Expected: Last index of 'a': 2

        JSArray arr2 = JSArray.of("a", "b", "a");
        int index2 = arr2.lastIndexOf("a");
        System.out.println("Last index of 'a': " + index2);
        // Expected: Last index of 'a': 2

        JSArray arr3 = JSArray.of(1, 2, 1, 4, 6, 12, 3, 6, 3, 2);
        int index3 = arr3.lastIndexOf(3);
        System.out.println("Last index of '3': " + index3);
        int index4 = arr3.lastIndexOf(10);
        System.out.println("Last index of '10': " + index4);
        // Expected:
        // Last index of '3': 8
        // Last index of '10': -1

        JSArray arr4 = JSArray.of(1.3, 5.6, 1.3, 6.7, 3.2);
        int index5 = arr4.lastIndexOf(1.3);
        System.out.println("Last index of '1.3': " + index5);
        // Expected: Last index of '1.3': 2

        JSArray arr5 = JSArray.of(true, true, false);
        int index6 = arr5.lastIndexOf(true);
        System.out.println("Last index of 'true': " + index6);
        // Expected: Last index of 'true': 1

        // Assert values
        assertEquals(2, index1);
        assertEquals(2, index2);
        assertEquals(8, index3);
        assertEquals(-1, index4);
        assertEquals(2, index5);
        assertEquals(1, index6);
    }
}