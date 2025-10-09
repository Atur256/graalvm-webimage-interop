package io.github.atur256.webimageinterop.vue.temp.src.untested;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;

public class JSVueApp extends JSObject {

    @JS("return this.mount(selector);")
    public native JSVueApp mount(String selector);

    @JS("return this.component(name, definition);")
    public native JSVueApp component(String name, JSObject definition);

    @JS("return this.use(plugin);")
    public native JSVueApp use(JSObject plugin);
}

