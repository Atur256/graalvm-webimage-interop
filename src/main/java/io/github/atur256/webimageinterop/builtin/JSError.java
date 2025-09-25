package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


@JS.Import("Error")
public class JSError extends JSObject {

    public String message;

    public String name;

    public Object cause;

    @JS.Coerce
    @JS(value = "return new Error();")
    public static native JSError of();

    @JS.Coerce
    @JS(value = "return new Error(message);")
    public static native JSError of(String message);

    @JS.Coerce
    @JS(value = "return new Error(message, options);")
    public static native JSError of(String message, JSObject options);

    @JS.Coerce
    @JS(value = "return new Error(message, fileName);")
    public static native JSError of(String message, String fileName);

    @JS.Coerce
    @JS(value = "return new Error(message, fileName,lineNumber);")
    public static native JSError of(String message, String fileName, int lineNumber);

    @JS.Coerce
    @JS(value = "Error.captureStackTrace(target);")
    public static native void captureStackTrace(JSObject target);

    @JS.Coerce
    @JS(value = "return this.toString();")
    public native String toString();
}
