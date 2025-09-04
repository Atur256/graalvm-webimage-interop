package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class BindDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.bind Demo ===");

        JSFunction greet = JSFunction.fromArgs(new String[] {"name", "return this.prefix + name;"});
        JSObject context = JSObject.create();
        context.set("prefix", JSString.of("Hi "));
        JSFunction bound = greet.bind(context);

        JSValue result = bound.call(JSString.of("Alice"));
        System.out.println("Result of bound.call: " + result);
        // Expected: Hi Alice
    }

}
