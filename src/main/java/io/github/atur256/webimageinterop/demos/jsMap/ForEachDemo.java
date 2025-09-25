package io.github.atur256.webimageinterop.demos.jsMap;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.builtin.JSMap;
import org.graalvm.webimage.api.*;


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
        JSFunction callbackWithJSValue = JSFunction.fromTriConsumer((JSValue thisArg, JSNumber value, JSString key) ->
                System.out.println(thisArg.as(String.class) + ": " + key.as(String.class) + "=" + value.as(Integer.class)));
        map.forEach(callbackWithJSValue, JSString.of("JSValue: "));
        // Expected:
        // JSValue: a=1
        // JSValue: b=2

        // forEach(callback, int thisArg)
        System.out.println("\n-- forEach(callback, int thisArg) --");
        JSFunction callbackWithInt = JSFunction.fromTriConsumer((JSNumber thisArg, JSNumber value, JSString key) ->
                System.out.println(thisArg.as(Integer.class) + ": " + key.as(String.class) + "=" + value.as(Integer.class)));
        map.forEach(callbackWithInt, 100);
        // Expected:
        // 100: a=1
        // 100: b=2

        // forEach(callback, double thisArg)
        System.out.println("\n-- forEach(callback, double thisArg) --");
        JSFunction callbackWithDouble = JSFunction.fromTriConsumer((JSNumber thisArg, JSNumber value, JSString key) ->
                System.out.println(thisArg.as(Double.class) + ": " + key.as(String.class) + "=" + value.as(Integer.class)));
        map.forEach(callbackWithDouble, 3.14);
        // Expected:
        // 3.14: a=1
        // 3.14: b=2

        // forEach(callback, boolean thisArg)
        System.out.println("\n-- forEach(callback, boolean thisArg) --");
        JSFunction callbackWithBoolean = JSFunction.fromTriConsumer((JSBoolean thisArg, JSNumber value, JSString key) ->
                System.out.println(thisArg.as(Boolean.class) + ": " + key.as(String.class) + "=" + value.as(Integer.class)));
        map.forEach(callbackWithBoolean, true);
        // Expected:
        // true: a=1
        // true: b=2

        // forEach(callback, Object thisArg)
        System.out.println("\n-- forEach(callback, Object thisArg) --");
        JSFunction callbackWithObject = JSFunction.fromTriConsumer((JSString thisArg, JSNumber value, JSString key) ->
                System.out.println(thisArg.as(String.class) + ": " + key.as(String.class) + "=" + value.as(Integer.class)));
        map.forEach(callbackWithObject, "CustomObject");
        // Expected:
        // CustomObject: a=1
        // CustomObject: b=2
    }
}
