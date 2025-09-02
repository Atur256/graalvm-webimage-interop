package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;


public class DefinePropertyDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.defineProperty Demo ===");

        JSObject obj = JSObject.create();

        JSObject descriptor = JSObject.create();
        descriptor.set("value", 42);
        descriptor.set("writable", false);
        descriptor.set("enumerable", true);

        Object.defineProperty(obj, JSString.of("answer"), descriptor);
        System.out.println("Defined property answer: " + obj.get("answer"));
    }
}
