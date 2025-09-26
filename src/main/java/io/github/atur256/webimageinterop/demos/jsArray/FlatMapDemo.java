package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class FlatMapDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.flatMap Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2));
        JSFunction duplicate = JSFunction.fromBody("return [arg, arg];");
        JSArray result1 = arr.flatMap(duplicate);
        assertArray(result1, 1, 1, 2, 2);
        System.out.println("FlatMapped: " + result1);
        // Expected: FlatMapped: [1, 1, 2, 2]

        JSArray javaArr = JSArray.of(1, 2);
        JSFunction javaTriple = JSFunction.fromGeneralFunction((JSNumber arg) ->
                JSArray.of(arg.as(Integer.class), arg.as(Integer.class), arg.as(Integer.class)));
        JSArray result2 = javaArr.flatMap(javaTriple);
        assertArray(result2, 1, 1, 1, 2, 2, 2);
        System.out.println("FlatMapped: " + result2);
        // Expected: FlatMapped: [1, 1, 1, 2, 2, 2]
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), Integer.class));
        }
    }
}
