package demos.jsFunction;

import builtin.JSFunction;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.toStringJS Demo ===");

        JSFunction jsF = JSFunction.fromBody("return 42;");
        System.out.println("JSFunction source: " + jsF.toStringJS());
        // Expected: function anonymous(arg) { return 42; }


        JSFunction javaF = JSFunction.fromJavaFunction((String arg) -> "Hello, " + arg);
        System.out.println("JSFunction source: " + javaF.toStringJS());
        // Expected: function anonymous(arg) { return 42; }
    }
}
