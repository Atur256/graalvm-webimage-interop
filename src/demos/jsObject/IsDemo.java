package demos.jsObject;

import org.graalvm.webimage.api.*;


public class IsDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.is Demo ===");

        // Basic equality
        boolean result1 = JSObject.is(JSString.of("hello"), JSString.of("hello"));
        System.out.println("'hello' vs 'hello': " + result1);
        // Expected: 'hello' vs 'hello': true

        // Different types
        boolean result2 = JSObject.is(JSString.of("5"), JSNumber.of(5));
        System.out.println("'5' vs 5: " + result2);
        // Expected: '5' vs 5: false

        // NaN comparison
        boolean result3 = JSObject.is(JSNumber.of(Double.NaN), JSNumber.of(Double.NaN));
        System.out.println("NaN vs NaN: " + result3);
        // Expected: NaN vs NaN: true

        // Zero vs negative zero
        boolean result4 = JSObject.is(JSNumber.of(0.0), JSNumber.of(-0.0));
        System.out.println("0 vs -0: " + result4);
        // Expected: 0 vs -0: false

        // Boolean comparison
        boolean result5 = JSObject.is(JSBoolean.of(true), JSBoolean.of(true));
        System.out.println("true vs true: " + result5);
        // Expected: true vs true: true

        // Different object reference
        JSObject obj1 = JSObject.create();
        obj1.set("value", 1);
        JSObject obj2 = JSObject.create();
        obj2.set("value", 1);
        boolean result6 = JSObject.is(obj1, obj2);
        System.out.println("obj1 vs obj2: " + result6);
        // Expected: shared vs shared: false

        // Same object reference
        boolean result7 = JSObject.is(obj1, obj1);
        System.out.println("obj1 vs obj1: " + result7);
        // Expected: shared vs shared: true
    }
}
