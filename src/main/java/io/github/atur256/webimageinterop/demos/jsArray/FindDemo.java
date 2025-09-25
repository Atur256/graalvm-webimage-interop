package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;


public class FindDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.find Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(5), JSNumber.of(10), JSNumber.of(15));
        JSFunction greaterThan10 = JSFunction.fromBody("return arg > 10;");
        int found1 = arr.find(greaterThan10, Integer.class);
        System.out.println("Found: " + found1);
        // Expected: Found: 15

        JSArray JavaArr = JSArray.of(5, 10, 15);
        JSFunction smallerThan10 = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) < 10));
        int found2 = JavaArr.find(smallerThan10, Integer.class);
        System.out.println("Found: " + found2);
        // Expected: Found: 5
    }
}
