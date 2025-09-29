package io.github.atur256.webimageinterop.demos.jsObject;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSObject;

import static org.junit.Assert.assertEquals;


public class EntriesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.entries Demo ===");

        JSObject obj = JSObject.create();
        obj.set("language", "JavaScript");
        obj.set("version", "ES2025");

        JSArray entryArray = JSArray.checkedCoerce(JSObject.entries(obj), JSArray.class);

        for (int i = 0; i < entryArray.length; i++) {
            JSArray pair = entryArray.at(i, JSArray.class);
            String key = pair.at(0, String.class);
            String value = pair.at(1, String.class);
            System.out.println(key + ": " + value);
        }
        // Expected:
        // language: JavaScript
        // version: ES2025

        // Assert values
        JSArray pair0 = entryArray.at(0, JSArray.class);
        JSArray pair1= entryArray.at(1, JSArray.class);
        assertEquals(2, entryArray.length);
        assertEquals("language", pair0.at(0, String.class));
        assertEquals("JavaScript", pair0.at(1, String.class));
        assertEquals("version", pair1.at(0, String.class));
        assertEquals("ES2025", pair1.at(1, String.class));
    }
}