package io.github.atur256.webimageinterop.vue.temp;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


//@JS.Code.Include("/vue.global.prod.js")
public class VueDemo {

    // TODO: remove from this project into a separate project

    public static void main(String[] args) throws Exception {
        // Inject Vue runtime
//        VueRuntimeLoader.injectVue();
//        System.out.println("Vue injected.");

        System.out.println("Vue.createApp exists: " + functionExist());

        JSValue app = createApp();

        if(app instanceof JSObject jsObj) {
            System.out.println("Type: " + jsObj.typeofString().asString());
            System.out.println("Keys: " + jsObj.keys());

            mountApp(jsObj);
        }
        else {
            System.out.println("Returned value is not a JSObject, value: " + app);
        }
    }

    @JS.Coerce
    @JS(value = "return typeof Vue.createApp === \"function\"")
    private static native boolean functionExist();

    @JS.Coerce
    @JS(value = """
            return Vue.createApp({
              setup() {
                     const message = Vue.ref('Hello vue!')
                     return {
                       message
                     }
                   }
            })
            """)
    private static native JSValue createApp();

    @JS.Coerce
    @JS(value = "app.mount('#app')")
    private static native void mountApp(JSObject app);
}
