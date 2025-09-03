package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;


public class GetOwnPropertyDescriptorsDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.getOwnPropertyDescriptors Demo ===");

        JSObject obj = JSObject.create();
        obj.set("a", 1);
        obj.set("b", 2);

//        JSObject descriptors = Object.getOwnPropertyDescriptors(obj);
//
//        System.out.println("Descriptors: " + descriptors);
    }
}

