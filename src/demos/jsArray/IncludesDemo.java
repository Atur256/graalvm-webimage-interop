package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class IncludesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.includes Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("x"), JSString.of("y")});
        boolean result = arr.includes(JSString.of("y"));
        System.out.println("Includes 'y': " + result); // Expected: true

        JSArray javaArr = JSArray.of("x", "y", "z");
        boolean result2 = javaArr.includes("y");
        System.out.println("Includes 'y': " + result2); // Expected: true
        boolean result3 = javaArr.includes("a");
        System.out.println("Includes 'a': " + result3); // Expected: false

        JSArray javaArr2 = JSArray.of(1, 3, 7, 2, 8);
        boolean result4 = javaArr2.includes(3);
        System.out.println("Includes '4': " + result4); // Expected: true

        JSArray javaArr3 = JSArray.of(1.4, 3.64, 7.0, 2.12, 8.9);
        boolean result5 = javaArr3.includes(4.1);
        System.out.println("Includes '4.1': " + result5); // Expected: false

        JSArray javaArr4 = JSArray.of(new JSBoolean[]{JSBoolean.of(true), JSBoolean.of(true)});
        boolean result6 = javaArr4.includes(true);
        System.out.println("Includes 'true': " + result6); // Expected: true
        boolean result7 = javaArr4.includes(false);
        System.out.println("Includes 'false': " + result7); // Expected: false
    }
}
