package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSString;


public class LastIndexOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.lastIndexOf Demo ===");

        JSArray arr = JSArray.of(JSString.of("a"), JSString.of("b"), JSString.of("a"));
        int index = arr.lastIndexOf(JSString.of("a"));
        System.out.println("Last index of 'a': " + index);
        // Expected: Last index of 'a': 2

        JSArray javaArr1 = JSArray.of("a", "b", "a");
        int index1 = javaArr1.lastIndexOf("a");
        System.out.println("Last index of 'a': " + index1);
        // Expected: Last index of 'a': 2

        JSArray javaArr2 = JSArray.of(1, 2, 1, 4, 6, 12, 3, 6, 3, 2);
        int index2 = javaArr2.lastIndexOf(3);
        System.out.println("Last index of '3': " + index2);
        int index3 = javaArr2.lastIndexOf(10);
        System.out.println("Last index of '10': " + index3);
        // Expected:
        // Last index of '3': 8
        // Last index of '10': -1

        JSArray javaArr3 = JSArray.of(1.3, 5.6, 1.3, 6.7, 3.2);
        int index4 = javaArr3.lastIndexOf(1.3);
        System.out.println("Last index of '1.3': " + index4);
        // Expected: Last index of '1.3': 2

        JSArray javaArr4 = JSArray.of(true, true, false);
        int index5 = javaArr4.lastIndexOf(true);
        System.out.println("Last index of 'true': " + index5);
        // Expected: Last index of 'true': 1
    }
}
