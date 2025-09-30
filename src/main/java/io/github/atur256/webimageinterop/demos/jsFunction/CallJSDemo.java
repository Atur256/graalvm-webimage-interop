package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class CallJSDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.callJS Demo ===");

        // JS function: return typeof arg + ": " + arg;
        JSFunction describe = JSFunction.fromBody("return typeof arg + ': ' + arg;");

        // Call with Java String
        String result1 = describe.callJS("Hello", String.class);
        System.out.println("callJS(String): " + result1);
        // Expected: callJS(String): string: Hello

        // Call with Integer
        String result2 = describe.callJS(42, String.class);
        System.out.println("callJS(Integer): " + result2);
        // Expected: callJS(Integer): number: 42

        // Call with Double
        String result3 = describe.callJS(3.14, String.class);
        System.out.println("callJS(Double): " + result3);
        // Expected: callJS(Double): number: 3.14

        // Call with Boolean
        String result4 = describe.callJS(true, String.class);
        System.out.println("callJS(Boolean): " + result4);
        // Expected: callJS(Boolean): boolean: true

        // Call with JSValue
        JSValue jsStr = JSString.of("JSValue string");
        String result5 = describe.callJS(jsStr, String.class);
        System.out.println("callJS(JSValue): " + result5);
        // Expected: callJS(JSValue): string: JSValue string

        // Assert values
        assertEquals("string: Hello", result1);
        assertEquals("number: 42", result2);
        assertEquals("number: 3.14", result3);
        assertEquals("boolean: true", result4);
        assertEquals("string: JSValue string", result5);
    }
}