package demos.jsFunction;

import builtin.JSFunction;


public class FromRunnableDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromRunnable Demo ===");

        JSFunction runner = JSFunction.fromRunnable(() -> System.out.println("Runnable executed"));

        runner.call();
        // Expected: Runnable executed
    }
}
