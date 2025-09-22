package demos.jsObject;

import builtin.JSArray;
import org.graalvm.webimage.api.JSObject;


public class EntriesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.entries Demo ===");

        JSObject obj = JSObject.create();
        obj.set("language", "JavaScript");
        obj.set("version", "ES2025");

        JSArray entryArray = JSObject.entries(obj).as(JSArray.class);

        for (int i = 0; i < entryArray.length; i++) {
            JSArray pair = entryArray.at(i, JSArray.class);
            String key = pair.at(0, String.class);
            String value = pair.at(1, String.class);
            System.out.println(key + ": " + value);
        }
        // Expected:
        // language: JavaScript
        // version: ES2025
    }
}
