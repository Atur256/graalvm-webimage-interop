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
        String result1 = describe.callJS("Hello", String.class);
        System.out.println("callJS(String): " + result1);
        // Expected: string: Hello

        // === Call with Integer
        String result2 = describe.callJS(42, String.class);
        System.out.println("callJS(Integer): " + result2);
        // Expected: number: 42

        // === Call with Double
        String result3 = describe.callJS(3.14, String.class);
        System.out.println("callJS(Double): " + result3);
        // Expected: number: 3.14

        // === Call with Boolean
        String result4 = describe.callJS(true, String.class);
        System.out.println("callJS(Boolean): " + result4);
        // Expected: boolean: true

        // === Call with JSValue
        JSValue jsStr = JSString.of("JSValue string");
        String result5 = describe.callJS(jsStr, String.class);
        System.out.println("callJS(JSValue): " + result5);
        // Expected: string: JSValue string
    }
}
