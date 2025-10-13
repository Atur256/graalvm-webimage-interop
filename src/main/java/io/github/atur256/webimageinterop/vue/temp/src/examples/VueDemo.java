package io.github.atur256.webimageinterop.vue.temp.src.examples;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.vue.temp.src.*;
import io.github.atur256.webimageinterop.vue.temp.src.JSVueLifecycle;
import io.github.atur256.webimageinterop.vue.temp.src.JSVueProvide;
import io.github.atur256.webimageinterop.vue.temp.src.checkIfToKeep.JSVueRef;
import org.graalvm.webimage.api.*;


public class VueDemo {

    // TODO: all JS code where "this" is needed needs to be as JS code because i cant find a way to get the "this" object into java

    // Retain original ref object in Java (because the Graalvm only returns the value if accessed and not the object itself)
    private static final JSVueRef<String> nameRef = JSVueRef.of("Bob");
    private static final JSVueRef<Integer> countRef = JSVueRef.of(0);
    private static final JSVueRef<String> ageInputRef = JSVueRef.of("35");

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

        JSObject reactiveUser = JSVueRef.reactive(rawUser);

        JSVueData data = JSVueData.builder()
                .set("message", "Hello from reactive Vue!")
                .set("name", "Alice")
                .set("nameRef", nameRef)
                .set("countReactive", countRef)
                .set("user", reactiveUser)
                .set("count", 42)
                .set("buttonLabel", "Reset Count")
                .set("showRole", true)
                .set("user", () -> JSVueData.builder()
                        .set("name", "Alice")
                        .set("roles", JSArray.of("admin", "editor"))
                        .build())
                .set("isRed", true)
                .set("color", "green")
                .set("text", "Edit me")
                .set("checked", true)
                .set("checkedNames", JSArray.of("Jack"))
                .set("picked", "One")
                .set("selected", "A")
                .set("multiSelected", JSArray.of("A"))
                .set("groceryList", createGroceryList())
                .set("newItemText", "")
                .set("nextId", 3)
                .set("showPanel", true)
                .build();

        // Vue data function
        JSObject dataFn = JSVueData.wrapAsDataFunction(() -> data);

        // Vue methods
        JSObject methods = JSObject.create();
        methods.set("increment", JSFunction.fromRunnable(() -> {
            int current = JSVue.getValue("count", Integer.class);
            JSVue.setValue("count", current + 1);
        }));
        methods.set("increment", JSFunction.fromRunnable(() -> countRef.set(countRef.get() + 1)));
        methods.set("toggleRole", JSFunction.fromRunnable(() -> {
            boolean current = JSVue.getValue("showRole", Boolean.class);
            JSVue.setValue("showRole", !current);
        }));
        methods.set("reset", JSFunction.fromRunnable(() -> JSVue.setValue("count", 0)));
//        methods.set("resetTimer", JSEval.eval("""
//                    (function() {
//                        this.elapsed = 0;
//                        this.lastTime = performance.now();
//                        this.update();
//                    })
//                """));
//        methods.set("update", JSEval.eval("""
//                    (function() {
//                        this.elapsed = performance.now() - this.lastTime;
//                        if (this.elapsed >= this.duration) {
//                            cancelAnimationFrame(this.handle);
//                        } else {
//                            this.handle = requestAnimationFrame(this.update);
//                        }
//                    })
//                """));
        methods.set("toggleRed", JSFunction.fromRunnable(() -> {
            boolean current = JSVue.getValue("isRed", Boolean.class);
            System.out.println("Toggled red");
            JSVue.setValue("isRed", !current);
        }));
        methods.set("toggleColor", JSFunction.fromRunnable(() -> {
            String current = JSVue.getValue("color", String.class);
            String next = current.equals("green") ? "blue" : "green";
            JSVue.setValue("color", next);
        }));
        methods.set("addItem", JSFunction.fromRunnable(() -> {
            JSObject vue = JSVue.getMountedInstance();
            if(vue == null) return;

            String text = JSVue.getValue("newItemText", String.class);
            if(text == null || text.trim().isEmpty()) return;

            int nextId = JSVue.getValue("nextId", Integer.class);
            JSObject newItem = JSObject.create();
            newItem.set("id", JSNumber.of(nextId));
            newItem.set("text", JSString.of(text));

            JSArray list = JSVue.getValue("groceryList", JSArray.class);
            list.push(newItem);

            JSVue.setValue("groceryList", list);
            JSVue.setValue("newItemText", "");
            JSVue.setValue("nextId", nextId + 1);
        }));
        methods.set("removeItem", JSFunction.fromConsumer(idVal -> {
            int id = idVal.asInt();
            JSArray list = JSVue.getValue("groceryList", JSArray.class);

            JSArray filtered = JSArray.of();
            for(int i = 0; i < list.length; i++) {
                JSObject item = JSValue.checkedCoerce(list.get(i), JSObject.class);
                if(JSValue.checkedCoerce(item.get("id"), Integer.class) != id) {
                    filtered.push(item);
                }
            }
            JSVue.setValue("groceryList", filtered);
        }));

