package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class LastIndexOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.lastIndexOf Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("a"), JSString.of("b"), JSString.of("a")});
        int index = arr.lastIndexOf(JSString.of("a"));
        System.out.println("Last index of 'a': " + index); // Expected: 2

        JSArray javaArr1 = JSArray.of("a", "b", "a");
        int index1 = javaArr1.lastIndexOf("a");
        System.out.println("Last index of 'a': " + index1); // Expected: 2

        JSArray javaArr2 = JSArray.of(1, 2, 1, 4, 6, 12, 3, 6, 3, 2);
        int index2 = javaArr2.lastIndexOf(3);
        System.out.println("Last index of '3': " + index2); // Expected: 8
        int index3 = javaArr2.lastIndexOf(10);
        System.out.println("Last index of '10': " + index3); // Expected: -1

        JSArray javaArr3 = JSArray.of(1.3, 5.6, 1.3, 6.7, 3.2);
        int index4 = javaArr3.lastIndexOf(1.3);
        System.out.println("Last index of '1.3': " + index4); // Expected: 2

        JSArray javaArr4 = JSArray.of(new boolean[]{true, true, false});
        int index5 = javaArr4.lastIndexOf(true);
        System.out.println("Last index of 'true': " + index5); // Expected: 1
    }
}
