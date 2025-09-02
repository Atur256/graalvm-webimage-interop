package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class CreateWithPropertiesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.create with properties Demo ===");

        JSObject proto = JSObject.create();

        JSObject props = JSObject.create();
        JSObject desc = JSObject.create();
        desc.set("value", 100);
        desc.set("writable", true);
        props.set("score", desc);

        JSObject obj = Object.create(proto, props);
        System.out.println("Created object score: " + obj.get("score"));
    }
}
