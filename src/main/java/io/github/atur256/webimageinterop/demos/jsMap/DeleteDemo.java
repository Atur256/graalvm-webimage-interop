package io.github.atur256.webimageinterop.demos.jsMap;

import io.github.atur256.webimageinterop.builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class DeleteDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.delete Demo ===");

        JSMap map = new JSMap();

        // Delete using JSValue
        map.set(JSString.of("temp"), JSString.of("value"));
        boolean deletedValue = map.delete(JSString.of("temp"));
        System.out.println("Deleted (JSValue): " + deletedValue);
        System.out.println("Has 'temp': " + map.has(JSString.of("temp")));
        // Expected:
        // Deleted (JSValue): true
        // Has 'temp': false

        // Delete using int
        map.set(42, "int-value");
        boolean deletedInt = map.delete(42);
        System.out.println("Deleted (int): " + deletedInt);
        System.out.println("Has '42': " + map.has(42));
        // Expected:
        // Deleted (int): false
        // Has '42': false

        // Delete using double
        map.set(3.14, "pi-value");
        boolean deletedDouble = map.delete(3.14);
        System.out.println("Deleted (double): " + deletedDouble);
        System.out.println("Has '3.14': " + map.has(3.14));
        // Expected:
        // Deleted (double): false
        // Has '3.14': false

        // Delete using boolean
        map.set(true, "bool-value");
        boolean deletedBool = map.delete(true);
        System.out.println("Deleted (boolean): " + deletedBool);
        System.out.println("Has 'true': " + map.has(true));
        // Expected:
        // Deleted (boolean): false
        // Has 'true': false

        // Delete using Object
        map.set("custom", "object-value");
        boolean deletedObject = map.delete("custom");
        System.out.println("Deleted (Object): " + deletedObject);
        System.out.println("Has 'custom': " + map.has("custom"));
        // Expected:
        // Deleted (Object): false
        // Has 'custom': false
    }
}
