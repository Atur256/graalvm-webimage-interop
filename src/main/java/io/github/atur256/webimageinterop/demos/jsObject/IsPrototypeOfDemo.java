package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IsPrototypeOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSObject.isPrototypeOf Demo ===");
        JSObject proto = JSObject.create();
        JSObject obj = JSObject.create();

        JSObject.setPrototypeOf(obj, proto);

        boolean result = proto.isPrototypeOf(obj);
        System.out.println("Is proto a prototype of obj? " + result);
        // Expected: Is proto a prototype of obj? true

        boolean reverse = obj.isPrototypeOf(proto);
        System.out.println("Is obj a prototype of proto? " + reverse);
        // Expected: Is obj a prototype of proto? false

        // Assert values
        assertTrue(result);
        assertFalse(reverse);
    }
}