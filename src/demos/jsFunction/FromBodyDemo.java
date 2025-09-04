package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;


public class FromBodyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromBody Demo ===");

        JSFunction logArg = JSFunction.fromBody("console.log('Received:', arg)");

        logArg.call(JSString.of("Hello from fromBody"));
        // Expected Output:
        // Received: Hello from fromBody
    }
}
