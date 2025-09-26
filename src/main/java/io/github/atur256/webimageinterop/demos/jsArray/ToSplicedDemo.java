package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class ToSplicedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toSpliced Demo ===");

        JSArray arr = JSArray.of("a", "b", "c");

        JSArray spliced = arr.toSpliced(1, 1);
        assertArray(spliced, "a", "c");
        System.out.println("Original array: " + arr);
        System.out.println("Spliced copy: " + spliced.toString());
        // Expected:
        // Original array: ["a", "b", "c"]
        // Spliced copy: ["a", "c"]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), String.class));
        }
    }
}
