package demos.jsObject;

import builtin.JSArray;
import org.graalvm.webimage.api.JSObject;

public class GetOwnPropertyNamesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.getOwnPropertyNames Demo ===");

        JSObject obj = JSObject.create();
        obj.set("x", 1);
        obj.set("y", 2);

        JSArray names = JSObject.getOwnPropertyNames(obj).as(JSArray.class);

        for (int i = 0; i < names.length; i++) {
            System.out.println("Property: " + names.at(i, String.class));
        }
        // Expected:
        // Property: x
        // Property: y
    }
}
