package demos.jsSet;

import builtin.JSEval;
import builtin.JSFunction;
import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.forEach Demo ===");

        JSSet set = new JSSet();
        set.add(JSString.of("apple")).add(JSString.of("banana"));

        // forEach(callback)
        set.forEach(JSEval.eval("(value => console.log('Item:', value))"));
        // Expected Output:
        // Item: apple
        // Item: banana

        // forEach(callback, thisArg)
        JSFunction callbackWithThis = JSFunction.fromArgs(new String[]{"value", "key", "console.log(this + value);"});
        set.forEach(callbackWithThis, JSString.of("Fruit: "));
        // Expected Output:
        // Fruit: apple
        // Fruit: banana
    }
}
