package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class AddDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.add Demo ===");

        JSSet set = new JSSet();

        // Add JSValue
        set.add(JSString.of("apple")).add(JSString.of("banana"));
        System.out.println("Has (JSValue) 'apple'?: " + set.has(JSString.of("apple")));
        System.out.println("Has (JSValue) 'banana'?: " + set.has(JSString.of("banana")));
        System.out.println("Has (JSValue) 'orange'?: " + set.has(JSString.of("orange")));
        // Expected:
        // Has (JSValue) 'apple'?: true
        // Has (JSValue) 'banana'?: true
        // Has (JSValue) 'orange'?: false

        // Add int
        set.add(42);
        System.out.println("Has (int) 42?: " + set.has(42));
        System.out.println("Has (int) 0?: " + set.has(0));
        // Expected:
        // Has (int) 42?: true
        // Has (int) 0?: false

        // Add double
        set.add(3.14);
        System.out.println("Has (double) 3.14?: " + set.has(3.14));
        System.out.println("Has (double) 1.1?: " + set.has(1.1));
        // Expected:
        // Has (double) 3.14?: true
        // Has (double) 1.1?: true

        // Add boolean
        set.add(true).add(false);
        System.out.println("Has (boolean) true?: " + set.has(true));
        System.out.println("Has (boolean) false?: " + set.has(false));
        // Expected:
        // Has (boolean) true?: true
        // Has (boolean) false?: true

        // Add Object
        set.add("custom");
        System.out.println("Has (Object) 'custom'?: " + set.has("custom"));
        System.out.println("Has (Object) 'custom-2'?: " + set.has("custom-2"));
        // Expected:
        // Has (Object) 'custom'?: true
        // Has (Object) 'custom-2'?: false
    }
}
