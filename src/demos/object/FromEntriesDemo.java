package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;

public class FromEntriesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.fromEntries Demo ===");

        JSObject pair1 = createArray();
        pair1.set("0", "a");
        pair1.set("1", 10);

        JSObject pair2 = createArray();
        pair2.set("0", "b");
        pair2.set("1", 20);

        JSObject entriesArray = createArray();
        entriesArray.set("0", pair1);
        entriesArray.set("1", pair2);

        JSObject obj = Object.fromEntries(entriesArray);
        System.out.println("FromEntries: " + Object.entries(obj));
    }

    @JS("return [];")
    public native static JSObject createArray();
}
