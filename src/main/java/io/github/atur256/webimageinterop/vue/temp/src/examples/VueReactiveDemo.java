package io.github.atur256.webimageinterop.vue.temp.src.examples;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.vue.temp.src.*;
import org.graalvm.webimage.api.*;


public class VueReactiveDemo {

    // Retain original ref object in Java (because the Graalvm only returns the value if accessed and not the object itself)
    private static final JSObject nameRef = JSVueReactive.ref("Bob");
    private static final JSObject countRef = JSVueReactive.ref(0);

    public static void main(String[] args) {

        // Create nested object: profile
        JSObject profile = JSObject.create();
        profile.set("age", JSNumber.of(35));
        profile.set("location", JSString.of("Austria"));

        // Create nested array: roles
        JSArray roles = JSArray.of("admin", "editor", "tester");

        // Create reactive user object
        JSObject rawUser = JSObject.create();
        rawUser.set("name", JSString.of("Bob"));
        rawUser.set("loggedIn", JSBoolean.of(true));
        rawUser.set("profile", profile);
        rawUser.set("roles", roles);

        JSObject reactiveUser = JSVueReactive.reactive(rawUser);

        // Wrap data function with unwrapped ref values
        JSObject dataFn = JSVueData.wrapAsDataFunction(() -> JSVueData.builder()
                .set("message", "Hello from reactive Vue!")
                .set("name", "Alice")
                .set("nameRef", nameRef)     // Vue sees plain string
                .set("count", countRef)   // Vue sees plain number
                .set("user", reactiveUser)
                .build()
        );

        // Define methods
        JSObject methods = JSObject.create();

        methods.set("increment", JSFunction.fromRunnable(() -> {
            int current = JSValue.checkedCoerce(countRef.get("value"), Integer.class);
            countRef.set("value", JSNumber.of(current + 1));
        }));

        methods.set("toggleName", JSFunction.fromRunnable(() -> {
            JSObject user = JSVue.getValue("user", JSObject.class);
            if(user == null) return;
            String currentName = JSValue.checkedCoerce(user.get("name"), String.class);
            user.set("name", JSString.of(currentName.equals("Bob") ? "Alice" : "Bob"));
        }));

        methods.set("toggleLogin", JSFunction.fromRunnable(() -> {
            JSObject user = JSVue.getValue("user", JSObject.class);
            if(user == null) return;
            boolean isLoggedIn = JSValue.checkedCoerce(user.get("loggedIn"), Boolean.class);
            user.set("loggedIn", JSBoolean.of(!isLoggedIn));
        }));

        methods.set("updateNested", JSFunction.fromRunnable(() -> {
            JSObject user = JSVue.getValue("user", JSObject.class);
            if(user == null) return;
            JSObject profileObj = JSValue.checkedCoerce(user.get("profile"), JSObject.class);
            String currentLocation = JSValue.checkedCoerce(profileObj.get("location"), String.class);
            profileObj.set("location", JSString.of(currentLocation.equals("Austria") ? "Germany" : "Austria"));

            JSArray roleArray = JSValue.checkedCoerce(user.get("roles"), JSArray.class);
            if(roleArray.length > 0) {
                String currentRole = JSValue.checkedCoerce(roleArray.get(0), String.class);
                roleArray.set(0, JSString.of(currentRole.equals("admin") ? "guest" : "admin"));
            }
        }));

        methods.set("toggleRefName", JSFunction.fromRunnable(() -> {
            String current = JSValue.checkedCoerce(nameRef.get("value"), String.class);
            String next = current.equals("Bob") ? "Alice" : "Bob";
            nameRef.set("value", JSString.of(next));
        }));

        // Define template
        String template = """
                    <div>
                      <h1>{{ message }} ({{ count }})</h1>
                      <p>Ref Name: {{ nameRef }}</p>
                      <p>User: {{ user.name }}</p>
                      <p v-if="user.loggedIn">Welcome back!</p>
                      <p>Age: {{ user.profile.age }}</p>
                      <p>Location: {{ user.profile.location }}</p>
                      <ul>
                        <li v-for="role in user.roles">{{ role }}</li>
                      </ul>
                      <button @click="increment">Increment</button>
                      <button @click="toggleName">Toggle Name</button>
                      <button @click="toggleLogin">Toggle Login</button>
                      <button @click="updateNested">Update Nested Values</button>
                      <button @click="toggleRefName">Toggle Ref Name</button>
                    </div>
                """;

        // Create and mount app
        JSVueOptions options = JSVueOptions.create()
                .setData(dataFn)
                .setMethods(methods)
                .setTemplate(template);

        JSObject app = JSVue.createApp(options);
        JSVue.mountAndStore(app);


        // Add watchers after mount
        JSVueWatch.watch(
                nameRef,
//                JSFunction.fromRunnable(() -> nameRef.get("value")),
                JSFunction.fromBiConsumer((JSValue oldValue, JSValue newValue) -> {
                    System.out.println("Name changed: " + JSValue.checkedCoerce(oldValue, String.class) + " → " + JSValue.checkedCoerce(newValue, String.class));
                })
        );

        JSVueWatch.watchEffect(JSFunction.fromRunnable(() -> {
            String name = JSValue.checkedCoerce(JSVue.getValue("user", JSObject.class).get("name"), String.class);
            System.out.println("Reactive effect: user.name = " + name);
        }));


    }
}
