package demos.jsFunction;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class FromArgsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromArgs Demo ===");

        JSFunction greet = JSFunction.fromArgs(new String[]{
                "name", "greeting", "console.log(greeting + ', ' + name + '!')"
        });

        // Call the function with arguments
        greet.callWithArgs(null, JSArray.of(new JSValue[]{
                JSString.of("Alice"),
                JSString.of("Welcome")}
        ));

        // Expected Output:
        // Welcome, Alice!
    }
}
