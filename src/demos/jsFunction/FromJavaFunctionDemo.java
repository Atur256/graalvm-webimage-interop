package demos.jsFunction;

import builtin.JSFunction;


public class FromJavaFunctionDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromJavaFunction Demo ===");

        // String → String
        JSFunction greet = JSFunction.fromJavaFunction((String arg) -> "Hello, " + arg);
        System.out.println("String: " + greet.call("Alice"));
        // Expected: Hello, Alice

        // Integer → String
        JSFunction intToString = JSFunction.fromJavaFunction((Integer arg) -> "Int: " + arg);
        System.out.println("Integer: " + intToString.call(42));
        // Expected: Int: 42

        // Double → Double
        JSFunction doubleSquare = JSFunction.fromJavaFunction((Double arg) -> arg * arg);
        System.out.println("Double: " + doubleSquare.call(3.5));
        // Expected: 12.25

        // Boolean → String
        JSFunction boolToString = JSFunction.fromJavaFunction((Boolean arg) -> arg ? "Yes" : "No");
        System.out.println("Boolean: " + boolToString.call(true));
        // Expected: Yes

        // Long → String
        JSFunction longToString = JSFunction.fromJavaFunction((Long arg) -> "Long: " + arg);
        System.out.println("Long: " + longToString.call(1234567890123L));
        // Expected: Long: 1234567890123

        // Custom class → String
        JSFunction customToString = JSFunction.fromJavaFunction((CustomClass arg) -> "Custom: " + arg.name);
        System.out.println("CustomClass: " + customToString.call(new CustomClass("Alice")));
        // Expected: Custom: Alice
    }

    record CustomClass(String name) {

    }
}
