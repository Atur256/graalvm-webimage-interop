package io.github.atur256.webimageinterop.vue.temp.src.examples;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.vue.temp.src.*;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class VueDemo {

    // TODO: all JS code where "this" is needed needs to be as JS code because i cant find a way to get the "this" object into java

    public static void main(String[] args) {

        JSVueData data = JSVueData.builder()
                .set("message", "Hello World!")
                .set("count", 42)
                .set("buttonLabel", "Reset Count")
                .set("showRole", true)
                .set("user", () -> JSVueData.builder()
                        .set("name", "Alice")
                        .set("roles", JSArray.of("admin", "editor"))
                        .build())
                .set("duration", 15000)
                .set("elapsed", 0.0)
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

                .build();

        // Vue data function
        JSObject dataFn = JSVueData.wrapAsDataFunction(() -> data);

        // Vue methods
        JSObject methods = JSObject.create();
        methods.set("increment", JSFunction.fromRunnable(() -> {
            int current = JSVue.getValue("count", Integer.class);
            JSVue.setValue("count", current + 1);
        }));
        methods.set("toggleRole", JSFunction.fromRunnable(() -> {
            boolean current = JSVue.getValue("showRole", Boolean.class);
            JSVue.setValue("showRole", !current);
        }));
        methods.set("reset", JSFunction.fromRunnable(() -> JSVue.setValue("count", 0)));
        methods.set("resetTimer", JSEval.eval("""
                    (function() {
                        this.elapsed = 0;
                        this.lastTime = performance.now();
                        this.update();
                    })
                """));
        methods.set("update", JSEval.eval("""
                    (function() {
                        this.elapsed = performance.now() - this.lastTime;
                        if (this.elapsed >= this.duration) {
                            cancelAnimationFrame(this.handle);
                        } else {
                            this.handle = requestAnimationFrame(this.update);
                        }
                    })
                """));
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
            newItem.set("id", nextId);
            newItem.set("text", text);

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
        JSVueTemplate todoItemTemplate = JSVueTemplate.of(
                HtmlBuilder.li()
                        .text("{{ index + 1 }}. {{ todo.text }}")
                        .child(HtmlBuilder.span()
                                .attr("style", "cursor:pointer; margin-left:10px;")
                                .on("click", "$emit('remove', todo.id)")
                                .raw("&#10060;") // ❌ safely encoded
                        )
                        .toString()
        );


        JSObject components = JSObject.create();
        components.set("TodoItem", JSVueComponent.create()
                .setProps(JSArray.of("todo", "index"))
                .setTemplate(todoItemTemplate));


//        // HTML template
//        HtmlBuilder html = HtmlBuilder.div()
//                .child(HtmlBuilder.h1()
//                        .text("Hello ")
//                        .bind("message")
//                        .text(" (")
//                        .bind("count")
//                        .text(")")
//                )
//                .child(HtmlBuilder.p()
//                        .text("User: ")
//                        .bind("user.name")
//                )
//                .child(HtmlBuilder.rawHtml("""
//                            <ul v-if="showRole">
//                              <li v-for="role in user.roles">{{ role }}</li>
//                            </ul>
//                        """))
//                .child(HtmlBuilder.div()
//                        .attr("style", "margin-bottom:20px;")
//                        .child(HtmlBuilder.button("increment()", "Increment Count from Java code"))
//                        .child(HtmlBuilder.buttonBind("reset()", "buttonLabel"))
//                        .child(HtmlBuilder.button("toggleRole()", "Show role"))
//                )
//                .child(HtmlBuilder.div()
//                        .attr("style", "margin-bottom:10px;")
//                        .child(HtmlBuilder.label().raw("Elapsed Time: <progress :value=\"progressRate\"></progress>"))
//                        .child(HtmlBuilder.div().raw("{{ (elapsed / 1000).toFixed(1) }}s"))
//                        .child(HtmlBuilder.div()
//                                .raw("""
//                                            Duration: <input type="range" v-model="duration" min="1" max="30000">
//                                            {{ (duration / 1000).toFixed(1) }}s
//                                        """))
//                        .child(HtmlBuilder.button("resetTimer()", "Reset Timer")))
//                .child(HtmlBuilder.p()
//                        .child(HtmlBuilder.span()
//                                .bindAttr("title", "message")
//                                .text("Hover your mouse over me for a few seconds to see my dynamically bound title!")))
//                .child(HtmlBuilder.p()
//                        .bindAttr("class", "{ red: isRed }")
//                        .on("click", "toggleRed()")
//                        .text("This should be red... but click me to toggle it.")
//                )
//                .child(HtmlBuilder.p()
//                        .bindAttr("style", "{ color }")
//                        .on("click", "toggleColor()")
//                        .text("This should be green, and should toggle between green and blue on click.")
//                )
//                .child(HtmlBuilder.h2()
//                        .text("Text Input"))
//                .child(HtmlBuilder.input()
//                        .vModel("text"))
//                .child(HtmlBuilder.p()
//                        .bind("text"))
//                .child(HtmlBuilder.h2()
//                        .text("Checkbox"))
//                .child(HtmlBuilder.input()
//                        .attr("type", "checkbox")
//                        .attr("id", "checkbox")
//                        .vModel("checked"))
//                .child(HtmlBuilder.label()
//                        .attr("for", "checkbox")
//                        .text("Checked: ")
//                        .bind("checked"))
//                .child(HtmlBuilder.h2().text("Multi Checkbox"))
//                .child(HtmlBuilder.input()
//                        .attr("type", "checkbox")
//                        .attr("id", "jack")
//                        .attr("value", "Jack")
//                        .vModel("checkedNames"))
//                .child(HtmlBuilder.label().attr("for", "jack").text("Jack"))
//                .child(HtmlBuilder.input()
//                        .attr("type", "checkbox")
//                        .attr("id", "john")
//                        .attr("value", "John")
//                        .vModel("checkedNames"))
//                .child(HtmlBuilder.label()
//                        .attr("for", "john")
//                        .text("John"))
//                .child(HtmlBuilder.input()
//                        .attr("type", "checkbox")
//                        .attr("id", "mike")
//                        .attr("value", "Mike")
//                        .vModel("checkedNames"))
//                .child(HtmlBuilder.label()
//                        .attr("for", "mike")
//                        .text("Mike"))
//                .child(HtmlBuilder.p()
//                        .text("Checked names: ")
//                        .bind("checkedNames"))
//                .child(HtmlBuilder.h2().text("Radio"))
//                .child(HtmlBuilder.input()
//                        .attr("type", "radio")
//                        .attr("id", "one")
//                        .attr("value", "One")
//                        .vModel("picked"))
//                .child(HtmlBuilder.label()
//                        .attr("for", "one")
//                        .text("One"))
//                .child(HtmlBuilder.rawHtml("<br>"))
//                .child(HtmlBuilder.input()
//                        .attr("type", "radio")
//                        .attr("id", "two")
//                        .attr("value", "Two")
//                        .vModel("picked"))
//                .child(HtmlBuilder.label()
//                        .attr("for", "two")
//                        .text("Two"))
//                .child(HtmlBuilder.p()
//                        .text("Picked: ")
//                        .bind("picked"))
//                .child(HtmlBuilder.h2()
//                        .text("Select"))
//                .child(HtmlBuilder
//                        .select()
//                        .vModel("selected")
//                        .child(HtmlBuilder.option()
//                                .attr("disabled", "")
//                                .attr("value", "")
//                                .text("Please select one"))
//                        .child(HtmlBuilder.option().text("A"))
//                        .child(HtmlBuilder.option().text("B"))
//                        .child(HtmlBuilder.option().text("C")))
//                .child(HtmlBuilder.p()
//                        .text("Selected: ")
//                        .bind("selected"))
//                .child(HtmlBuilder.h2().text("Multi Select"))
//                .child(HtmlBuilder
//                        .select()
//                        .vModel("multiSelected")
//                        .attr("multiple", "true")
//                        .attr("style", "width:100px")
//                        .child(HtmlBuilder.option().text("A"))
//                        .child(HtmlBuilder.option().text("B"))
//                        .child(HtmlBuilder.option().text("C")))
//                .child(HtmlBuilder.p()
//                        .text("Selected: ")
//                        .bind("multiSelected"))
//                .child(HtmlBuilder.h2().text("Grocery List"))
//                .child(HtmlBuilder.input().vModel("newItemText"))
//                .child(HtmlBuilder.button("addItem()", "Add Item"))
//                .child(HtmlBuilder.rawHtml("""
//                            <todo-item
//                              v-for="(item, index) in groceryList"
//                              :todo="item"
//                              :index="index"
//                              :key="item.id"
//                              @remove="removeItem"
//                            ></todo-item>
//                        """)
//                );

        String html = """
                <div>
                  <h1>Hello {{ message }} ({{ count }})</h1>
                  <p>User: {{ user.name }}</p>
                  <ul v-if="showRole">
                    <li v-for="role in user.roles">{{ role }}</li>
                  </ul>
                  <div style="margin-bottom:20px;">
                    <button @click="increment()">Increment Count from Java code</button>
                    <button @click="reset()">{{ buttonLabel }}</button>
                    <button @click="toggleRole()">Show role</button>
                  </div>
                  <div style="margin-bottom:10px;">
                    <label>Elapsed Time: <progress :value="progressRate"></progress></label>
                    <div>{{ (elapsed / 1000).toFixed(1) }}s</div>
                    <div>
                      Duration: <input type="range" v-model="duration" min="1" max="30000">
                      {{ (duration / 1000).toFixed(1) }}s
                    </div>
                    <button @click="resetTimer()">Reset Timer</button>
                  </div>
                  <p>
                    <span :title="message">
                      Hover your mouse over me for a few seconds to see my dynamically bound title!
                    </span>
                  </p>
                  <p :class="{ red: isRed }" @click="toggleRed()">
                    This should be red... but click me to toggle it.
                  </p>
                  <p :style="{ color }" @click="toggleColor()">
                    This should be green, and should toggle between green and blue on click.
                  </p>
                  <h2>Text Input</h2>
                  <input v-model="text">
                  <p>{{ text }}</p>
                  <h2>Checkbox</h2>
                  <input type="checkbox" id="checkbox" v-model="checked">
                  <label for="checkbox">Checked: {{ checked }}</label>
                  <h2>Multi Checkbox</h2>
                  <input type="checkbox" id="jack" value="Jack" v-model="checkedNames">
                  <label for="jack">Jack</label>
                  <input type="checkbox" id="john" value="John" v-model="checkedNames">
                  <label for="john">John</label>
                  <input type="checkbox" id="mike" value="Mike" v-model="checkedNames">
                  <label for="mike">Mike</label>
                  <p>Checked names: {{ checkedNames }}</p>
                  <h2>Radio</h2>
                  <input type="radio" id="one" value="One" v-model="picked">
                  <label for="one">One</label><br>
                  <input type="radio" id="two" value="Two" v-model="picked">
                  <label for="two">Two</label>
                  <p>Picked: {{ picked }}</p>
                  <h2>Select</h2>
                  <select v-model="selected">
                    <option disabled value="">Please select one</option>
                    <option>A</option>
                    <option>B</option>
                    <option>C</option>
                  </select>
                  <p>Selected: {{ selected }}</p>
                  <h2>Multi Select</h2>
                  <select v-model="multiSelected" multiple style="width:100px">
                    <option>A</option>
                    <option>B</option>
                    <option>C</option>
                  </select>
                  <p>Selected: {{ multiSelected }}</p>
                  <h2>Grocery List</h2>
                  <input v-model="newItemText">
                  <button @click="addItem()">Add Item</button>
                  <todo-item
                    v-for="(item, index) in groceryList"
                    :todo="item"
                    :index="index"
                    :key="item.id"
                    @remove="removeItem"
                  ></todo-item>
                </div>
                """;

        JSVueTemplate template = JSVueTemplate.of(html.toString());

        JSObject hooks = JSObject.create();

        hooks.set("created", JSEval.eval("""
                    (function() {
                        this.resetTimer();
                    })
                """));
        hooks.set("unmounted", JSEval.eval("(function() { cancelAnimationFrame(this.handle); })"));

        JSObject computed = JSObject.create();
        computed.set("progressRate", JSEval.eval("""
                    (function() {
                        return Math.min(this.elapsed / this.duration, 1);
                    })
                """));

        JSVueOptions options = JSVueOptions.create()
                .setData(dataFn)
                .setMethods(methods)
                .setTemplate(template)
                .setComputed(computed)
                .setHooks(hooks)
                .setComponents(components);

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
