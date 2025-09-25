package io.github.atur256.webimageinterop.demos.jsJson;

import io.github.atur256.webimageinterop.builtin.JSJson;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class RawJSONDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSJson.rawJSON Demo ===");

        // Create raw JSON using JSString
        JSValue rawFromJSString = JSJson.rawJSON(JSString.of("\"Hello world\""));
        System.out.println("Raw from JSString: " + JSJson.stringify(rawFromJSString));
        System.out.println("Is raw JSON (JSValue): " + JSJson.isRawJSON(rawFromJSString));
        System.out.println("Is raw JSON (Object): " + JSJson.isRawJSON((Object) rawFromJSString));
        // Expected:
        // Raw from JSString: "Hello world"
        // Is raw JSON (JSValue): true
        // Is raw JSON (Object): true

        // Create raw JSON using String
        JSValue rawFromString = JSJson.rawJSON("\"Hello world\"");
        System.out.println("\nRaw from String: " + JSJson.stringify(rawFromString));
        System.out.println("Is raw JSON (JSValue): " + JSJson.isRawJSON(rawFromString));
        System.out.println("Is raw JSON (Object): " + JSJson.isRawJSON((Object) rawFromString));
        // Expected:
        // Raw from String: "Hello world"
        // Is raw JSON (JSValue): true
        // Is raw JSON (Object): true

        // Non-raw JSString
        JSString notRaw = JSString.of("\"Hello world\"");
        System.out.println("\nNot raw (JSString): " + JSJson.stringify(notRaw));
        System.out.println("Is raw JSON (JSValue): " + JSJson.isRawJSON(notRaw));
        System.out.println("Is raw JSON (Object): " + JSJson.isRawJSON((Object) notRaw));
        // Expected:
        // Not raw (JSString): "\"Hello world\""
        // Is raw JSON (JSValue): false
        // Is raw JSON (Object): false

        // Plain Java object
        Object javaObj = java.util.Map.of("status", "ok");
        System.out.println("\nPlain Java object: " + javaObj);
        System.out.println("Is raw JSON (Object): " + JSJson.isRawJSON(javaObj));
        // Expected:
        // Plain Java object: {status=ok}
        // Is raw JSON (Object): false

        // Null input
        System.out.println("\nNull object: " + null);
        System.out.println("Is raw JSON (Object): " + JSJson.isRawJSON((Object) null));
        // Expected:
        // Null object: null
        // Is raw JSON (Object): false
    }
}
