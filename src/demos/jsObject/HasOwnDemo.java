package demos.jsObject;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;


public class HasOwnDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.hasOwn Demo ===");

        JSObject obj = JSObject.create();
        obj.set("x", 10);

        System.out.println("HasOwn x: " + Object.hasOwn(obj, "x"));
        System.out.println("HasOwn y: " + Object.hasOwn(obj, "y"));
    }
}
