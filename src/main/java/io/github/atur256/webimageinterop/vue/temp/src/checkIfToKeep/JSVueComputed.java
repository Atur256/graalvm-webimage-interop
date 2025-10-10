package io.github.atur256.webimageinterop.vue.temp.src.checkIfToKeep;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


public class JSVueComputed<T> extends JSObject {
    @JS("return computed(fn);")
    public static native <T> JSVueComputed<T> of(JSObject fn);

    @JS("return this.value;")
    public native T get();
}
