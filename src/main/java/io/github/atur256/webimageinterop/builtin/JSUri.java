package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;

import java.lang.String;


public class JSUri {

    @JS.Coerce
    @JS(value = "return encodeURI(uri);")
    public native static String encodeURI(String uri);

    @JS.Coerce
    @JS(value = "return decodeURI(uri);")
    public native static String decodeURI(String uri);

    @JS.Coerce
    @JS(value = "return encodeURIComponent(uri);")
    public native static String encodeURIComponent(String uri);

    @JS.Coerce
    @JS(value = "return decodeURIComponent(uri);")
    public native static String decodeURIComponent(String uri);
}
