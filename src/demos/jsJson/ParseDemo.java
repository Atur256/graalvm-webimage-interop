package demos.jsJson;

import builtin.JSFunction;
import builtin.JSJson;
import org.graalvm.webimage.api.*;


public class ParseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSJson.parse Demo ===");

        // Basic parse
        JSObject parsedJson = (JSObject) JSJson.parse("{\"name\":\"Alice\",\"age\":30}");
        System.out.println("Parsed object: " + parsedJson);
        System.out.println("Name: " + ((JSString) parsedJson.get("name")).as(String.class));
        System.out.println("Age: " + ((JSNumber) parsedJson.get("age")).as(Integer.class));
        // Expected:
        // Parsed object: JavaScript<object; [object Object]>
        // Name: Alice
        // Age: 30

        // Parse with reviver (increment age)
        JSFunction reviver = JSJson.fromReviver((JSString key, JSValue value) -> {
            if(JSString.of("age").equals(key) && value instanceof JSNumber num) {
                return JSNumber.of(num.as(Integer.class) + 1);
            }
            return value;
        });

        JSObject revivedJson = (JSObject) JSJson.parse("{\"name\":\"Bob\",\"age\":40}", reviver);
        System.out.println("\nParsed with reviver:");
        System.out.println("Name: " + ((JSString) revivedJson.get("name")).as(String.class));
        System.out.println("Age: " + ((JSNumber) revivedJson.get("age")).as(Integer.class));
        // Expected:
        // Name: Bob
        // Age: 41
    }
}
