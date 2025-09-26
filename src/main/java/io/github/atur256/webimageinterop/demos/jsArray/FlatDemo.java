package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class FlatDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.flat Demo ===");

        JSArray innerMost = JSArray.of(JSNumber.of(4));
        JSArray level3 = JSArray.of(JSNumber.of(3), innerMost);
        JSArray level2 = JSArray.of(JSNumber.of(2), level3);
        JSArray root = JSArray.of(JSNumber.of(1), level2);

        JSArray flat = root.flat(3);
        assertArray(flat, 1, 2, 3, 4);
        System.out.println("Flat: " + flat);
        // Expected: Flat : [1,2,3,4]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), Integer.class));
        }
    }
}
