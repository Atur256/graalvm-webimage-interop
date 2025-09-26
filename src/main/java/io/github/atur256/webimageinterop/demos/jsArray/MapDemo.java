package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class MapDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.map Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction doubleFn = JSFunction.fromBody("return arg * 2;");
        JSArray result1 = arr.map(doubleFn);
        assertArray(result1, 2, 4, 6);
        System.out.println("Mapped: " + result1);
        // Expected: Mapped: [2, 4, 6]

        JSArray javaArr = JSArray.of(1, 2, 3);
        JSFunction tripleFn = JSFunction.fromGeneralFunction((JSNumber arg) -> JSNumber.of(arg.as(Integer.class) * 3));
        JSArray result2 = javaArr.map(tripleFn);
        assertArray(result2, 3, 6, 9);
        System.out.println("Mapped: " + result2);
        // Expected: "Mapped: [3, 6, 9]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), Integer.class));
        }
    }
}
