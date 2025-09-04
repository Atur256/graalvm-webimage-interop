package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class CallDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.call Demo ===");

        JSFunction greet = JSFunction.fromBody("return 'Hello ' + arg;");
        JSValue result = greet.call(JSString.of("Alice"));
        System.out.println("Result of greet.call: " + result);
        // Expected: Hello Alice
    }
}
