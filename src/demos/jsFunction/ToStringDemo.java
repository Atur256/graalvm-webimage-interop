package demos.jsFunction;

import builtin.JSFunction;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.toStringJS Demo ===");

        JSFunction f = JSFunction.fromBody("return 42;");
        System.out.println("JSFunction source: " + f.toStringJS());
        // Expected: function anonymous(arg) { return 42; }
    }
}
