package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class IsDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.is Demo ===");

        JSObject obj1 = JSObject.create();
        obj1.set("val", 5);
        JSObject obj2 = JSObject.create();
        obj2.set("val", 5);

        System.out.println("Is equal: " + Object.is(obj1, obj2));
    }
}
