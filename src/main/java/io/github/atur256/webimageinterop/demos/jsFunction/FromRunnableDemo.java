package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;


public class FromRunnableDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromRunnable Demo ===");

        CountDownLatch latch = new CountDownLatch(1);

        JSFunction runner = JSFunction.fromRunnable(() -> {
            System.out.println("Runnable executed");
            latch.countDown();
        });

        runner.call();
        // Expected: Runnable executed

        // Assert values
        assertEquals(0, latch.getCount());
    }
}