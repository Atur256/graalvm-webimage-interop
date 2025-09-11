package demos.jsIterator;

import builtin.*;
import org.graalvm.webimage.api.JSBoolean;

import java.lang.String;


public class FilterDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.filter Demo ===");

        JSIterator iterator = JSIterator.from(JSArray.of(1, 2, 3, 4, 5, 6));
        JSFunction isGreaterThan3 = JSFunction.fromGeneralFunction((Integer arg) -> JSBoolean.of(arg > 3));

        JSIterator filteredIterator = iterator.filter(isGreaterThan3);
        System.out.println("Filtered elements > 3: " + filteredIterator.toArray());
        // Expected Output: Filtered elements > 3: [4, 5, 6]
    }
}
