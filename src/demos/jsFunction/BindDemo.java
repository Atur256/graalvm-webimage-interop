package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSObject;

public class BindDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.bind Demo ===");

        JSFunction greet = JSFunction.fromArgs(new String[]{"name", "return this.prefix + name;"});
        JSObject context = JSObject.create();
        context.set("prefix", "Hi ");
        JSFunction bound = greet.bind(context);

        var result = bound.call("Alice");
        System.out.println("Result of bound.call: " + result);
        // Expected: Hi Alice
    }
}
