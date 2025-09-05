package demos.jsMap;

import builtin.JSArray;
import builtin.JSFunction;
import builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class GroupByDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.groupBy Demo ===");

        // Sample array of strings
        JSArray items = JSArray.of(new JSString[] {
                JSString.of("apple"),
                JSString.of("apricot"),
                JSString.of("banana"),
                JSString.of("blueberry"),
                JSString.of("cherry")
        });

        // Group by first letter
        JSFunction callback = JSFunction.fromArgs(new String[] {
                "item", "return item[0];"
        });

        JSMap grouped = JSMap.groupBy(items, callback);

        // Print grouped entries
        grouped.forEach(JSFunction.fromArgs(new String[] {
                "value", "key", "console.log(key + ': ' + value);"
        }));

        // Expected Output:
        // a: ["apple", "apricot"]
        // b: ["banana", "blueberry"]
        // c: ["cherry"]
    }
}
