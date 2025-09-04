package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class FromAsyncDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.fromAsync Demo ===");

        JSValue promise = JSArray.fromAsync(JSString.of("abc"));
        System.out.println("Promise from async iterable: " + promise);
        // Expected: Promise object
    }
}
