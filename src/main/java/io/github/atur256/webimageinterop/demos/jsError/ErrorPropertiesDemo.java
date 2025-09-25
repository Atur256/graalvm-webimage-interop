package io.github.atur256.webimageinterop.demos.jsError;

import io.github.atur256.webimageinterop.builtin.JSError;
import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


public class ErrorPropertiesDemo {

    public static void main(String[] args) {
        System.out.println("=== Error Instance Properties Demo ===");

        JSError err = JSError.of("Something broke", createOptions());

        System.out.println("Error object: " + err);
        System.out.println("typeof: " + err.getClass().getSimpleName());
        // Expected:
        // Error object: Error: Something broke
        // typeof: JSError

        System.out.println("message: " + err.message);
        System.out.println("name: " + err.name);
        System.out.println("cause: " + JSValue.checkedCoerce(err.cause, String.class));
        // Expected:
        // message: Something broke
        // name: Error
        // cause: root failure
    }

    @JS.Coerce
    @JS(value = "return { cause: 'root failure' };")
    public static native JSObject createOptions();
}
