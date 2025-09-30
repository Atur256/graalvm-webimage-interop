package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSPromise;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class FromAsyncDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.fromAsync Demo ===");

        JSPromise promise = JSArray.fromAsync(JSString.of("abc"));
        System.out.println("Promise from async iterable: " + promise);
        // Expected: Promise from async iterable: JavaScript<object; [object Promise]>

        // Assert values
        assertEquals("JavaScript<object; [object Promise]>", promise.toString());
    }
}