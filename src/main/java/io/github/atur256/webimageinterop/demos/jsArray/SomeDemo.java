package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SomeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.some Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction isEven = JSFunction.fromBody("return arg % 2 === 0;");
        boolean result1 = arr.some(isEven);
        System.out.println("Has even: " + result1);
        assertTrue(result1);
        // Expected: Has even: true

        JSArray javaArr = JSArray.of(2, 4, 6);
        JSFunction isOdd = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) % 2 != 0));
        boolean result2 = javaArr.some(isOdd);
        System.out.println("Has even: " + result2);
        assertFalse(result2);
        // Expected: Has even: false
    }
}
