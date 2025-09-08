package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class CallJSDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.callJS Demo ===");

        // JS function: return typeof arg + ": " + arg;
        JSFunction describe = JSFunction.fromBody("return typeof arg + ': ' + arg;");

        // === Call with Java String
        JSString result1 = describe.callJS("Hello");
        System.out.println("callJS(String): " + result1.as(String.class));
        // Expected: string: Hello

        // === Call with Integer
        JSString result2 = describe.callJS(42);
        System.out.println("callJS(Integer): " + result2.as(String.class));
        // Expected: number: 42

        // === Call with Double
        JSString result3 = describe.callJS(3.14);
        System.out.println("callJS(Double): " + result3.as(String.class));
        // Expected: number: 3.14

        // === Call with Boolean
        JSString result4 = describe.callJS(true);
        System.out.println("callJS(Boolean): " + result4.as(String.class));
        // Expected: boolean: true

        // === Call with JSValue
        JSValue jsStr = JSString.of("JSValue string");
        JSString result5 = describe.callJS(jsStr);
        System.out.println("callJS(JSValue): " + result5.as(String.class));
        // Expected: string: JSValue string
    }
}
