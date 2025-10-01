package io.github.atur256.webimageinterop.vue.test;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JS;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@JS.Code.Include("/vue.global.prod.js")
public class VueRuntimeLoader {

//    public static void injectVue() throws Exception {
//        try (InputStream in = VueRuntimeLoader.class.getResourceAsStream("/vue.global.prod.js")) {
//            if (in == null) throw new FileNotFoundException("vue.global.js not found");
//            String vueSource = new String(in.readAllBytes(), StandardCharsets.UTF_8);
//
//            JSFunction.fromBody(vueSource).call();
//        }
//    }

//    public static void injectVue() throws Exception {
//        try (InputStream in = VueRuntimeLoader.class.getResourceAsStream("/vue.global.prod.js")) {
//            if (in == null) throw new FileNotFoundException("vue.global.js not found");
//            String vueSource = new String(in.readAllBytes(), StandardCharsets.UTF_8);
//
//            // Evaluate Vue in global scope
//            JSFunction.fromBody(vueSource + "\nglobalThis.Vue = Vue;").call();
//        }
//    }


    public static void injectVue() throws Exception {
        try (InputStream in = VueRuntimeLoader.class.getResourceAsStream("/vue.global.prod.js")) {
            if (in == null) throw new FileNotFoundException("vue.global.js not found");
            String vueSource = new String(in.readAllBytes(), StandardCharsets.UTF_8);

            // Wrap it so Vue is global
            String globalVue = vueSource + "\nglobalThis.Vue = Vue;";

            // Evaluate in global JS scope
            JSFunction.fromBody(globalVue).call();
        }
    }


}
