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
import org.graalvm.webimage.api.JSObject;


/**
 * Provides a Java binding for the JavaScript {@code Error} object within the WebImage interop layer.
 * This class enables native interop for JavaScript error creation and inspection.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSError error = JSError.of("Something went wrong");
 * String msg = error.message;
 * }</pre>
 *
 * @see JSObject
 */

@JS.Import("Error")
public class JSError extends JSObject {

    /**
     * The error message.
     */
    public String message;

    /**
     * The error name (e.g., "TypeError", "ReferenceError").
     */
    public String name;

    /**
     * The cause of the error, if provided.
     */
    public Object cause;


    // === Factory Methods ===

    /**
     * Creates a new {@code JSError} with no message.
     *
     * @return a new {@code JSError}
     */
    @JS.Coerce
    @JS("return new Error();")
    public static native JSError of();

    /**
     * Creates a new {@code JSError} with a message.
     *
     * @param message the error message
     * @return a new {@code JSError}
     */
    @JS.Coerce
    @JS("return new Error(message);")
    public static native JSError of(String message);

    /**
     * Creates a new {@code JSError} with a message and options object.
     *
     * @param message the error message
     * @param options a {@link JSObject} containing error options
     * @return a new {@code JSError}
     */
    @JS.Coerce
    @JS("return new Error(message, options);")
    public static native JSError of(String message, JSObject options);

    /**
     * Creates a new {@code JSError} with a message and file name.
     *
     * @param message  the error message
     * @param fileName the file name where the error occurred
     * @return a new {@code JSError}
     */
    @JS.Coerce
    @JS("return new Error(message, fileName);")
    public static native JSError of(String message, String fileName);

    /**
     * Creates a new {@code JSError} with a message, file name, and line number.
     *
     * @param message    the error message
     * @param fileName   the file name where the error occurred
     * @param lineNumber the line number where the error occurred
     * @return a new {@code JSError}
     */
    @JS.Coerce
    @JS("return new Error(message, fileName,lineNumber);")
    public static native JSError of(String message, String fileName, int lineNumber);


    // === Stack Trace Utilities ===

    /**
     * Captures the stack trace for the given target object.
     *
     * @param target the object to attach the stack trace to
     */
    @JS.Coerce
    @JS("Error.captureStackTrace(target);")
    public static native void captureStackTrace(JSObject target);


    // === String Conversion ===

    /**
     * Returns the string representation of the error.
     *
     * @return the error as a string
     */
    @Override
    @JS.Coerce
    @JS("return this.toString();")
    public native String toString();
}
