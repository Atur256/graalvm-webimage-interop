package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.*;


public class BindDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.bind Demo ===");

        JSFunction greet = JSFunction.fromArgs("name", "return this + name;");

        // Bind with JSValue (JSString)
        JSFunction boundJSValue = greet.bind(JSString.of("JSValue: "));
        String resultJSValue = boundJSValue.callJS("Alice", String.class);
        System.out.println("Bind with JSValue result: " + resultJSValue);
        // Expected: Bind with JSValue result: JSValue: Alice

        // Bind with int
        JSFunction boundInt = greet.bind(123);
        String resultInt = boundInt.callJS("Bob", String.class);
        System.out.println("Bind with int result: " + resultInt);
        // Expected: Bind with int result:  123Bob

        // Bind with double
        JSFunction boundDouble = greet.bind(3.14);
        String resultDouble = boundDouble.callJS("Charlie", String.class);
        System.out.println("Bind with double result: " + resultDouble);
        // Expected: Bind with double result: 3.14Charlie

        // Bind with boolean
        JSFunction boundBoolean = greet.bind(true);
        String resultBoolean = boundBoolean.callJS("Dana", String.class);
        System.out.println("Bind with boolean result: " + resultBoolean);
        // Expected: Bind with boolean result: trueDana

        // Bind with Object (Java String)
        JSFunction boundObject = greet.bind("Custom: ");
        String resultObject = boundObject.callJS("Eve", String.class);
        System.out.println("Bind with Object result: " + resultObject);
        // Expected: Bind with Object result: Custom: Eve

        // Bind with JSObject
        JSObject context = JSObject.create();
        context.set("prefix", JSString.of("Hello "));
        JSFunction greetWithPrefix = JSFunction.fromArgs("name", "return this.prefix + name;");
        JSFunction boundJSObject = greetWithPrefix.bind(context);
        String resultJSObject = boundJSObject.callJS("Frank", String.class);
        System.out.println("Bind with JSObject result: " + resultJSObject);
        // Expected: Bind with JSObject result: Hello Frank
    }
}
