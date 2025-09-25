package io.github.atur256.webimageinterop.demos.jsString;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

public class SplitDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.split Demo ===");

        JSString csv = JSString.of("red,green,blue,yellow");

        // 1) split(String separator)
        JSArray all1 = JSValue.checkedCoerce(csv.split(","), JSArray.class);

        // 2) split(String separator, int limit)
        JSArray limited = JSValue.checkedCoerce(csv.split(",", 2), JSArray.class);

        // 3) split(JSObject separator)
        JSObject regexObject = JSEval.eval("/,/", JSObject.class); // JS regex equivalent of ","
        JSArray allByObject = JSValue.checkedCoerce(csv.split(regexObject), JSArray.class);

        // 4) split(JSObject separator, int limit)
        JSArray limitedByObject = JSValue.checkedCoerce(csv.split(regexObject, 2), JSArray.class);

        // Extra: split into characters with String
        JSArray allChars = JSValue.checkedCoerce(csv.split(""), JSArray.class);

        // Print results
        System.out.println("\"red,green,blue,yellow\".split(\",\"): " + all1.toString());
        System.out.println("\"red,green,blue,yellow\".split(\",\", 2): " + limited.toString());
        System.out.println("\"red,green,blue,yellow\".split(JSObject(/,/)): " + allByObject.toString());
        System.out.println("\"red,green,blue,yellow\".split(JSObject(/,/) , 2): " + limitedByObject.toString());
        System.out.println("\"red,green,blue,yellow\".split(\"\"): " + allChars.toString());

        // Expected:
        // "red,green,blue,yellow".split(","): [red, green, blue, yellow]
        // "red,green,blue,yellow".split(",", 2): [red, green]
        // "red,green,blue,yellow".split(JSObject(/,/)): [red, green, blue, yellow]
        // "red,green,blue,yellow".split(JSObject(/,/), 2): [red, green]
        // "red,green,blue,yellow".split(""): [r, e, d, ,, g, r, e, e, n, ,, b, l, u, e, ,, y, e, l, l, o, w]
    }
}
