package demos.jsObject;

import builtin.JSArray;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


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

        System.out.println("Is 'visible' enumerable? " + obj.propertyIsEnumerable("visible"));
        System.out.println("Is 'hidden' enumerable? " + obj.propertyIsEnumerable("hidden"));
        System.out.println("Is 'missing' enumerable? " + obj.propertyIsEnumerable("missing"));
        // Expected:
        // Is 'visible' enumerable? true
        // Is 'hidden' enumerable? false
        // Is 'missing' enumerable? false

        JSArray keys = JSValue.checkedCoerce(obj.keys(), JSArray.class);
        System.out.println("Enumerable keys: " + keys);
        // Expected: Enumerable keys: [visible]
    }
}
