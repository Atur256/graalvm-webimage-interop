package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class ValueOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSObject.valueOf Demo ===");

        JSObject obj = JSObject.create();
        obj.set("id", 42);

        JSObject result = JSValue.checkedCoerce(obj.valueOf(), JSObject.class);

        int value = JSValue.checkedCoerce(result.get("id"), Integer.class);
        System.out.println("valueOf().id = " + value);
        // Expected: valueOf().id = 42

        // Assert values
        assertEquals(42, value);
    }
}