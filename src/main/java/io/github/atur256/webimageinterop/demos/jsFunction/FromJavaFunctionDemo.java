package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class FromJavaFunctionDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromJavaFunction Demo ===");

        // String → String
        JSFunction greet = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);
        String result1 = greet.call("Alice");
        System.out.println("String: " + result1);
        // Expected: String: Hello, Alice

        // Integer → String
        JSFunction intToString = JSFunction.fromGeneralFunction((Integer arg) -> "Int: " + arg);
        String result2 = intToString.call(42);
        System.out.println(result2);
        // Expected: Int: 42

        // Double → Double
        JSFunction doubleSquare = JSFunction.fromGeneralFunction((Double arg) -> arg * arg);
        double result3 = doubleSquare.call(3.5);
        System.out.println("Double: " + result3);
        // Expected: Double: 12.25

        // Boolean → String
        JSFunction boolToString = JSFunction.fromGeneralFunction((Boolean arg) -> arg ? "Yes" : "No");
        String result4 = boolToString.call(true);
        System.out.println("Boolean: " + result4);
        // Expected: Boolean: Yes

        // Long → String
        JSFunction longToString = JSFunction.fromGeneralFunction((Long arg) -> "Long: " + arg);
        String result5 = longToString.call(1234567890123L);
        System.out.println(result5);
        // Expected: Long: 1234567890123

        // Custom class → String
        JSFunction customToString = JSFunction.fromGeneralFunction((CustomClass arg) -> "Custom: " + arg.name);
        String result6 = customToString.call(new CustomClass("Alice"));
        System.out.println("CustomClass: " + result6);
        // Expected: CustomClass: Custom: Alice

        // === BiFunction: (String, Integer) → String
        JSFunction biFun = JSFunction.fromGeneralBiFunction((String name, Integer age) ->
                "Name: " + name + ", Age: " + age.toString());
        String result7 = biFun.call("Bob", 30);
        System.out.println("BiFunction: " + result7);
        // Expected: BiFunction: Name: Bob, Age: 30

        // === BiFunction: (Double, Double) → Double
        JSFunction biMultiply = JSFunction.fromGeneralBiFunction((Double x, Double y) -> x * y);
        double result8 = biMultiply.call(6.0, 7.0);
        System.out.println("BiFunction multiply: " + result8);
        // Expected: BiFunction multiply: 42.0

        // === BiFunction: (JSString, JSNumber) → JSString
        JSFunction biMixed = JSFunction.fromBiFunction((JSString name, JSNumber age) ->
                JSString.of(name.as(String.class) + " is " + age.as(Integer.class) + " years old."));
        JSString result9 = biMixed.call(JSString.of("Alice"), JSNumber.of(25));
        System.out.println("BiFunction biMixed: " + result9.asString());
        // Expected: BiFunction biMixed:Alice is 25 years old.

        // === TriFunction: (String, Integer, Boolean) → String
        JSFunction triFun = JSFunction.fromGeneralTriFunction((String name, Integer age, Boolean vip) ->
                "Name: " + name + ", Age: " + age + ", VIP: " + (vip ? "Yes" : "No"));
        String result10 = triFun.call("Charlie", 28, true).toString();
        System.out.println("TriFunction: " + result10);
        // Expected: TriFunction: Name: Charlie, Age: 28, VIP: Yes

        // === TriFunction: (JSString, JSNumber, JSBoolean) → JSString
        JSFunction triMixed = JSFunction.fromTriFunction((JSString name, JSNumber age, JSBoolean vip) -> {
            String result223423 = name.as(String.class) + " (" + age.as(Integer.class) + ")";
            if(vip.as(Boolean.class)) result223423 += " [VIP]";
            return JSString.of(result223423);
        });
        JSString result11 = (JSString) triMixed.call(JSString.of("Dana"), JSNumber.of(35), JSBoolean.of(true));
        System.out.println("TriFunction triMixed: " + result11.asString());
        // Expected: TriFunction triMixed: Dana (35) [VIP]

        // Assert values
        assertEquals("Hello, Alice", result1);
        assertEquals("Int: 42", result2);
        assertEquals(12.25, result3, 0.0);
        assertEquals("Yes", result4);
        assertEquals("Long: 1234567890123", result5);
        assertEquals("Custom: Alice", result6);
        assertEquals("Name: Bob, Age: 30", result7);
        assertEquals(42.0, result8, 0.0);
        assertEquals("Alice is 25 years old.", result9.asString());
        assertEquals("Name: Charlie, Age: 28, VIP: Yes", result10);
        assertEquals("Dana (35) [VIP]", result11.asString());
    }

    record CustomClass(String name) {

    }
}