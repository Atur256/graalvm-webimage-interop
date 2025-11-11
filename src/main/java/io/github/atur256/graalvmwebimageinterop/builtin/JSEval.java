/*
 * Copyright (c) 2025 Arthur Schwaiger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.atur256.graalvmwebimageinterop.builtin;

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