        // TodoItem template with slot
        JSVueTemplate todoItemTemplate = JSVueTemplate.of("""
                                  <li :style="{ color: theme === 'dark' ? '#ccc' : '#333' }">
                                    {{ index + 1 }}. {{ todo.text }}
                                    <span style="cursor:pointer; margin-left:10px;" @click="$emit('remove', todo.id)">&#10060;</span>
                                    <div style="font-size:smaller;">Theme: {{ theme }}</div>
                                    <slot></slot>
                                  </li>
                """);

        // Slot content for TodoItem
        JSVueTemplate slotTemplate = JSVueTemplate.of("<div style='font-size:smaller;'>Extra slot content here</div>");
        JSObject slots = JSObject.create();
        slots.set("default", JSFunction.fromRunnable(() -> slotTemplate.getJS()));

        // Panel component with named slots
        JSVueTemplate panelTemplate = JSVueTemplate.of("""
                    <div class='panel'>
                      <header><slot name='header'>Default Header</slot></header>
                      <main><slot>Default Body</slot></main>
                      <footer><slot name='footer'>Default Footer</slot></footer>
                    </div>
                """);

        JSObject todoItemSetup = JSValue.checkedCoerce(JSEval.eval("""
                  (function() {
                    return {
                      theme: Vue.inject('theme')
                    };
                  })
                """), JSObject.class);

        JSVueComponent todoItemComponent = JSVueComponent.create()
                .setProps(JSArray.of("todo", "index"))
                .setTemplate(todoItemTemplate)
                .setSlots(slots)
                .set("setup", todoItemSetup);

        JSObject components = JSObject.create();
        components.set("TodoItem", todoItemComponent);

        components.set("Panel", JSVueComponent.create()
                .setTemplate(panelTemplate));

        JSObject timedPanelMethods = JSObject.create();
        timedPanelMethods.set("resetTimer", JSEval.eval("""
                    (function() {
                        this.elapsed = 0;
                        this.lastTime = performance.now();
                        this.update();
                    })
                """));

        timedPanelMethods.set("update", JSEval.eval("""
                    (function() {
                        this.elapsed = performance.now() - this.lastTime;
                        if (this.elapsed >= this.duration) {
                            cancelAnimationFrame(this.handle);
                        } else {
                            this.handle = requestAnimationFrame(this.update);
                        }
                    })
                """));

        JSVueLifecycle panelLifecycle = JSVueLifecycle.create()
                .onMounted(JSValue.checkedCoerce(JSEval.eval("""
                            (function() {
                                console.log("Time panel mounted")
                                this.resetTimer();
                            })
                        """), JSFunction.class))
                .onUnmounted(JSValue.checkedCoerce(JSEval.eval("""
                            (function() {
                                console.log("Time panel unmounted")
                                cancelAnimationFrame(this.handle);
                            })
                        """), JSFunction.class));

        JSVueTemplate timedPanelTemplate = JSVueTemplate.of("""
                  <div>
                    <label>Elapsed Time: <progress :value="progressRate"></progress></label>
                    <div>{{ (elapsed / 1000).toFixed(1) }}s</div>
                    <div>
                      Duration: <input type="range" v-model="duration" min="1" max="30000">
                      {{ (duration / 1000).toFixed(1) }}s
                    </div>
                    <button @click="resetTimer()">Reset Timer</button>
                  </div>
                """);

        JSVueData timedPanelData = JSVueData.builder()
                .set("duration", 15000)
                .set("elapsed", 0.0)
                .build();

        JSObject computed = JSObject.create();
        computed.set("progressRate", JSEval.eval("""
                    (function() {
                        return Math.min(this.elapsed / this.duration, 1);
                    })
                """));

