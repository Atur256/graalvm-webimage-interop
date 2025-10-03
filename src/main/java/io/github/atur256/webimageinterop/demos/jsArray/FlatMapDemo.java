package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.JSNumber;


public class FlatMapDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.flatMap Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2));
        JSFunction duplicate = JSFunction.fromBody("return [arg, arg];");
        JSArray result1 = arr.flatMap(duplicate);
        System.out.println("FlatMapped: " + result1);
        // Expected: FlatMapped: [1, 1, 2, 2]

        JSArray javaArr = JSArray.of(1, 2);
        JSFunction javaTriple = JSFunction.fromGeneralFunction((JSNumber arg) ->
                JSArray.of(arg.as(Integer.class), arg.as(Integer.class), arg.as(Integer.class)));
        JSArray result2 = javaArr.flatMap(javaTriple);
        System.out.println("FlatMapped: " + result2);
        // Expected: FlatMapped: [1, 1, 1, 2, 2, 2]

        // Assert values
        AssertArray.assertArray(result1, Integer.class, 1, 1, 2, 2);
        AssertArray.assertArray(result2, Integer.class, 1, 1, 1, 2, 2, 2);
    }
}