package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import java.lang.String;


@JS.Import("RegExp")
public class JSRegExp extends JSObject {

    @JS.Coerce
    @JS(value = "return new RegExp(pattern, flags);")
    public static native JSRegExp of(String pattern, String flags);

    public int lastIndex;
    public boolean dotAll;
    public String flags;
    public boolean global;
    public boolean hasIndices;
    public boolean ignoreCase;
    public boolean multiline;
    public String source;
    public boolean sticky;
    public boolean unicode;
    public boolean unicodeSets;

    @JS.Coerce
    @JS(value = "return this.exec(string);")
    public native JSValue exec(String string);

    @JS.Coerce
    @JS(value = "return this.test(string);")
    public native boolean test(String string);

    @JS.Coerce
    @JS(value = "return this.toString();")
    private native String toStringJS();

    public String toString() {
        return "JavaScript<" + typeof() + "; " + toStringJS() + ">";
    }
}
