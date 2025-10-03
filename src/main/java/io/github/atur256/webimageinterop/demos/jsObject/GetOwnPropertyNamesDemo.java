package io.github.atur256.webimageinterop.demos.jsObject;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


public class GetOwnPropertyNamesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.getOwnPropertyNames Demo ===");

        JSObject obj = JSObject.create();
        obj.set("x", 1);
        obj.set("y", 2);

        JSArray names = JSValue.checkedCoerce(JSObject.getOwnPropertyNames(obj), JSArray.class);

        for(int i = 0; i < names.length; i++) {
            System.out.println("Property: " + names.at(i, String.class));
        }
        // Expected:
        // Property: x
        // Property: y

        // Assert values
        AssertArray.assertArray(names, String.class, "x", "y");
    }
}