package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;


public class CreateDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.create Demo ===");

        JSObject proto = JSObject.create();
        proto.set("greet", "Hello!");

        JSObject obj = Object.create(proto);
        obj.set("name", "Alice");

        System.out.println("obj.name: " + obj.get("name"));
        System.out.println("obj.greet: " + obj.get("greet"));
    }
}

