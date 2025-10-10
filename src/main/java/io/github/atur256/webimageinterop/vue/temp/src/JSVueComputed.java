package io.github.atur256.webimageinterop.vue.temp.src;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.*;

public final class JSVueComputed<T> {

    private final JSObject computed;

    private JSVueComputed(JSObject computed) {
        this.computed = computed;
    }

    @JS.Coerce
    @JS("return Vue.computed(fn);")
    private static native JSObject create(JSObject fn);

    public static <T> JSVueComputed<T> from(JSFunction getterFn) {
        return new JSVueComputed<>(create(getterFn));
    }

    public T get(Class<T> type) {
        return JSValue.checkedCoerce(computed.get("value"), type);
    }

    public JSObject raw() {
        return computed;
    }
}
