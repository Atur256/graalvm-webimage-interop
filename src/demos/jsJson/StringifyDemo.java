package demos.jsJson;

import builtin.JSEval;
import builtin.JSFunction;
import builtin.JSJson;
import org.graalvm.webimage.api.*;

public class StringifyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSJson.stringify Demo ===");

        // Basic stringify (JSValue)
        JSValue jsObj = JSEval.eval("({ name: 'Alice', age: 30 })", JSValue.class);
        String json1 = JSJson.stringify(jsObj);
        System.out.println("Basic stringify (JSValue): " + json1);
        // Expected:
        // Basic stringify (JSValue): {"name":"Alice","age":30}

        // Basic stringify (Java Object)
        String json2 = JSJson.stringify("Bob");
        System.out.println("Basic stringify (Java Object): " + json2);
        // Expected:
        // Basic stringify (Java Object): "Bob"

        // Stringify with replacer (omit 'age')
        JSFunction replacer = JSJson.fromReplacer((JSString key, JSValue value) -> {
            if (JSString.of("age").equals(key)) return JSUndefined.instance();
            return value;
        });
        String json3 = JSJson.stringify(jsObj, replacer);
        System.out.println("With replacer (omit age): " + json3);
        // Expected:
        // With replacer (omit age): {"name":"Alice"}

        // Stringify with replacer + indentation
        String json4 = JSJson.stringify(jsObj, replacer, 2);
        System.out.println("With replacer + indent:\n" + json4);
        // Expected:
        // With replacer + indent:
        // {
        //   "name": "Alice"
        //}

        // Pretty-print only (JSValue)
        String json5 = JSJson.stringify(jsObj, 4);
        System.out.println("Pretty-print (JSValue):\n" + json5);
        // Expected:
        // Pretty-print (JSValue):
        // {
        //     "name": "Alice",
        //     "age": 30
        // }

        // Pretty-print only (Java Object)
        String json6 = JSJson.stringify("Bob", 2);
        System.out.println("Pretty-print (Java Object):\n" + json6);
        // Expected:
        // Pretty-print (Java Object):
        // "Bob"
    }
}
