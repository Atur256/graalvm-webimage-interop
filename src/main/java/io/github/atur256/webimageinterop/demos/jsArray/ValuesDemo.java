package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class ValuesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.values Demo ===");

        JSArray arr = JSArray.of(10, 20);

        JSIterator values = arr.values();
        assertArray(values.toArray(), 10, 20);
        System.out.println("Values iterator: " + values.toArray().toString());
        // Expected: Values iterator: [10,20]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), Integer.class));
        }
    }
}
