package io.github.atur256.webimageinterop.vue.temp.src.examples;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.vue.temp.src.*;
import io.github.atur256.webimageinterop.vue.temp.src.checkIfToKeep.JSVueRef;
import org.graalvm.webimage.api.*;


public class VueReactiveDemo2 {

    private static final JSVueRef<String> nameRef = JSVueRef.of("Bob");
    private static final JSVueRef<Integer> countRef = JSVueRef.of(0);
    private static final JSVueRef<String> ageInputRef = JSVueRef.of("35");

    public static void main(String[] args) {

        JSObject profile = JSObject.create();
        profile.set("age", JSNumber.of(35));
        profile.set("location", JSString.of("Austria"));

        JSArray roles = JSArray.of("admin", "editor", "tester");

        JSObject rawUser = JSObject.create();
        rawUser.set("name", JSString.of("Bob"));
        rawUser.set("loggedIn", JSBoolean.of(true));
        rawUser.set("profile", profile);
        rawUser.set("roles", roles);

        JSObject reactiveUser = JSVueRef.reactive(rawUser);
        JSVueRef<JSObject> userRef = JSVueRef.of(reactiveUser);

        JSObject dataFn = JSVueData.wrapAsDataFunction(() -> JSVueData.builder()
                .set("message", "Hello from reactive Vue!")
                .set("name", "Alice")
                .set("nameRef", nameRef.raw())
                .set("count", countRef.raw())
                .set("ageInput", ageInputRef.raw())
                .set("user", userRef.raw())
                .build()
        );

        JSObject methods = JSObject.create();

        methods.set("increment", JSFunction.fromRunnable(() -> countRef.set(countRef.get() + 1)));

        methods.set("toggleName", JSFunction.fromRunnable(() -> {
            JSObject user = userRef.get();
            String currentName = JSValue.checkedCoerce(user.get("name"), String.class);
            user.set("name", JSString.of(currentName.equals("Bob") ? "Alice" : "Bob"));
        }));

        methods.set("toggleLogin", JSFunction.fromRunnable(() -> {
            JSObject user = userRef.get();
            boolean isLoggedIn = JSValue.checkedCoerce(user.get("loggedIn"), Boolean.class);
            user.set("loggedIn", JSBoolean.of(!isLoggedIn));
        }));

        methods.set("updateNested", JSFunction.fromRunnable(() -> {
            JSObject user = userRef.get();
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
            String current = nameRef.get();
            nameRef.set(current.equals("Bob") ? "Alice" : "Bob");
        }));

        methods.set("reactiveMutation", JSFunction.fromRunnable(() -> {
            JSObject user = userRef.get();
            user.set("name", JSString.of("Charlie"));
            user.set("loggedIn", JSBoolean.of(false));
        }));

        methods.set("resetAge", JSFunction.fromRunnable(() -> {
            JSObject user = userRef.get();
            JSObject profileObj = JSValue.checkedCoerce(user.get("profile"), JSObject.class);
            profileObj.set("age", JSNumber.of(0));
        }));

        methods.set("updateAgeFromInput", JSFunction.fromRunnable(() -> {
            String input = ageInputRef.get();
            try {
                int newAge = Integer.parseInt(input.trim());
                JSObject user = userRef.get();
                JSObject profileObj = JSValue.checkedCoerce(user.get("profile"), JSObject.class);
                profileObj.set("age", JSNumber.of(newAge));
            } catch (NumberFormatException e) {
                System.out.println("Invalid age input: " + input);
            }
        }));

        methods.set("logReactiveUser", JSFunction.fromRunnable(() -> {
            JSObject user = userRef.get();
            System.out.println("[Reactive Snapshot]");
            System.out.println("name: " + user.get("name"));
            System.out.println("loggedIn: " + user.get("loggedIn"));
            JSObject p = JSValue.checkedCoerce(user.get("profile"), JSObject.class);
            System.out.println("profile: [age: " + JSValue.checkedCoerce(p.get("age"), Integer.class) + ", location: " + JSValue.checkedCoerce(p.get("location"), String.class) + "]");
            System.out.println("roles: " + user.get("roles"));
        }));

        methods.set("checkIsRef", JSFunction.fromRunnable(() -> {
            System.out.println("isRef(nameRef): " + JSVueRef.isRef(nameRef.raw()));
            System.out.println("isRef(userRef): " + JSVueRef.isRef(userRef.raw()));
            System.out.println("isRef(rawUser): " + JSVueRef.isRef(rawUser));
        }));

        methods.set("testUnref", JSFunction.fromRunnable(() -> {
            System.out.println("unref(nameRef): " + JSVueRef.unref(nameRef.raw()));
            System.out.println("unref(countRef): " + JSVueRef.unref(countRef.raw()));
        }));

        methods.set("testToRef", JSFunction.fromRunnable(() -> {
            JSObject namePropRef = JSVueRef.toRef(userRef.get(), "name");
            System.out.println("toRef(user.name): " + namePropRef.get("value"));
        }));

        methods.set("testToRefs", JSFunction.fromRunnable(() -> {
            JSObject refs = JSVueRef.toRefs(userRef.get());
            System.out.println("toRefs(user).name.value: " + JSValue.checkedCoerce(refs.get("name"), JSObject.class).get("value"));
            System.out.println("toRefs(user).loggedIn.value: " + JSValue.checkedCoerce(refs.get("loggedIn"), JSObject.class).get("value"));
        }));

        String template = """
                    <div>
                      <h1>{{ message }} ({{ count }})</h1>
                      <p>Ref Name: {{ nameRef }}</p>
                      <p>User: {{ user.name }}</p>
                      <p v-if="user.loggedIn">Welcome back!</p>
                      <p>Age: {{ user.profile.age }}</p>
                      <button @click="resetAge">Set Age to 0</button>
                      <input v-model="ageInput" type="text" placeholder="Enter new age" />
                      <button @click="updateAgeFromInput">Update Age</button>
                      <p>Location: {{ user.profile.location }}</p>
                      <ul>
                        <li v-for="role in user.roles">{{ role }}</li>
                      </ul>
                      <button @click="increment">Increment</button>
                      <button @click="toggleName">Toggle Name</button>
                      <button @click="toggleLogin">Toggle Login</button>
                      <button @click="updateNested">Update Nested Values</button>
                      <button @click="toggleRefName">Toggle Ref Name</button>
                      <button @click="reactiveMutation">Mutate Reactive User</button>
                      <button @click="logReactiveUser">Log Reactive User</button>
                      <button @click="checkIsRef">Check isRef</button>
                      <button @click="testUnref">Test unref</button>
                      <button @click="testToRef">Test toRef</button>
                      <button @click="testToRefs">Test toRefs</button>
                    </div>
                """;

        JSVueOptions options = JSVueOptions.create()
                .setData(dataFn)
                .setMethods(methods)
                .setTemplate(template);

        JSObject app = JSVue.createApp(options);
        JSVue.mountAndStore(app);

        JSVueWatch.watch(nameRef, JSFunction.fromBiConsumer((oldValue, newValue) -> {
            System.out.println("Name changed from " + oldValue + " to " + newValue);
        }));

        countRef.watch(JSFunction.fromBiConsumer((oldVal, newVal) -> {
            System.out.println("countRef changed from " + oldVal.asInt() + " to " + newVal.asInt());
        }));

        JSVueWatch.watchEffect(JSFunction.fromRunnable(() -> {
            JSObject user = userRef.get();
            String name = JSValue.checkedCoerce(user.get("name"), String.class);
            System.out.println("Reactive effect: user.name = " + name);
        }));

        JSVueWatch.watchEffect(JSFunction.fromRunnable(() -> {
            JSObject user = userRef.get();
            JSObject p = JSValue.checkedCoerce(user.get("profile"), JSObject.class);
            int age = JSValue.checkedCoerce(p.get("age"), Integer.class);
            ageInputRef.set(String.valueOf(age));
        }));

    }
}
