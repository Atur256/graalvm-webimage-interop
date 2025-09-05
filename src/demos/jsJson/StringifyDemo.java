package demos.jsJson;


import builtin.JSEval;
import builtin.JSJson;


public class StringifyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSJson.stringify Demo ===");

        var jsObj = JSEval.eval("({ name: 'Alice', age: 30 })");
        String json = JSJson.stringify(jsObj);
        System.out.println("JSON string: " + json);
        // Expected Output: JSON string: {"name":"Alice","age":30}
    }
}
