package io.github.atur256.webimageinterop.vue.temp.src.untested;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


public class JSVueDirective {
    @JS("return { mounted, updated, unmounted };")
    public static native JSObject define(JSObject mounted, JSObject updated, JSObject unmounted);
}
