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
        JSString result1 = bound1.callJS("Alice");
        System.out.println("JSObject bind result: " + result1.as(String.class)); // Expected: Hi Alice

        context.set("prefix", JSString.of("Hello "));
        JSFunction bound2 = greet.bind(context);
        JSString result2 = bound2.callJS("Bob");
        System.out.println("Java String bind result: " + result2.as(String.class)); // Expected: Hello Bob

        context.set("prefix", JSNumber.of(100));
        JSFunction bound3 = greet.bind(context);
        JSString result3 = bound3.callJS("Charlie");
        System.out.println("Java Integer bind result: " + result3.as(String.class)); // Expected: 100Charlie

        context.set("prefix", JSBoolean.of(true));
        JSFunction bound4 = greet.bind(context);
        JSString result4 = bound4.callJS("Dana");
        System.out.println("Java Boolean bind result: " + result4.as(String.class)); // Expected: trueDana
    }
}
