package io.github.atur256.webimageinterop.vue.temp.src.untested;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


public class JSVueWatch {
    @JS("watch(source, callback);")
    public static native void watch(JSObject source, JSObject callback);

    @JS("watchEffect(effect);")
    public static native void watchEffect(JSObject effect);
}

