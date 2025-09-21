package demos.jsObject;

import org.graalvm.webimage.api.JSObject;


public class ToLocaleStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== toLocaleString Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");
        obj.set("region", "Austria");

        String result = obj.toLocaleString();

        System.out.println("toLocaleString(): " + result);
        // Expected: toLocaleString(): [object Object]
    }
}
