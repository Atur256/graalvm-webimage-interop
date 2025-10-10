package io.github.atur256.webimageinterop.vue.temp.src;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;


public class JSVueComponent extends JSObject {

    private JSVueComponent() {
        super();
    }

    public static JSVueComponent create() {
        return new JSVueComponent();
    }

    public JSVueComponent setProps(JSArray props) {
        this.set("props", props);
        return this;
    }

    public JSVueComponent setTemplate(JSVueTemplate template) {
        this.set("template", template.getJS());
        return this;
    }

    public JSVueComponent setTemplate(String template) {
        this.set("template", JSString.of(template));
        return this;
    }
}
