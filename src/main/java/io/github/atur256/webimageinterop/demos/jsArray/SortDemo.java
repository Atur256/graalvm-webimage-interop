package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class SortDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.sort Demo ===");

        JSArray arr = JSArray.of("banana", "apple", "cherry");

        arr.sort();
        assertArray(arr, String.class, "apple", "banana", "cherry");
        System.out.println("Sorted array: " + arr);
        // Expected: Sorted array: ["apple", "banana", "cherry"]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), cls));
        }
    }
}
