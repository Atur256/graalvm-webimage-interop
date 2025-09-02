package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class GetOwnPropertyNamesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.getOwnPropertyNames Demo ===");

        JSObject obj = JSObject.create();
        obj.set("x", 10);
        obj.set("y", 20);

        JSObject names = Object.getOwnPropertyNames(obj);
        System.out.println("Property names: " + names);
    }
}
