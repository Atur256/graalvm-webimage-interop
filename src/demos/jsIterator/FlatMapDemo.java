package demos.jsIterator;

import builtin.*;
import org.graalvm.webimage.api.JSNumber;

import java.lang.String;


public class FlatMapDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.flatMap Demo ===");

        JSArray array = JSArray.of(1, 2, 3);
        JSFunction fun = JSFunction.fromGeneralFunction((JSNumber arg ) -> JSArray.of(arg.as(Integer.class), arg.as(Integer.class)* 2));

        JSIterator iterator = JSIterator.from(array).flatMap(fun);
        System.out.println("FlatMapped: " + iterator.toArray());
        // Expected Output: FlatMapped: [1, 2, 2, 4, 3, 6]
    }
}
