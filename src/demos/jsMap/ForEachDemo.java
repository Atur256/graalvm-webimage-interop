package demos.jsMap;

import builtin.JSFunction;
import builtin.JSMap;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;

public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSMap.forEach Demo ===");

        JSMap map = new JSMap();
        map.set("a", 1);
        map.set("b", 2);

        // forEach(callback)
        System.out.println("\n-- forEach(callback) --");
        JSFunction callback = JSFunction.fromGeneralBiConsumer((JSNumber value, JSString key) ->
                System.out.println("Key: " + key.as(String.class) + ", Value: " + value.as(Integer.class)));
        map.forEach(callback);
        // Expected:
        // Key: a, Value: 1
        // Key: b, Value: 2

        // forEach(callback, JSValue thisArg)
        System.out.println("\n-- forEach(callback, JSValue thisArg) --");
        JSFunction callbackWithJSValue = JSFunction.fromArgs("value", "key", "console.log(this + key + '=' + value);");
        map.forEach(callbackWithJSValue, JSString.of("JSValue: "));
        // Expected:
        // JSValue: a=1
        // JSValue: b=2

        // forEach(callback, int thisArg)
        System.out.println("\n-- forEach(callback, int thisArg) --");
        JSFunction callbackWithInt = JSFunction.fromArgs("value", "key", "console.log(this + ': ' + key + '=' + value);");
        map.forEach(callbackWithInt, 100);
        // Expected:
        // 100: a=1
        // 100: b=2

        // forEach(callback, double thisArg)
        System.out.println("\n-- forEach(callback, double thisArg) --");
        JSFunction callbackWithDouble = JSFunction.fromArgs("value", "key", "console.log(this + ': ' + key + '=' + value);");
        map.forEach(callbackWithDouble, 3.14);
        // Expected:
        // 3.14: a=1
        // 3.14: b=2

        // forEach(callback, boolean thisArg)
        System.out.println("\n-- forEach(callback, boolean thisArg) --");
        JSFunction callbackWithBoolean = JSFunction.fromArgs("value", "key", "console.log(this + ': ' + key + '=' + value);");
        map.forEach(callbackWithBoolean, true);
        // Expected:
        // true: a=1
        // true: b=2

        // forEach(callback, Object thisArg)
        System.out.println("\n-- forEach(callback, Object thisArg) --");
        JSFunction callbackWithObject = JSFunction.fromArgs("value", "key", "console.log(this + ': ' + key + '=' + value);");
        map.forEach(callbackWithObject, "CustomObject");
        // Expected:
        // CustomObject: a=1
        // CustomObject: b=2
    }
}
