package io.github.atur256.webimageinterop.demos.jsObject;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.*;

import static org.junit.Assert.assertEquals;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSObject.keys Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");
        obj.set("age", "27");
        obj.set("active", "true");

        JSArray keyArray = JSValue.checkedCoerce(JSObject.keys(obj), JSArray.class);

        System.out.println("Object keys:");
        for(int i = 0; i < keyArray.length; i++) {
            String key = JSValue.checkedCoerce(keyArray.get(i), String.class);
            System.out.println(" - " + key);
        }
        // Expected:
        // Object keys:
        // - name
        // - age
        // - active

        System.out.println("\nKey-value pairs:");
        for(int i = 0; i < keyArray.length; i++) {
            String key = JSValue.checkedCoerce(keyArray.get(i), String.class);
            String value = (String) obj.get(key);
            System.out.println(" " + key + " = " + value);
        }
        // Expected:
        // Key-value pairs:
        // name = Alice
        // age = 27
        // active = true

        // Assert values
        AssertArray.assertArray(keyArray, String.class, "name", "age", "active");
    }
}