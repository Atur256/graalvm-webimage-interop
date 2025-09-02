package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;


public class AssignDemo {

    public static void main(String[] args) {

        System.out.println("=== Object.assign Demo ===");

        JSObject target = JSObject.create();
        target.set("a", 1);
        target.set("b", 2);

        JSObject source1 = JSObject.create();
        source1.set("b", 4);
        source1.set("c", 5);

        JSObject source2 = JSObject.create();
        source2.set("c", 1);
        source2.set("d", 5);

        JSObject result = Object.assign(target, source1);

        System.out.println("Assigned Object entries: " + Object.entries(result));
    }
}
