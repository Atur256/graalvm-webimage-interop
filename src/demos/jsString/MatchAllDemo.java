package demos.jsString;

import builtin.JSArray;
import builtin.JSEval;
import builtin.JSIterator;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class MatchAllDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.matchAll Demo ===");

        JSString phrase = JSString.of("Price: $12, Discount: $5, Tax: $2");

        // Match all dollar amounts with capture group
        JSValue iterator = phrase.matchAll(JSEval.eval("/\\$(\\d+)/g"));
        JSArray results = JSValue.checkedCoerce(iterator, JSIterator.class).toArray();

        for (int i = 0; i < results.length; i++) {
            JSObject entry = (JSObject) results.get(i);
            System.out.println("Full match: " + JSValue.checkedCoerce(entry.get(0), String.class));
            System.out.println("Captured amount: " +  JSValue.checkedCoerce(entry.get(1), String.class));
            System.out.println("---");
        }
        // Expected:
        // Full match: $12
        // Captured amount: 12
        // ---
        // Full match: $5
        // Captured amount: 5
        // ---
        // Full match: $2
        // Captured amount: 2
        // ---
    }
}
