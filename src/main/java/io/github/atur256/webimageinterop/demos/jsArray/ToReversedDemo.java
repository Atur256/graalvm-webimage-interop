package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class ToReversedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toReversed Demo ===");

        JSArray arr = JSArray.of(1, 2, 3);

        JSArray reversed = arr.toReversed();
        assertArray(reversed, 3, 2, 1);
        System.out.println("Original array: " + arr);
        System.out.println("Reversed copy: " + reversed);
        // Expected:
        // Original array: [1, 2, 3]
        // Reversed copy: [3, 2, 1]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), Integer.class));
        }
    }
}
