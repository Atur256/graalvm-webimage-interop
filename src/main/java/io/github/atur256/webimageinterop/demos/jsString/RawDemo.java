package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class RawDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.raw Demo ===");

        JSObject template = JSObject.create();
        template.set("raw", new String[]{"Line1\n", "Line2\t", "End"});

        // Call raw(template) — no substitutions
        String rawOnly = JSString.raw(template).as(String.class);
        System.out.println("String.raw(template): \"" + rawOnly + "\"");
        // Expected:
        // String.raw(template) → String.raw(template): "Line1
        // Line2	End"

        // Call raw(template, substitutions)
        String withSubs = JSString.raw(template, "A", "B").as(String.class);
        System.out.println("String.raw(template, \"A\", \"B\"): \"" + withSubs + "\"");
        // Expected:
        // String.raw(template, "A", "B"): "Line1
        // ALine2	BEnd"

        // Assert values
        System.out.println("Test - 1");
        assertEquals("Line1\nLine2\tEnd", rawOnly);
        System.out.println("Test - 2");
        assertEquals("Line1\nALine2\tBEnd", withSubs);
    }
}