package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;


public class FilterDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.filter Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction isEven = JSFunction.fromBody("return arg % 2 === 0;");
        JSArray filtered1 = arr.filter(isEven);
        System.out.println("Filtered: " + filtered1);
        // Expected: Filtered: [2]

        JSArray javaArr = JSArray.of(1, 4, 9);
        JSFunction isOdd = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) % 2 != 0));
        JSArray filtered2 = javaArr.filter(isOdd);
        System.out.println("Filtered: " + filtered2);
        // Expected: Filtered: [1,9]

        // Assert values
        AssertArray.assertArray(filtered1, Integer.class, 2);
        AssertArray.assertArray(filtered2, Integer.class, 1, 9);
    }
}