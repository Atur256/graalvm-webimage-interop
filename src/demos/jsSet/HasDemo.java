package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;

public class HasDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.has Demo ===");

        JSSet set = new JSSet();

        // JSValue
        set.add(JSString.of("cherry"));
        System.out.println("Has (JSValue) 'cherry'?: " + set.has(JSString.of("cherry")));
        System.out.println("Has (JSValue) 'apple'?: " + set.has(JSString.of("apple")));
        // Expected:
        // Has (JSValue) 'cherry'?: true
        // Has (JSValue) 'apple'?: false

        // int
        set.add(42);
        System.out.println("Has (int) 42?: " + set.has(42));
        System.out.println("Has (int) 12?: " + set.has(12));
        // Expected:
        // Has (int) 42?: true
        // Has (int) 12?: false

        // double
        set.add(3.14);
        System.out.println("Has (double) 3.14?: " + set.has(3.14));
        System.out.println("Has (double) 1.11?: " + set.has(1.11));
        // Expected:
        // Has (double) 3.14?: true
        // Has (double) 1.11?: false

        // boolean
        set.add(true);
        set.add(false);
        System.out.println("Has (boolean) true?: " + set.has(true));
        System.out.println("Has (boolean) false?: " + set.has(false));
        // Expected:
        // Has (boolean) true?: true
        // Has (boolean) false?: true

        // Object
        set.add("custom-1");
        System.out.println("Has (Object) 'custom-1'?: " + set.has("custom-1"));
        System.out.println("Has (Object) 'custom-2'?: " + set.has("custom-2"));
        // Expected:
        // Has (Object) 'custom-1'?: false
        // Has (Object) 'custom-2'?: false
    }
}
