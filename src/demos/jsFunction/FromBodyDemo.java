package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;


public class FromBodyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromBody Demo ===");

        JSFunction greet = JSFunction.fromBody("return 'Hello ' + arg;");
        String result = greet.callJS("Alice", String.class);
        System.out.println("Result: " + result);
        // Expected: Hello Alice
    }
}
