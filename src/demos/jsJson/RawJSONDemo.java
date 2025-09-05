package demos.jsJson;

import builtin.JSJson;
import org.graalvm.webimage.api.JSString;


public class RawJSONDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSJson.rawJSON Demo ===");

        var raw = JSJson.rawJSON(JSString.of("\"Hello world\""));
        System.out.println("Is raw JSON? " + JSJson.isRawJSON(raw));
        // Expected Output: Is raw JSON? true
    }
}
