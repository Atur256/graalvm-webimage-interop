package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class UnshiftDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.unshift Demo ===");

        JSArray arr1 = JSArray.of(JSString.of("b"));
        int newLength1 = arr1.unshift(JSString.of("a"));
        assertEquals(2, newLength1);
        assertArray(arr1, String.class, "a", "b");
        System.out.println("After unshift: " + arr1 + " with length: " + newLength1);
        // Expected: After unshift: ["a", "b"] with length: 2

        JSArray arr2 = JSArray.of(1, 2, 3);
        int newLength2 = arr2.unshift(4);
        assertEquals(4, newLength2);
        assertArray(arr2, Integer.class, 4, 1, 2, 3);
        System.out.println("After unshift: " + arr2 + " with length: " + newLength2);
        // Expected: After unshift: [4, 1, 2, 3] with length: 4

        JSArray arr3 = JSArray.of(1.1, 2.2, 3.3);
        int newLength3 = arr3.unshift(4.4);
        assertEquals(4, newLength3);
        assertArray(arr3, Double.class, 4.4, 1.1, 2.2, 3.3);
        System.out.println("After unshift: " + arr3 + " with length: " + newLength3);
        // Expected: After unshift: [4.4, 1.1, 2.2, 3.3] with length: 4

        JSArray arr4 = JSArray.of(true, true, true, true);
        int newLength4 = arr4.unshift(false);
        assertEquals(5, newLength4);
        assertArray(arr4, Boolean.class, false, true, true, true, true);
        System.out.println("After unshift: " + arr4 + " with length: " + newLength4);
        // Expected: After unshift: [false, true, true, true, true] with length: 5

        JSArray arr5 = JSArray.of("apple", "banana", "orange");
        int newLength5 = arr5.unshift("pear");
        assertEquals(4, newLength5);
        assertArray(arr5, String.class, "pear", "apple", "banana", "orange");
        System.out.println("After unshift: " + arr5 + " with length: " + newLength5);
        // Expected: After unshift: ["pear", "apple", "banana", "orange"] with length: 4
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), cls));
        }
    }
}
