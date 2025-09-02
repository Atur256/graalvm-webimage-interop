package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;


public class EntriesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.entries Demo ===");

        JSObject obj = JSObject.create();
        obj.set("foo", "bar");
        obj.set("baz", 123);

        JSObject entries = Object.entries(obj);
        System.out.println("Entries: " + entries);
    }
}
