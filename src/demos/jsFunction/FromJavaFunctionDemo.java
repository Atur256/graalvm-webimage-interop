package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;


public class FromJavaFunctionDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromJavaFunction Demo ===");

        // String → String
        JSFunction greet = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);
        System.out.println("String: " + greet.call("Alice"));
        // Expected: Hello, Alice

        // Integer → String
        JSFunction intToString = JSFunction.fromGeneralFunction((Integer arg) -> "Int: " + arg);
        System.out.println("Integer: " + intToString.call(42));
        // Expected: Int: 42

        // Double → Double
        JSFunction doubleSquare = JSFunction.fromGeneralFunction((Double arg) -> arg * arg);
        System.out.println("Double: " + doubleSquare.call(3.5));
        // Expected: 12.25

        // Boolean → String
        JSFunction boolToString = JSFunction.fromGeneralFunction((Boolean arg) -> arg ? "Yes" : "No");
        System.out.println("Boolean: " + boolToString.call(true));
        // Expected: Yes

        // Long → String
        JSFunction longToString = JSFunction.fromGeneralFunction((Long arg) -> "Long: " + arg);
        System.out.println("Long: " + longToString.call(1234567890123L));
        // Expected: Long: 1234567890123

        // Custom class → String
        JSFunction customToString = JSFunction.fromGeneralFunction((CustomClass arg) -> "Custom: " + arg.name);
        System.out.println("CustomClass: " + customToString.call(new CustomClass("Alice")));
        // Expected: Custom: Alice

        // === BiFunction: (String, Integer) → String
        JSFunction biGreet = JSFunction.fromGeneralBiFunction((String name, Integer age) ->
                "Name: " + name + ", Age: " + age.toString());
        System.out.println("BiFunction: " + biGreet.call("Bob", 30));
        // Expected: Name: Bob, Age: 30

        // === BiFunction: (Double, Double) → Double
        JSFunction biMultiply = JSFunction.fromGeneralBiFunction((Double x, Double y) -> x * y);
        System.out.println("BiFunction multiply: " + biMultiply.call(6.0, 7.0));
        // Expected: 42.0

        // === BiFunction: (JSString, JSNumber) → JSString
        JSFunction biMixed = JSFunction.fromBiFunction((JSString name, JSNumber age) ->
                JSString.of(name.as(String.class) + " is " + age.as(Integer.class) + " years old."));
        JSString result = biMixed.call(JSString.of("Alice"), JSNumber.of(25));
        System.out.println("BiFunction biMixed: " + result.as(String.class));
        // Expected: BiFunction biMixed: Alice is 25 years old.
    }

    record CustomClass(String name) {

    }
}
