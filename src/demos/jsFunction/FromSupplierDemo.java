package demos.jsFunction;

import builtin.JSFunction;


public class FromSupplierDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromSupplier Demo ===");

        // String supplier
        JSFunction stringSupplier = JSFunction.fromSupplier(() -> "Supplied string");
        System.out.println("String: " + stringSupplier.call());
        // Expected: String: Supplied string

        // Integer supplier
        JSFunction intSupplier = JSFunction.fromSupplier(() -> 42);
        System.out.println("Integer: " + intSupplier.call());
        // Expected: Integer: 42

        // Double supplier
        JSFunction doubleSupplier = JSFunction.fromSupplier(() -> 3.14);
        System.out.println("Double: " + doubleSupplier.call());
        // Expected: Double: 3.14

        // Boolean supplier
        JSFunction boolSupplier = JSFunction.fromSupplier(() -> true);
        System.out.println("Boolean: " + boolSupplier.call());
        // Expected: Boolean: true

        // Custom class supplier
        JSFunction customSupplier = JSFunction.fromSupplier(() -> new CustomClass("Alice"));
        System.out.println("CustomClass: " + customSupplier.call());
        // Expected: CustomClass: CustomClass(Alice)
    }

    record CustomClass(String name) {

        @Override
        public String toString() {
            return "CustomClass(" + name + ")";
        }
    }
}
