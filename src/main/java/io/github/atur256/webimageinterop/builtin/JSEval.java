package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSValue;


/**
 * Provides a Java binding for the JavaScript {@code Error} object within the WebImage interop layer.
 * This class enables native interop for JavaScript error creation and inspection.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSError error = JSError.of("Something went wrong");
 * String msg = error.message;
 * }</pre>
 */
@JS.Import("Eval")
public class JSEval {

    // === Evaluation Methods ===

    /**
     * Evaluates a JavaScript expression and returns the raw result.
     *
     * @param script the JavaScript code to evaluate
     * @return the result as a raw {@code Object}
     */
    @JS.Coerce
    @JS("return eval(script);")
    public static native Object eval(String script);

    /**
     * Evaluates a JavaScript expression and coerces the result to the specified type.
     *
     * @param script the JavaScript code to evaluate
     * @param cls    the target class for coercion
     * @param <R>    the result type
     * @return the coerced result
     */
    public static <R> R eval(String script, Class<R> cls) {
        return JSValue.checkedCoerce(eval(script), cls);
    }
}
