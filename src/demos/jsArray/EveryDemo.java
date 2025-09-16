package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;


public class EveryDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Array.every Demo ===");

        JSArray arr = JSArray.of(2, 4, 6);
        JSFunction isEven = JSFunction.fromGeneralFunction((Integer value) ->
                JSBoolean.of(value % 2 == 0));
        boolean result = arr.every(isEven);
        System.out.println("All even: " + result);
        // Expected: All even: true
    }

}
