package io.github.atur256.webimageinterop.demos.jsString;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import io.github.atur256.webimageinterop.builtin.JSIterator;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class MatchAllDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.matchAll Demo ===");

        JSString phrase = JSString.of("Price: $12, Discount: $5, Tax: $2");

        // Match all dollar amounts with capture group
        JSObject iterator = phrase.matchAll(JSEval.eval("/\\$(\\d+)/g"));
        JSArray results = JSValue.checkedCoerce(iterator, JSIterator.class).toArray();

        for(int i = 0; i < results.length; i++) {
            JSObject entry = JSValue.checkedCoerce(results.get(i), JSObject.class);
            System.out.println("Full match: " + JSValue.checkedCoerce(entry.get(0), String.class));
            System.out.println("Captured amount: " + JSValue.checkedCoerce(entry.get(1), String.class));
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

        // Assert values
        assertEquals(3, results.length);
        JSObject pair1 = JSValue.checkedCoerce(results.get(0), JSObject.class);
        JSObject pair2 = JSValue.checkedCoerce(results.get(1), JSObject.class);
        JSObject pair3 = JSValue.checkedCoerce(results.get(2), JSObject.class);
        assertEquals("$12", JSValue.checkedCoerce(pair1.get(0), String.class));
        assertEquals("12", JSValue.checkedCoerce(pair1.get(1), String.class));
        assertEquals("$5", JSValue.checkedCoerce(pair2.get(0), String.class));
        assertEquals("5", JSValue.checkedCoerce(pair2.get(1), String.class));
        assertEquals("$2", JSValue.checkedCoerce(pair3.get(0), String.class));
        assertEquals("2", JSValue.checkedCoerce(pair3.get(1), String.class));
    }
}