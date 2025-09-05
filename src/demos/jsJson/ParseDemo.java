package demos.jsJson;

import builtin.JSJson;


public class ParseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSJson.parse Demo ===");

        var obj = JSJson.parse("{\"name\":\"Alice\",\"age\":30}");
        System.out.println("Parsed object: " + obj);
        // Expected Output: Parsed object: [object Object]
    }
}
