package io.github.atur256.webimageinterop.vue.temp.src.examples;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.vue.temp.src.JSVueData;
import io.github.atur256.webimageinterop.vue.temp.src.JSVueOptions;
import io.github.atur256.webimageinterop.vue.temp.src.JSVue;
import io.github.atur256.webimageinterop.vue.temp.src.checkIfToKeep.JSVueRef;
import org.graalvm.webimage.api.*;

public class VueRefDemo {

    // ✅ Create type-safe Vue refs
    private static final JSVueRef<String> nameRef = JSVueRef.of(JSString.of("Arthur"));
    private static final JSVueRef<Integer> countRef = JSVueRef.of(JSNumber.of(0));

    public static void main(String[] args) {

        // ✅ Define data function exposing refs
        JSObject dataFn = JSVueData.wrapAsDataFunction(() -> JSVueData.builder()
                .set("name", nameRef.raw())
                .set("count", countRef.raw())
                .build()
        );

        // ✅ Define methods using type-safe access
        JSObject methods = JSObject.create();

        methods.set("toggleName", JSFunction.fromRunnable(() -> {
            String current = nameRef.get();
            nameRef.set(current.equals("Arthur") ? "Alice" : "Arthur");
        }));

        methods.set("increment", JSFunction.fromRunnable(() -> {
            int current = countRef.get();
            countRef.set(current + 1);
        }));

        // ✅ Define template
        String template = """
            <div>
              <h2>Hello, {{ name }}!</h2>
              <p>Count: {{ count }}</p>
              <button @click="toggleName">Toggle Name</button>
              <button @click="increment">Increment</button>
            </div>
        """;

        // ✅ Create and mount app
        JSVueOptions options = JSVueOptions.create()
                .setData(dataFn)
                .setMethods(methods)
                .setTemplate(template);

        JSObject app = JSVue.createApp(options);
        JSVue.mountAndStore(app);
    }
}
