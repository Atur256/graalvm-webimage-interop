package io.github.atur256.webimageinterop.vue.temp.src.checkIfToKeep;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


public class JSVueLifecycle {
    @JS("onMounted(callback);")
    public static native void onMounted(JSObject callback);

    @JS("onUpdated(callback);")
    public static native void onUpdated(JSObject callback);

    @JS("onUnmounted(callback);")
    public static native void onUnmounted(JSObject callback);
}
