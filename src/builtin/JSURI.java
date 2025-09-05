package builtin;

import org.graalvm.webimage.api.JS;


public class JSURI {
    @JS.Coerce
    @JS(value = "return encodeURI(uri)")
    public native static java.lang.String  encodeURI(java.lang.String  uri);

    @JS.Coerce
    @JS(value = "return decodeURI(uri)")
    public native static java.lang.String  decodeURI(java.lang.String  uri);

    @JS.Coerce
    @JS(value = "return encodeURIComponent(uri)")
    public native static java.lang.String  encodeURIComponent(java.lang.String  uri);

    @JS.Coerce
    @JS(value = "return decodeURIComponent(uri)")
    public native static java.lang.String  decodeURIComponent(java.lang.String  uri);
}
