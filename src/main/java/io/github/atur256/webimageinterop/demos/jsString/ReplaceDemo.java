package io.github.atur256.webimageinterop.demos.jsString;

import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class ReplaceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.replace Demo ===");

        JSString phrase = JSString.of("foo bar foo");

        // String pattern → string replacement
        String result1 = phrase.replace("foo", "baz").as(String.class);
        System.out.println("\"foo bar foo\".replace(\"foo\", \"baz\"): " + result1);
        // Expected: "foo bar foo".replace("foo", "baz"): baz bar foo

        // Regex pattern (non-global) → string replacement
        String result2 = phrase.replace(JSEval.eval("/foo/"), "baz").as(String.class);
        System.out.println("\"foo bar foo\".replace(/foo/, \"baz\"): " + result2);
        // Expected: "foo bar foo".replace(/foo/, "baz"): baz bar foo

        // Regex with capture group → replacement string using $1
        JSString name = JSString.of("Hello World");
        String result3 = name.replace(JSEval.eval("/(\\w+) (\\w+)/"), "$2, $1").as(String.class);
        System.out.println("\"Hello World\".replace(/(\\w+) (\\w+)/, \"$2, $1\"): " + result3);
        // Expected: "Hello World".replace(/(\w+) (\w+)/, "$2, $1"): World, Hello

        // Regex → replacement function
        JSString digits = JSString.of("Price: 42");
        Object replacer = JSEval.eval("(match) => '[' + match + ']'");
        String result4 = digits.replace(JSEval.eval("/\\d+/"), replacer).as(String.class);
        System.out.println("\"Price: 42\".replace(/\\d+/, fn): " + result4);
        // Expected: "Price: 42".replace(/\d+/, fn): Price: [42]

        // No match
        String result5 = phrase.replace("xyz", "baz").as(String.class);
        System.out.println("\"foo bar foo\".replace(\"xyz\", \"baz\"): " + result5);
        // Expected: "foo bar foo".replace("xyz", "baz"): foo bar foo

        // Numeric replacement
        String result6 = phrase.replace("foo", 123).as(String.class);
        System.out.println("\"foo bar foo\".replace(\"foo\", 123): " + result6);
        // Expected: "foo bar foo".replace("foo", 123): 123 bar foo

        // Assert values
        assertEquals("baz bar foo", result1);
        assertEquals("baz bar foo", result2);
        assertEquals("World, Hello", result3);
        assertEquals("Price: [42]", result4);
        assertEquals("foo bar foo", result5);
        assertEquals("123 bar foo", result6);
    }
}