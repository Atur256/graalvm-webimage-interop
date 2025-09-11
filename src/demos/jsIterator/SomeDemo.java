package demos.jsIterator;

import builtin.*;
import org.graalvm.webimage.api.JSBoolean;

import java.lang.String;


public class SomeDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.some Demo ===");

        JSArray array1 = JSArray.of(1, 3, 5, 8);
        JSArray array2 = JSArray.of(1, 3, 5, 7);
        JSFunction fun = JSFunction.fromGeneralFunction((Integer arg ) -> JSBoolean.of(arg % 2 == 0));
        JSIterator iterator1 = JSIterator.from(array1);
        JSIterator iterator2 = JSIterator.from(array2);

        boolean hasEven1 = iterator1.some(fun);
        System.out.println(array1.toString() +  " contains even number: " + hasEven1);
        // Expected Output: [1,2,3,8] contains even number: true

        boolean hasEven2 = iterator2.some(fun);
        System.out.println(array2.toString() +  " contains even number: " + hasEven2);
        // Expected Output: [1,2,3,5] contains even number: false
    }
}
