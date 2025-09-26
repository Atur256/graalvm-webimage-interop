package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class ReverseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reverse Demo ===");

        JSArray arr1 = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        arr1.reverse();
        assertArray(arr1, Integer.class, 3,2,1);
        System.out.println("Reversed: " + arr1);
        // Expected: Reversed: [3, 2, 1]

        JSArray arr2 = JSArray.of("apple", "banana", "orange");
        arr2.reverse();
        assertArray(arr2, String.class, "orange", "banana", "apple");
        System.out.println("Reversed: " + arr2);
        // Expected: Reversed: [orange,banana,apple]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), cls));
        }
    }
}
