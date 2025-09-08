package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;


public class FromBodyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromBody Demo ===");

        JSFunction greet = JSFunction.fromBody("return 'Hello ' + arg;");
        JSString result = greet.callJS("Alice");
        System.out.println("Result: " + result.as(String.class));
        // Expected: Hello Alice
    }
}
