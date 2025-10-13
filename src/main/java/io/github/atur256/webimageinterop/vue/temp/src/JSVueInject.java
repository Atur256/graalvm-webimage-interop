package io.github.atur256.webimageinterop.vue.temp.src;

import org.graalvm.webimage.api.*;


public class JSVueInject {

    @JS.Coerce
    @JS("return Vue.inject(key);")
    public static native JSValue inject(String key);
}