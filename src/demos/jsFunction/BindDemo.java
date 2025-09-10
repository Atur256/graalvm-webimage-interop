package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.*;


public class BindDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.bind Demo ===");

        // === JS-defined function ===
        JSFunction greet = JSFunction.fromArgs(new String[]{"name", "return this.prefix + name;"});

        JSObject context = JSObject.create();
        context.set("prefix", JSString.of("Hi "));
        JSFunction bound1 = greet.bind(context);
        String result1 = bound1.callJS("Alice", String.class);
        System.out.println("JSObject bind result: " + result1); // Expected: Hi Alice

        context.set("prefix", JSString.of("Hello "));
        JSFunction bound2 = greet.bind(context);
        String result2 = bound2.callJS("Bob", String.class);
        System.out.println("Java String bind result: " + result2); // Expected: Hello Bob

        context.set("prefix", JSNumber.of(100));
        JSFunction bound3 = greet.bind(context);
        String result3 = bound3.callJS("Charlie", String.class);
        System.out.println("Java Integer bind result: " + result3); // Expected: 100Charlie

        context.set("prefix", JSBoolean.of(true));
        JSFunction bound4 = greet.bind(context);
        String result4 = bound4.callJS("Dana", String.class);
        System.out.println("Java Boolean bind result: " + result4); // Expected: trueDana
    }
}
