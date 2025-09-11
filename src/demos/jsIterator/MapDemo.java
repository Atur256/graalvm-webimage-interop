package demos.jsIterator;

import builtin.*;

import java.lang.String;


public class MapDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.map Demo ===");

        JSArray array = JSArray.of(1, 2, 3);
        JSFunction fun = JSFunction.fromGeneralFunction((Integer arg) -> arg * 10);
        JSIterator iterator = JSIterator.from(array).map(fun);

        System.out.println("Mapped to x * 10: " + iterator.toArray());
        // Expected Output: Mapped to x * 10: [10, 20, 30]
    }
}
