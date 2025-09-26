package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.*;

import static org.junit.Assert.assertEquals;


public class BindDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.bind Demo ===");

        JSFunction greet = JSFunction.fromArgs("name", "return this + name;");

        // Bind with JSValue (JSString)
        JSFunction boundJSValue = greet.bind(JSString.of("JSValue: "));
        String result1 = boundJSValue.callJS("Alice", String.class);
        assertEquals("JSValue: Alice", result1);
        System.out.println("Bind with JSValue result: " + result1);
        // Expected: Bind with JSValue result: JSValue: Alice

        // Bind with int
        JSFunction boundInt = greet.bind(123);
        String result2 = boundInt.callJS("Bob", String.class);
        assertEquals("123Bob", result2);
        System.out.println("Bind with int result: " + result2);
        // Expected: Bind with int result: 123Bob

        // Bind with double
        JSFunction boundDouble = greet.bind(3.14);
        String result3 = boundDouble.callJS("Charlie", String.class);
        assertEquals("3.14Charlie", result3);
        System.out.println("Bind with double result: " + result3);
        // Expected: Bind with double result: 3.14Charlie

        // Bind with boolean
        JSFunction boundBoolean = greet.bind(true);
        String result4 = boundBoolean.callJS("Dana", String.class);
        assertEquals("trueDana", result4);
        System.out.println("Bind with boolean result: " + result4);
        // Expected: Bind with boolean result: trueDana

        // Bind with Object (Java String)
        JSFunction boundObject = greet.bind("Custom: ");
        String result5 = boundObject.callJS("Eve", String.class);
        assertEquals("Custom: Eve", result5);
        System.out.println("Bind with Object result: " + result5);
        // Expected: Bind with Object result: Custom: Eve

        // Bind with JSObject
        JSObject context = JSObject.create();
        context.set("prefix", JSString.of("Hello "));
        JSFunction greetWithPrefix = JSFunction.fromArgs("name", "return this.prefix + name;");
        JSFunction boundJSObject = greetWithPrefix.bind(context);
        String result6 = boundJSObject.callJS("Frank", String.class);
        assertEquals("Hello Frank", result6);
        System.out.println("Bind with JSObject result: " + result6);
        // Expected: Bind with JSObject result: Hello Frank
    }
}
