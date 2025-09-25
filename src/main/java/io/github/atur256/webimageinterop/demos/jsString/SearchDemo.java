package io.github.atur256.webimageinterop.demos.jsString;

import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSString;


public class SearchDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.search Demo ===");

        JSString text = JSString.of("Find 42 here");

        // RegExp pattern
        System.out.println("\"Find 42 here\".search(/\\d+/): " + text.search(JSEval.eval("/\\d+/")));
        // Literal string pattern (converted to RegExp internally)
        System.out.println("\"Find 42 here\".search(\"Find\"): " + text.search("Find"));
        // Case-sensitive search
        System.out.println("\"Find 42 here\".search(/find/): " + text.search(JSEval.eval("/find/")));
        // Case-insensitive search
        System.out.println("\"Find 42 here\".search(/find/i): " + text.search(JSEval.eval("/find/i")));
        // Anchored pattern
        System.out.println("\"Find 42 here\".search(/^42/): " + text.search(JSEval.eval("/^42/")));
        // No match
        System.out.println("\"Find 42 here\".search(\"XYZ\"): " + text.search("XYZ"));
        // Expected:
        // "Find 42 here".search(/\d+/): 5
        // "Find 42 here".search("Find"): 0
        // "Find 42 here".search(/find/): -1
        // "Find 42 here".search(/find/i): 0
        // "Find 42 here".search(/^42/): -1
        // "Find 42 here".search("XYZ"): -1
    }
}
