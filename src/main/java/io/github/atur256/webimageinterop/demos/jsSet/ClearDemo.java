package io.github.atur256.webimageinterop.demos.jsSet;

import io.github.atur256.webimageinterop.builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class ClearDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.clear Demo ===");

        JSSet set = new JSSet();
        set.add(JSString.of("apple"));

        System.out.println("Size before clear: " + set.size);
        set.clear();
        System.out.println("Size after clear: " + set.size);
        System.out.println("Has 'apple'?: " + set.has(JSString.of("apple")));
        // Expected:
        // Size before clear: 1
        // Size after clear: 0
        // Has 'apple'?: false
    }
}
