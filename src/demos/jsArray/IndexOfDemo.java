package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class IndexOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.indexOf Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("a"), JSString.of("b")});
        int index1 = arr.indexOf(JSString.of("b"));
        System.out.println("Index of 'b': " + index1);
        // Expected:
        // Index of 'b': 1

        JSArray javaArr1 = JSArray.of("x", "y", "z");
        int index2 = javaArr1.indexOf("y"); // TODO: does not work
        System.out.println("Index of 'y': " + index2);
        int index3 = javaArr1.indexOf("a");
        System.out.println("Index of 'a': " + index3);
        // Expected:
        // Index of 'y': 1
        // Index of 'a': -1

        JSArray javaArr2 = JSArray.of(new int[]{1, 3, 7, 2, 8});
        int index4 = javaArr2.indexOf(7);
        System.out.println("Index of '7': " + index4);
        // Expected:r
        // Index of '7': 2

        JSArray javaArr3 = JSArray.of(new double[]{1.4, 3.64, 7.0, 2.12, 8.9});
        int index5 = javaArr3.indexOf(1.4);
        System.out.println("Index of '1.4': " + index5);
        // Expected:
        // Index of '1.4': 0

        JSArray javaArr4 = JSArray.of(new boolean[]{false, true});
        int index6 = javaArr4.indexOf(false);
        System.out.println("Index of 'false': " + index6);
        int index7 = javaArr4.indexOf(true);
        System.out.println("Index of 'true': " + index7);
        // Expected:
        // Index of 'false': 0
        // Index of 'true': 1
    }
}
