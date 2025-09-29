package io.github.atur256.webimageinterop.demos.jsString;

import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class SearchDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.search Demo ===");

        JSString text = JSString.of("Find 42 here");

        // RegExp pattern
        int result1 = text.search(JSEval.eval("/\\d+/"));
        System.out.println("\"Find 42 here\".search(/\\d+/): " + result1);
        // Literal string pattern (converted to RegExp internally)
        int result2 = text.search("Find");
        System.out.println("\"Find 42 here\".search(\"Find\"): " + result2);
        // Case-sensitive search
        int result3 = text.search(JSEval.eval("/find/"));
        System.out.println("\"Find 42 here\".search(/find/): " + result3);
        // Case-insensitive search
        int result4 = text.search(JSEval.eval("/find/i"));
        System.out.println("\"Find 42 here\".search(/find/i): " + result4);
        // Anchored pattern
        int result5 = text.search(JSEval.eval("/^42/"));
        System.out.println("\"Find 42 here\".search(/^42/): " + result5);
        // No match
        int result6 = text.search("XYZ");
        System.out.println("\"Find 42 here\".search(\"XYZ\"): " + result6);
        // Expected:
        // "Find 42 here".search(/\d+/): 5
        // "Find 42 here".search("Find"): 0
        // "Find 42 here".search(/find/): -1
        // "Find 42 here".search(/find/i): 0
        // "Find 42 here".search(/^42/): -1
        // "Find 42 here".search("XYZ"): -1

        // Assert values
        assertEquals(5, result1);
        assertEquals(0, result2);
        assertEquals(-1, result3);
        assertEquals(0, result4);
        assertEquals(-1,result5);
        assertEquals(-1,result6);
    }
}