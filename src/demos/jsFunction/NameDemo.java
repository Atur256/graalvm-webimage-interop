package demos.jsFunction;

import builtin.JSFunction;


public class NameDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.name Demo ===");

        JSFunction f = JSFunction.fromBody("return 'test';");
        System.out.println("JSFunction name: " + f.name);
        // Expected: JSFunction name: "anonymous"
    }
}
