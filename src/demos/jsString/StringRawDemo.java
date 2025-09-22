package demos.jsString;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;


public class StringRawDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.raw Demo ===");

        JSObject template = JSObject.create();
        template.set("raw", new String[]{"Line1\\n", "Line2\\t", "End"});

        // Call raw(template) — no substitutions
        JSString rawOnly = JSString.raw(template);
        System.out.println("String.raw(template): \"" + rawOnly.as(String.class) + "\"");
        // Expected: String.raw(template) → "Line1\nLine2\tEnd"

        // Call raw(template, substitutions)
        JSString withSubs = JSString.raw(template, "A", "B");
        System.out.println("String.raw(template, \"A\", \"B\"): \"" + withSubs.as(String.class) + "\"");
        // Expected: String.raw(template, "A", "B") → "Line1\nALine2\tBEnd"
    }
}
