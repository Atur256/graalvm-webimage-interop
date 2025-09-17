package demos.jsObject;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class ValuesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.values Demo ===");

        JSObject obj = JSObject.create();
        obj.set("one", 1);
        obj.set("two", 2);
        JSObject values = Object.values(obj);
        System.out.println("Values: " + values);
    }
}
