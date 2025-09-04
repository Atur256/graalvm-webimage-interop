package demos.jsMap;

import builtin.JSFunction;
import builtin.JSMap;
import org.graalvm.webimage.api.JSString;


public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.forEach Demo ===");

        JSMap map = new JSMap();
        map.set(JSString.of("a"), JSString.of("1"));
        map.set(JSString.of("b"), JSString.of("2"));

        // forEach(callback)
        System.out.println("\n-- forEach(callback) --");
        JSFunction callback = JSFunction.fromArgs(new String[]{"value", "key", "console.log('Key:', key, 'Value:', value);"});
        map.forEach(callback);

        // Expected Output:
        // -- forEach(callback) --
        // Key: a Value: 1
        // Key: b Value: 2

        // forEach(callback, thisArg)
        System.out.println("\n-- forEach(callback, thisArg) --");
        JSFunction callbackWithThis = JSFunction.fromArgs(new String[]{"value", "key", "console.log(this + key + '=' + value);"});
        map.forEach(callbackWithThis, JSString.of(">> "));

        // Expected Output:
        // -- forEach(callback, thisArg) --
        // >> a=1
        // >> b=2
    }
}
