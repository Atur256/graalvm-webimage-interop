package io.github.atur256.webimageinterop.demos.jsString;

import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSString;


public class ReplaceDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.replace Demo ===");

        JSString phrase = JSString.of("foo bar foo");

        // String pattern → string replacement
        System.out.println("\"foo bar foo\".replace(\"foo\", \"baz\"): " + phrase.replace("foo", "baz").as(String.class));
        // Expected: "foo bar foo".replace("foo", "baz"): baz bar foo

        // Regex pattern (non-global) → string replacement
        System.out.println("\"foo bar foo\".replace(/foo/, \"baz\"): " + phrase.replace(JSEval.eval("/foo/"), "baz").as(String.class));
        // Expected: "foo bar foo".replace(/foo/, "baz"): baz bar foo

        // Regex with capture group → replacement string using $1
        JSString name = JSString.of("Hello World");
        System.out.println("\"Hello World\".replace(/(\\w+) (\\w+)/, \"$2, $1\"): " + name.replace(JSEval.eval("/(\\w+) (\\w+)/"), "$2, $1").as(String.class));
        // Expected: "Hello World".replace(/(\w+) (\w+)/, "$2, $1"): World, Hello

        // Regex → replacement function
        JSString digits = JSString.of("Price: 42");
        Object replacer = JSEval.eval("(match) => '[' + match + ']'");
        System.out.println("\"Price: 42\".replace(/\\d+/, fn): " + digits.replace(JSEval.eval("/\\d+/"), replacer).as(String.class));
        // Expected: "Price: 42".replace(/\d+/, fn): Price: [42]

        // No match
        System.out.println("\"foo bar foo\".replace(\"xyz\", \"baz\"): " + phrase.replace("xyz", "baz").as(String.class));
        // Expected: "foo bar foo".replace("xyz", "baz"): foo bar foo

        // Numeric replacement
        System.out.println("\"foo bar foo\".replace(\"foo\", 123): " + phrase.replace("foo", 123).as(String.class));
        // Expected: "foo bar foo".replace("foo", 123): 123 bar foo
    }
}
