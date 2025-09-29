package io.github.atur256.webimageinterop.demos.jsObject;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


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

        JSObject result = JSObject.fromEntries(entries);
        JSArray keys = JSValue.checkedCoerce(result.keys(), JSArray.class);
        String framework = JSValue.checkedCoerce(result.get("framework"), String.class);
        String mode = JSValue.checkedCoerce(result.get("mode"), String.class);

        System.out.println("framework: " + framework);
        System.out.println("mode: " + mode);
        // Expected:
        // framework: GraalVM
        // mode: native

        // Assert values
        AssertArray.assertArray(keys, String.class, "framework", "mode");
        assertEquals("GraalVM", framework);
        assertEquals("native", mode);
    }
}