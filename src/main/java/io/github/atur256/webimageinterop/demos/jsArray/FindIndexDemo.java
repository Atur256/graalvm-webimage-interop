package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;


public class FindIndexDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.findIndex Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(3), JSNumber.of(7), JSNumber.of(9));
        JSFunction isOdd = JSFunction.fromBody("return arg % 2 !== 0;");
        int index = arr.findIndex(isOdd);
        System.out.println("First odd index: " + index);
        // Expected: First odd index 0

        JSArray javaArr = JSArray.of(3, 7, 8, 9);
        JSFunction isEven = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) % 2 == 0));
        int index2 = javaArr.findIndex(isEven);
        System.out.println("First odd index: " + index2);
        // Expected: First odd index: 2
    }
}
