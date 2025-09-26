package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class FilterDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.filter Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction isEven = JSFunction.fromBody("return arg % 2 === 0;");
        JSArray filtered1 = arr.filter(isEven);
        assertArray(filtered1, Integer.class, 2);
        System.out.println("Filtered: " + filtered1);
        // Expected: Filtered: [2]

        JSArray javaArr = JSArray.of(1, 4, 9);
        JSFunction isOdd = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) % 2 != 0));
        JSArray filtered2 = javaArr.filter(isOdd);
        assertArray(filtered2, Integer.class, 1,9);
        System.out.println("Filtered: " + filtered2);
        // Expected: Filtered: [1,9]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), cls));
        }
    }
}
