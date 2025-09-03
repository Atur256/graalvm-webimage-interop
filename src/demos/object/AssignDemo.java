package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


public class AssignDemo {

    public static void main(String[] args) {

        System.out.println("=== Object.assign Demo ===");

        JSObject target = createObject();
        target.set("a", 1);
        target.set("b", 2);

        JSObject source1 = createObject();
        source1.set("b", 4);
        source1.set("c", 5);

        JSObject source2 = createObject();
        source2.set("c", 1);
        source2.set("d", 5);

        JSObject result = Object.assign(target, source1, source2);

        System.out.println("Assigned Object entries: " + Object.entries(result));
    }

    @JS("return {};")
    public native static JSObject createObject(); // Normal JSObject.create() does not work for assign
}
