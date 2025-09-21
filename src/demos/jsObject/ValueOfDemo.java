package demos.jsObject;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


public class ValueOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== valueOf Demo ===");

        JSObject obj = JSObject.create();
        obj.set("id", 42);

        JSObject result = obj.valueOf();

        System.out.println("valueOf().id = " + JSValue.checkedCoerce(result.get("id"), Integer.class));
        // Expected: valueOf().id = 42
    }
}
