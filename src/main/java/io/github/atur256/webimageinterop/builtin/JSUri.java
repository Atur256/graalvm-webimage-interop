package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;

import java.lang.String;


public class JSUri {

    @JS.Coerce
    @JS(value = "return encodeURI(uri);")
    public static native String encodeURI(String uri);

    @JS.Coerce
    @JS(value = "return decodeURI(uri);")
    public static native String decodeURI(String uri);

    @JS.Coerce
    @JS(value = "return encodeURIComponent(uri);")
    public static native String encodeURIComponent(String uri);

    @JS.Coerce
    @JS(value = "return decodeURIComponent(uri);")
    public static native String decodeURIComponent(String uri);
}
