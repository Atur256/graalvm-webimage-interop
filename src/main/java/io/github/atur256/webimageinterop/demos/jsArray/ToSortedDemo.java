package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class ToSortedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toSorted Demo ===");

        JSArray arr = JSArray.of("zebra", "apple", "mango");

        JSArray sorted = arr.toSorted();
        assertArray(sorted, "apple", "mango", "zebra");
        System.out.println("Original array: " + arr);
        System.out.println("Sorted copy: " + sorted);
        // Expected:
        // Original array: ["zebra", "apple", "mango"]
        // Sorted copy: ["apple", "mango", "zebra"]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), String.class));
        }
    }
}
