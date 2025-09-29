package io.github.atur256.webimageinterop.demos;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class AssertArray {

    @SafeVarargs
    public static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), cls));
        }
    }
}
