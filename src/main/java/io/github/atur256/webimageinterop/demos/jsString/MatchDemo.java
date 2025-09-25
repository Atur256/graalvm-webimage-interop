package io.github.atur256.webimageinterop.demos.jsString;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class MatchDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.match Demo ===");

        JSString phrase = JSString.of("Hello 123 World 456");
        JSString mixed = JSString.of("Hello 123 World ABC xyz");

        // Literal match
        Object result1 = phrase.match("World");
        System.out.printf("\"%s\".match(\"World\"): %s%n", phrase.asString(), JSValue.checkedCoerce(result1, JSArray.class).toString());
        // Expected: "Hello 123 World 456".match("World"): [World]

        // Match all uppercase letters using /[A-Z]/g
        Object result2 = mixed.match(JSEval.eval("/[A-Z]/g"));
        System.out.printf("\"%s\".match(\"/[A-Z]/g\"): %s%n", mixed.asString(), JSValue.checkedCoerce(result2, JSArray.class).toString());
        // Expected: "Hello 123 World ABC xyz".match("/[A-Z]/g"): [H,W,A,B,C]

        // Digit match (first only)
        Object result3 = phrase.match("\\d+");
        System.out.printf("\"%s\".match(\"\\d+\"): %s%n", phrase.asString(), JSValue.checkedCoerce(result3, JSArray.class).toString());
        // Expected: "Hello 123 World 456".match("\d+"): [123]

        // Global digit match
        Object result4 = phrase.match(JSEval.eval("/\\d+/g"));
        System.out.printf("\"%s\".match(\"/\\d+/g\"): %s%n", phrase.asString(), JSValue.checkedCoerce(result4, JSArray.class).toString());
        // Expected: "Hello 123 World 456".match("/\d+/g"): [123,456]


        // No match
        Object result5 = phrase.match("XYZ");
        System.out.printf("\"%s\".match(\"XYZ\"): %s%n", phrase.asString(), result5);
        // Expected: "Hello 123 World 456".match("XYZ"): null
    }
}
