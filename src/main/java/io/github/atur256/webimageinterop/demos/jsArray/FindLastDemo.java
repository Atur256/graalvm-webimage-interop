package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class FindLastDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.findLast Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(5), JSNumber.of(10), JSNumber.of(15));
        JSFunction greaterThan5 = JSFunction.fromBody("return arg > 5;");
        int result1 = arr.findLast(greaterThan5, Integer.class);
        assertEquals(15, result1);
        System.out.println("Last match > 5: " + result1);
        // Expected: Last match > 5: 15

        JSArray javaArr = JSArray.of(5, 10, 15);
        JSFunction smallerThan15 = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) < 15));
        int result2 = javaArr.findLast(smallerThan15, Integer.class);
        assertEquals(10, result2);
        System.out.println("Last match < 15: " + result2);
        // Expected: Last match < 15: 10
    }
}
