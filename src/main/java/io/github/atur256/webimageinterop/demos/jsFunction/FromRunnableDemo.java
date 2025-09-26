package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;

import static org.junit.Assert.assertEquals;


public class FromRunnableDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromRunnable Demo ===");

        String[] result = new String[]{""};
        JSFunction runner = JSFunction.fromRunnable(() -> result[0] = "Runnable executed");

        runner.call();
        assertEquals("Runnable executed", result[0]);
        System.out.println(result[0]);
        // Expected: Runnable executed
    }
}
