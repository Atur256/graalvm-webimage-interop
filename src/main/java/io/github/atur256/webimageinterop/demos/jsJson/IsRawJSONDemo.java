package io.github.atur256.webimageinterop.demos.jsJson;

import io.github.atur256.webimageinterop.builtin.JSJson;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

public class IsRawJSONDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSJson.isRawJSON Demo ===");

        // 1Raw JSON via JSString
        JSValue raw = JSJson.rawJSON(JSString.of("\"Hello world\""));
        boolean result1 = JSJson.isRawJSON(raw);
        System.out.println("isRawJSON(JSValue) [raw]: " + result1);
        // Expected: isRawJSON(JSValue) [raw]: true

        // Non-raw JSString
        JSString notRaw = JSString.of("\"Hello world\"");
        boolean result2 = JSJson.isRawJSON(notRaw);
        System.out.println("isRawJSON(JSValue) [not raw]: " + result2);
        // Expected: isRawJSON(JSValue) [not raw]: false

        // Raw JSON via String (Object overload)
        String rawText = "{\"status\":\"ok\"}";
        boolean result3 = JSJson.isRawJSON(rawText);
        System.out.println("isRawJSON(Object) [String]: " + result3);
        // Expected: isRawJSON(Object) [String]: false

        // Raw JSON via JSValue passed as Object
        boolean result4 = JSJson.isRawJSON((Object) raw);
        System.out.println("isRawJSON(Object) [JSValue raw]: " + result4);
        // Expected: isRawJSON(Object) [JSValue raw]: true

        // Plain Java object
        Object plainObj = java.util.Map.of("status", "ok");
        boolean result5 = JSJson.isRawJSON(plainObj);
        System.out.println("isRawJSON(Object) [Java Map]: " + result5);
        // Expected: isRawJSON(Object) [Java Map]: false
    }
}
