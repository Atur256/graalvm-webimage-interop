package demos.jsSet;

import builtin.JSFunction;
import builtin.JSSet;
import org.graalvm.webimage.api.*;


public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.forEach Demo ===");

        JSSet set = new JSSet();
        set.add(1).add(2);

        // forEach(callback)
        System.out.println("\n-- forEach(callback) --");
        JSFunction callback = JSFunction.fromGeneralConsumer((JSNumber value) ->
                System.out.println("Value: " + value.as(Integer.class)));
        set.forEach(callback);
        // Expected:
        // Value: 1
        // Value: 2

        // forEach(callback, JSValue thisArg)
        System.out.println("\n-- forEach(callback, JSValue thisArg) --");
        JSFunction callbackWithJSValue = JSFunction.fromTriConsumer((JSValue thisArg, JSNumber value, JSNumber _) ->
                System.out.println(thisArg.as(String.class) + ": " + value.as(Integer.class))
        );
        set.forEach(callbackWithJSValue, JSString.of("JSValue: "));
        // Expected:
        // JSValue: 1
        // JSValue: 2

        // forEach(callback, int thisArg)
        System.out.println("\n-- forEach(callback, int thisArg) --");
        JSFunction callbackWithInt = JSFunction.fromTriConsumer((JSNumber thisArg, JSNumber value, JSNumber _) -> {
            System.out.println(thisArg.as(Integer.class) + ": " + value.as(Integer.class));
        });

        set.forEach(callbackWithInt, 100);
        // Expected:
        // 100: 1
        // 100: 2

        // forEach(callback, double thisArg)
        System.out.println("\n-- forEach(callback, double thisArg) --");
        JSFunction callbackWithDouble = JSFunction.fromTriConsumer((JSNumber thisArg, JSNumber value, JSNumber _) ->
                System.out.println(thisArg.as(Double.class) + ": " + value.as(Integer.class)));
        set.forEach(callbackWithDouble, 3.14);
        // Expected:
        // 3.14: 1
        // 3.14: 2

        // forEach(callback, boolean thisArg)
        System.out.println("\n-- forEach(callback, boolean thisArg) --");
        JSFunction callbackWithBoolean = JSFunction.fromTriConsumer((JSBoolean thisArg, JSNumber value, JSNumber _) ->
                System.out.println(thisArg.as(Boolean.class) + ": " + value.as(Integer.class)));
        set.forEach(callbackWithBoolean, true);
        // Expected:
        // true: 1
        // true: 2

        // forEach(callback, Object thisArg)
        System.out.println("\n-- forEach(callback, Object thisArg) --");
        JSFunction callbackWithObject = JSFunction.fromTriConsumer((JSString thisArg, JSNumber value, JSNumber _) ->
                System.out.println(thisArg.as(String.class) + ": " + value.as(Integer.class)));
        set.forEach(callbackWithObject, "CustomObject");
        // Expected:
        // CustomObject: 1
        // CustomObject: 2
    }
}
