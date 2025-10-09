package io.github.atur256.webimageinterop.vue.temp.src.untested;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


public class JSVueContext extends JSObject {
    @JS("return ctx.emit;")
    public native JSObject emit();

    @JS("return ctx.slots;")
    public native JSObject slots();

    @JS("return ctx.attrs;")
    public native JSObject attrs();

    @JS("return ctx.expose;")
    public native JSObject expose();
}
