package io.github.atur256.webimageinterop.demos.jsString;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class MatchDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.match Demo ===");

        JSString phrase = JSString.of("Hello 123 World 456");
        JSString mixed = JSString.of("Hello 123 World ABC xyz");

        // Literal match
        String result1 = JSValue.checkedCoerce(phrase.match("World"), JSArray.class).toString();
        System.out.printf("\"%s\".match(\"World\"): %s%n", phrase.asString(), result1);
        // Expected: "Hello 123 World 456".match("World"): [World]

        // Match all uppercase letters using /[A-Z]/g
        String result2 = JSValue.checkedCoerce(mixed.match(JSEval.eval("/[A-Z]/g")), JSArray.class).toString();
        System.out.printf("\"%s\".match(\"/[A-Z]/g\"): %s%n", mixed.asString(), result2);
        // Expected: "Hello 123 World ABC xyz".match("/[A-Z]/g"): [H,W,A,B,C]

        // Digit match (first only)
        String result3 = JSValue.checkedCoerce(phrase.match("\\d+"), JSArray.class).toString();
        System.out.printf("\"%s\".match(\"\\d+\"): %s%n", phrase.asString(), result3);
        // Expected: "Hello 123 World 456".match("\d+"): [123]

        // Global digit match
        String result4 = JSValue.checkedCoerce(phrase.match(JSEval.eval("/\\d+/g")), JSArray.class).toString();
        System.out.printf("\"%s\".match(\"/\\d+/g\"): %s%n", phrase.asString(), result4);
        // Expected: "Hello 123 World 456".match("/\d+/g"): [123,456]


        // No match
        Object result5 = phrase.match("XYZ");
        System.out.printf("\"%s\".match(\"XYZ\"): %s%n", phrase.asString(), result5);
        // Expected: "Hello 123 World 456".match("XYZ"): null

        // Assert values
        assertEquals("[World]", result1);
        assertEquals("[H,W,A,B,C]", result2);
        assertEquals("[123]", result3);
        assertEquals("[123,456]", result4);
        assertNull(result5);
    }
}