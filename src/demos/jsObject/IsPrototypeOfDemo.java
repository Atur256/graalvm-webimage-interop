package demos.jsObject;

import org.graalvm.webimage.api.JSObject;


public class IsPrototypeOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Object.isPrototypeOf Demo ===");
        JSObject proto = JSObject.create();
        JSObject obj = JSObject.create();

        JSObject.setPrototypeOf(obj, proto);

        boolean result = proto.isPrototypeOf(obj);
        System.out.println("Is proto a prototype of obj? " + result);
        // Expected: Is proto a prototype of obj? true

        boolean reverse = obj.isPrototypeOf(proto);
        System.out.println("Is obj a prototype of proto? " + reverse);
        // Expected: Is obj a prototype of proto? false
    }
}
