package demos.jsJson;

import builtin.JSJson;
import org.graalvm.webimage.api.JSString;


public class IsRawJSONDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSJson.isRawJSON Demo ===");

        var raw = JSJson.rawJSON(JSString.of("\"Hello world\""));
        boolean result = JSJson.isRawJSON(raw);

        System.out.println("Is raw JSON? " + result);
        // Expected Output: Is raw JSON? true

        var notRaw = JSString.of("\"Hello world\"");
        boolean result2 = JSJson.isRawJSON(notRaw);

        System.out.println("Is raw JSON? " + result2);
        // Expected Output: Is raw JSON? false
    }
}
