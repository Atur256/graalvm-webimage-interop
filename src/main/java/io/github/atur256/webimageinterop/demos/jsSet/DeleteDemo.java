package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class DeleteDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.delete Demo ===");

        JSSet set = new JSSet();

        // JSValue
        set.add(JSString.of("banana"));
        boolean deletedJSValue = set.delete(JSString.of("banana"));
        System.out.println("Deleted (JSValue) 'banana'?: " + deletedJSValue);
        System.out.println("Has 'banana'?: " + set.has(JSString.of("banana")));
        // Expected:
        // Deleted (JSValue) 'banana'?: true
        // Has 'banana'?: false

        // int
        set.add(42);
        boolean deletedInt = set.delete(42);
        System.out.println("Deleted (int) 42?: " + deletedInt);
        System.out.println("Has 42?: " + set.has(42));
        // Expected:
        // Deleted (int) 42?: true
        // Has 42?: false

        // double
        set.add(3.14);
        boolean deletedDouble = set.delete(3.14);
        System.out.println("Deleted (double) 3.14?: " + deletedDouble);
        System.out.println("Has 3.14?: " + set.has(3.14));
        // Expected:
        // Deleted (double) 3.14?: true
        // Has 3.14?: false

        // boolean
        set.add(true);
        set.add(false);
        boolean deletedTrue = set.delete(true);
        boolean deletedFalse = set.delete(false);
        System.out.println("Deleted (boolean) true?: " + deletedTrue);
        System.out.println("Deleted (boolean) false?: " + deletedFalse);
        System.out.println("Has true?: " + set.has(true));
        System.out.println("Has false?: " + set.has(false));
        // Expected:
        // Deleted (boolean) true?: true
        // Deleted (boolean) false?: true
        // Has true?: false
        // Has false?: false

        // Object
        set.add("custom");
        boolean deletedObject = set.delete("custom");
        System.out.println("Deleted (Object) 'custom'?: " + deletedObject);
        System.out.println("Has 'custom'?: " + set.has("custom"));
        // Expected:
        // Deleted (Object) 'custom'?: true
        // Has 'custom'?: false
    }
}
