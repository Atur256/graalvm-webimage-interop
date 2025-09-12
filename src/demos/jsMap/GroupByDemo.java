package demos.jsMap;

import builtin.JSArray;
import builtin.JSFunction;
import builtin.JSIterator;
import builtin.JSMap;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;

import java.util.Arrays;
import java.util.List;


public class GroupByDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.groupBy Demo ===");

        List<String> fruits = Arrays.asList("apple", "blueberry", "apricot", "cherry", "banana");
        JSArray jsArray = JSArray.of(fruits.toArray());
        JSIterator iterator = JSIterator.from(jsArray);
        JSFunction callback1 = JSFunction.fromGeneralFunction((String item) -> JSString.of(item.substring(0, 1)));
        JSFunction callback2 = JSFunction.fromFunction((JSString item) -> JSString.of(item.as(String.class).substring(0, 1)));

        // Using JSIterator directly
        JSMap groupedFromIterator = JSMap.groupBy(iterator, callback1);
        System.out.println("\nGrouped using JSIterator:");
        printGrouped(groupedFromIterator);
        // Expected Output:
        // Grouped using JSIterator:
        //a: [apple,apricot]
        //b: [blueberry,banana]
        //c: [cherry]

        // Using JSArray
        JSMap groupedFromArray = JSMap.groupBy(jsArray, callback1);
        System.out.println("\nGrouped using JSArray:");
        printGrouped(groupedFromArray);
        // Expected Output:
        // Grouped using JSArray:
        //a: [apple,apricot]
        //b: [blueberry,banana]
        //c: [cherry]

        // Using List<String>
        JSMap groupedFromList = JSMap.groupBy(fruits, callback2);
        System.out.println("\nGrouped using List<String>:");
        printGrouped(groupedFromList);
        // Expected Output:
        // Grouped using List<String>:
        //a: [apple,apricot]
        //b: [blueberry,banana]
        //c: [cherry]
    }

    private static void printGrouped(JSMap grouped) {
        grouped.forEach(JSFunction.fromBiConsumer((JSObject value, JSString key) ->
                System.out.println(key.as(String.class) + ": " + value.as(JSArray.class))
        ));
    }
}
