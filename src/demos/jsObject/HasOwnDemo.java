package demos.jsObject;

import org.graalvm.webimage.api.JSObject;


public class HasOwnDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.hasOwn Demo ===");

        JSObject obj = JSObject.create();
        obj.set("x", 10);

        boolean result1 = JSObject.hasOwn(obj, "x");
        boolean result2 = JSObject.hasOwn(obj, "y");
        System.out.println("HasOwn x: " + result1);
        System.out.println("HasOwn y: " + result2);
        // Expected:
        // HasOwn x: true
        // HasOwn y: false
    }
}
