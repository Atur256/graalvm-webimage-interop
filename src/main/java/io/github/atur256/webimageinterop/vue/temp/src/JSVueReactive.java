package io.github.atur256.webimageinterop.vue.temp.src;

import org.graalvm.webimage.api.*;

public class JSVueReactive {

    private JSVueReactive() {
    }

    @JS.Coerce
    @JS("return Vue.ref(value);")
    public static native JSObject ref(JSValue value);

    @JS.Coerce
    @JS("return Vue.reactive(obj);")
    public static native JSObject reactive(JSObject obj);

    public static JSObject ref(String value) {
        return ref(JSString.of(value));
    }

    public static JSObject ref(int value) {
        return ref(JSNumber.of(value));
    }

    public static JSObject ref(double value) {
        return ref(JSNumber.of(value));
    }

    public static JSObject ref(boolean value) {
        return ref(JSBoolean.of(value));
    }
}
