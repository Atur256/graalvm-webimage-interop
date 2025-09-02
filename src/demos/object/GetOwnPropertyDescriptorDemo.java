package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;


public class GetOwnPropertyDescriptorDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.getOwnPropertyDescriptor Demo ===");

        JSObject obj = JSObject.create();
        obj.set("key", 99);

        JSObject descriptor = Object.getOwnPropertyDescriptor(obj, "key");
        System.out.println("Descriptor: " + descriptor);
    }
}