        JSVueComponent timedPanelComponent = JSVueComponent.create()
                .setTemplate(timedPanelTemplate)
                .setData(JSVueData.wrapAsDataFunction(() -> timedPanelData))
                .setMethods(timedPanelMethods)
                .setComputed(computed)
                .setHooks(panelLifecycle.getHooks());

        components.set("TimedPanel", timedPanelComponent);


        String html = """
                    <div>
                      <panel>
                        <template v-slot:header>
                          <h2>Named Slot Header</h2>
                        </template>
                
                        <template v-slot:default>
                          <div>
                            <p>This is the main content injected into the default slot.</p>
                            <h1>Hello {{ message }} ({{ count }})</h1>
                            <p>Double Count: {{ doubleCount }}</p>
                            <p>User: {{ user.name }}</p>
                            <ul v-if="showRole">
                              <li v-for="role in user.roles">{{ role }}</li>
                            </ul>
                
                            <button @click="increment()">Increment Count</button>
                            <button @click="reset()">{{ buttonLabel }}</button>
                            <button @click="toggleRole()">Toggle Role</button>
                
                            <button @click="showPanel = !showPanel">Toggle Panel</button>
                            <timed-panel v-if="showPanel"></timed-panel>
                
                
                
                            <p :class="{ red: isRed }" @click="toggleRed()">Toggle Red</p>
                            <p :style="{ color }" @click="toggleColor()">Toggle Color</p>
                
                            <input v-model="text">
                            <p>{{ text }}</p>
                            <input type="checkbox" v-model="checked">
                            <label>Checked: {{ checked }}</label>
                
                            <h2>Grocery List</h2>
                            <input v-model="newItemText">
                            <button @click="addItem()">Add Item</button>
                            <todo-item
                              v-for="(item, index) in groceryList"
                              :todo="item"
                              :index="index"
                              :key="item.id"
                              @remove="removeItem"
                            >
                              <template v-slot>
                                <div style="font-size:smaller;">Extra slot content here</div>
                              </template>
                            </todo-item>
                          </div>
                        </template>
                
                        <template v-slot:footer>
                          <small>© 2025 Arthur's Vue Interop</small>
                        </template>
                      </panel>
                    </div>
                """;

//        JSObject hooks = JSObject.create();
//        hooks.set("created", JSEval.eval("""
//                    (function() {
//                        this.resetTimer();
//                    })
//                """));
//        hooks.set("unmounted", JSEval.eval("(function() { cancelAnimationFrame(this.handle); })"));

//        JSVueLifecycle lifecycle = JSVueLifecycle.create()
//                .onMounted(JSValue.checkedCoerce(JSEval.eval("""
//                            (function() {
//                                console.log("mounted")
//                                this.resetTimer();
//                            })
//                        """), JSFunction.class))
//                .onUnmounted(JSValue.checkedCoerce(JSEval.eval("""
//                            (function() {
//                                console.log("unmounted")
//                                cancelAnimationFrame(this.handle);
//                            })
//                        """), JSFunction.class));


        JSVueTemplate template = JSVueTemplate.of(html);

        JSVueProvide provide = JSVueProvide.create()
//                .set("theme", "dark");
                .set("theme", "light");


        JSVueComputed<Integer> doubleCount = JSVueComputed.of("doubleCount", JSValue.checkedCoerce(JSEval.eval("""
                  (function() {
                    return this.count * 2;
                  })
                """), JSFunction.class));

//        JSObject computedMap = JSObject.create();


        JSVueOptions options = JSVueOptions.create()
                .setData(dataFn)
                .setMethods(methods)
                .setTemplate(template)
//                .setComputed(computed)
//                .setHooks(lifecycle.getHooks())
                .setComputed(doubleCount)
                .setComponents(components)
                .setProvide(provide);


        JSObject app = JSVue.createApp(options);
        JSVue.mountAndStore(app);
    }

    private static JSArray createGroceryList() {
        JSObject item0 = JSObject.create();
        item0.set("id", JSNumber.of(0));
        item0.set("text", JSString.of("Vegetables"));

        JSObject item1 = JSObject.create();
        item1.set("id", JSNumber.of(1));
        item1.set("text", JSString.of("Cheese"));

        JSObject item2 = JSObject.create();
        item2.set("id", JSNumber.of(2));
        item2.set("text", JSString.of("Whatever else humans are supposed to eat"));

        return JSArray.of(item0, item1, item2);
    }
}
