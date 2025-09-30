package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.jetbrains.annotations.NotNull;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FromSupplierDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromSupplier Demo ===");

        // String supplier
        JSFunction stringSupplier = JSFunction.fromSupplier(() -> "Supplied string");
        String result1 = stringSupplier.call();
        System.out.println("String: " + result1);
        // Expected: String: Supplied string

        // Integer supplier
        JSFunction intSupplier = JSFunction.fromSupplier(() -> 42);
        int result2 = intSupplier.call();
        System.out.println("Integer: " + result2);
        // Expected: Integer: 42

        // Double supplier
        JSFunction doubleSupplier = JSFunction.fromSupplier(() -> 3.14);
        double result3 = doubleSupplier.call();
        System.out.println("Double: " + result3);
        // Expected: Double: 3.14

        // Boolean supplier
        JSFunction boolSupplier = JSFunction.fromSupplier(() -> true);
        boolean result4 = boolSupplier.call();
        System.out.println("Boolean: " + result4);
        // Expected: Boolean: true

        // Custom class supplier
        JSFunction customSupplier = JSFunction.fromSupplier(() -> new CustomClass("Alice"));
        CustomClass result5 = customSupplier.call();
        System.out.println("CustomClass: " + result5);
        // Expected: CustomClass: CustomClass(Alice)

        // Assert values
        assertEquals("Supplied string", result1);
        assertEquals(42, result2);
        assertEquals(3.14, result3, 0.0);
        assertTrue(result4);
        assertEquals("Alice", result5.name);
    }

    record CustomClass(String name) {

        @Override
        @NotNull
        public String toString() {
            return "CustomClass(" + name + ")";
        }
    }
}