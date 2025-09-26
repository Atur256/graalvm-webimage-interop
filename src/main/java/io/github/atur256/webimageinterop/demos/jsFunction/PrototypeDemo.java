package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class PrototypeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.prototype Demo ===");

        JSFunction f = JSFunction.fromBody("return true;");
        JSValue proto = f.prototype;
        assertEquals("JavaScript<object; [object Object]>", proto.toString());
        System.out.println("JSFunction prototype: " + proto);
        // Expected: JSFunction prototype: JavaScript<object; [object Object]>
    }
}
