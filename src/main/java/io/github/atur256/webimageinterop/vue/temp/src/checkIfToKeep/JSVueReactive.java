package io.github.atur256.webimageinterop.vue.temp.src.checkIfToKeep;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


public class JSVueReactive<T> extends JSObject {
    @JS("return reactive(obj);")
    public static native <T> JSVueReactive<T> of(JSObject obj);
}
