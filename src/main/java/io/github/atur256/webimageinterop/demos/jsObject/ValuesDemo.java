package io.github.atur256.webimageinterop.demos.jsObject;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


public class ValuesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.values Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");
        obj.set("age", "27");
        obj.set("active", "true");

        JSArray valueArray = JSValue.checkedCoerce(JSObject.values(obj), JSArray.class);

        System.out.println("Object values:");
        for(int i = 0; i < valueArray.length; i++) {
            String value = JSValue.checkedCoerce(valueArray.get(i), String.class);
            System.out.println(" - " + value);
        }
        // Expected:
        // Object values:
        // - Alice
        // - 27
        // - true

        // Assert values
        AssertArray.assertArray(valueArray, String.class, "Alice", "27", "true");
    }
}