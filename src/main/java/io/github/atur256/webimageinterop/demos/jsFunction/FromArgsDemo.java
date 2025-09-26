package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;

import static org.junit.Assert.assertEquals;


public class FromArgsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromArgs Demo ===");

        JSFunction sum = JSFunction.fromArgs("a", "b", "return a + b;");
        int result = sum.applyJS(null, JSArray.of(JSNumber.of(5), JSNumber.of(7)), Integer.class);
        assertEquals(12, result);
        System.out.println("Result: " + result);
        // Expected: Result: 12
    }
}