package io.github.atur256.webimageinterop.demos.jsObject;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.*;


public class PropertyIsEnumerableDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSObject.propertyIsEnumerable Demo ===");

        JSObject obj = JSObject.create();
        obj.set("visible", "yes");

        JSObject descriptors = JSObject.create();
        JSObject hiddenDescriptor = JSObject.create();
        hiddenDescriptor.set("value", "no");
        hiddenDescriptor.set("enumerable", JSBoolean.of(false));
        descriptors.set("hidden", hiddenDescriptor);
        JSObject.defineProperties(obj, descriptors);

        boolean visible = obj.propertyIsEnumerable("visible");
        boolean hidden = obj.propertyIsEnumerable("hidden");
        boolean missing = obj.propertyIsEnumerable("missing");
        System.out.println("Is 'visible' enumerable? " + visible);
        System.out.println("Is 'hidden' enumerable? " + hidden);
        System.out.println("Is 'missing' enumerable? " + missing);
        // Expected:
        // Is 'visible' enumerable? true
        // Is 'hidden' enumerable? false
        // Is 'missing' enumerable? false

        JSArray keys = JSValue.checkedCoerce(obj.keys(), JSArray.class);
        System.out.println("Enumerable keys: " + keys);
        // Expected: Enumerable keys: [visible]

        // Assert values
        assertTrue(visible);
        assertFalse(hidden);
        assertFalse(missing);
        AssertArray.assertArray(keys, String.class, "visible");
    }
}