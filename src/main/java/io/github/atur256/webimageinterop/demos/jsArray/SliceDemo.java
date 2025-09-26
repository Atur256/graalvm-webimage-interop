package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class SliceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.slice Demo ===");

        JSArray arr1 = JSArray.of(1, 2, 3);
        JSArray result1 = arr1.slice(1, 3);
        assertArray(result1, Integer.class, 2, 3);
        System.out.println("Sliced: " + result1.toString());
        // Expected: Sliced: [2, 3]

        JSArray arr2 = JSArray.of("apple", "banana", "cherry");
        JSArray result2 = arr2.slice(1, 2);
        assertArray(result2, String.class, "banana");
        System.out.println("Sliced: " + result2);
        // Expected: Sliced: ["banana"]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), cls));
        }
    }
}
