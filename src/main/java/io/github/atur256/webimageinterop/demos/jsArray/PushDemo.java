package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class PushDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.push Demo ===");

        JSArray arr1 = JSArray.of(JSString.of("a"));
        arr1.push(JSString.of("b"));
        assertArray(arr1, String.class, "a", "b");
        System.out.println("After push: " + arr1);
        // Expected: After push: ["a", "b"]

        JSArray arr2 = JSArray.of("a");
        arr2.push("b");
        arr2.push(JSString.of("c"));
        assertArray(arr2, String.class, "a", "b", "c");
        System.out.println("After push: " + arr2);
        // Expected: After push: ["a", "b", "c"]

        JSArray arr3 = JSArray.of(1, 2, 3);
        arr3.push(4);
        assertArray(arr3, Integer.class, 1, 2, 3, 4);
        System.out.println("After push: " + arr3);
        // Expected: After push: [1, 2, 3, 4]

        JSArray arr4 = JSArray.of(1.2, 2.3, 3.4);
        arr4.push(4.5);
        assertArray(arr4, Double.class, 1.2, 2.3, 3.4, 4.5);
        System.out.println("After push: " + arr4);
        // Expected: After push: [1.2, 2.3, 3.4, 4.5]

        JSArray arr5 = JSArray.of(true, false, true, true);
        arr5.push(false);
        assertArray(arr5, Boolean.class, true, false, true, true, false);
        System.out.println("After push: " + arr5);
        // Expected: After push: [true, false, true, true, false]

        JSArray arr6 = JSArray.of("apple", "banana", "orange");
        arr6.push("pear");
        assertArray(arr6, String.class, "apple", "banana", "orange", "pear");
        System.out.println("After push: " + arr6);
        // Expected: After push: ["apple", "banana", "orange", "pear"]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), cls));
        }
    }
}
