package demos.jsObject;

import builtin.JSArray;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


public class FromEntriesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.fromEntries Demo ===");

        JSArray entries = new JSArray();

        JSArray pair1 = new JSArray();
        pair1.push("framework");
        pair1.push("GraalVM");

        JSArray pair2 = new JSArray();
        pair2.push("mode");
        pair2.push("native");

        entries.push(pair1);
        entries.push(pair2);

        JSObject result = JSObject.fromEntries(entries).as(JSObject.class);

        System.out.println("framework: " + ((JSValue) result.get("framework")).as(String.class));
        System.out.println("mode: " + ((JSValue) result.get("mode")).as(String.class));
        // Expected:
        // framework: GraalVM
        // mode: native
    }
}
