package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.JSNumber;


public class MapDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.map Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        JSFunction doubleFn = JSFunction.fromBody("return arg * 2;");
        JSArray result1 = arr.map(doubleFn);

        System.out.println("Mapped: " + result1);
        // Expected: Mapped: [2, 4, 6]

        JSArray javaArr = JSArray.of(1, 2, 3);
        JSFunction tripleFn = JSFunction.fromGeneralFunction((JSNumber arg) -> JSNumber.of(arg.as(Integer.class) * 3));
        JSArray result2 = javaArr.map(tripleFn);
        System.out.println("Mapped: " + result2);
        // Expected: "Mapped: [3, 6, 9]

        // Assert values
        AssertArray.assertArray(result1, Integer.class, 2, 4, 6);
        AssertArray.assertArray(result2, Integer.class, 3, 6, 9);
    }
}