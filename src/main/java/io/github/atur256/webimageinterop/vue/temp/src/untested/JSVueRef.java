package io.github.atur256.webimageinterop.vue.temp.src.untested;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


public class JSVueRef<T> extends JSObject {
    @JS("return ref(value);")
    public static native <T> JSVueRef<T> of(JSValue value);

    @JS("return this.value;")
    public native T get();

    @JS("this.value = value;")
    public native void set(T value);
}
