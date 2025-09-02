package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class DefinePropertiesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.defineProperties Demo ===");

        JSObject obj = JSObject.create();

        JSObject props = JSObject.create();
        JSObject desc1 = JSObject.create();
        desc1.set("value", 1);
        desc1.set("writable", true);
        JSObject desc2 = JSObject.create();
        desc2.set("value", 2);
        desc2.set("writable", true);

        props.set("p1", desc1);
        props.set("p2", desc2);

        Object.defineProperties(obj, props);
        System.out.println("Defined p1: " + obj.get("p1") + ", p2: " + obj.get("p2"));
    }
}
