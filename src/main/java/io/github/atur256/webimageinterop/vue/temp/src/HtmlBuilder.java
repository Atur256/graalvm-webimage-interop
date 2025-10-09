package io.github.atur256.webimageinterop.vue.temp.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class HtmlBuilder {

    // TODO: only for testing, either needs to be reworked or replaced with raw html string

    static {
        System.err.println("This class is only for testing purposes, as it is not completed or tested!!!");
    }

    private final String tag;
    private final List<HtmlBuilder> children = new ArrayList<>();
    private final StringBuilder textContent = new StringBuilder();
    private final List<Attribute> attributes = new ArrayList<>();

    private static class Attribute {

        String name;
        String value;

        Attribute(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

    public HtmlBuilder(String tag) {
        this.tag = tag;
    }

    public static HtmlBuilder element(String tag) {
        return new HtmlBuilder(tag);
    }

    public static HtmlBuilder div() {
        return element("div");
    }

    public static HtmlBuilder h1() {
        return element("h1");
    }

    public static HtmlBuilder h2() {
        return element("h2");
    }

    public static HtmlBuilder h3() {
        return element("h3");
    }

    public static HtmlBuilder p() {
        return element("p");
    }

    public static HtmlBuilder ul() {
        return element("ul");
    }

    public static HtmlBuilder li() {
        return element("li");
    }

    public static HtmlBuilder button() {
        return element("button");
    }

    public static HtmlBuilder span() {
        return element("span");
    }

    public static HtmlBuilder form() {
        return element("form");
    }

    public static HtmlBuilder input() {
        return element("input");
    }

    public static HtmlBuilder label() {
        return element("label");
    }

    public static HtmlBuilder select() {
        return element("select");
    }

    public static HtmlBuilder option() {
        return element("option");
    }

    public static HtmlBuilder a() {
        return element("a");
    }

    public static HtmlBuilder rawHtml(String htmlFragment) {
        return element("raw").raw(htmlFragment);
    }

    public HtmlBuilder text(String text) {
        this.textContent.append(text);
        return this;
    }

    public HtmlBuilder bind(String expression) {
        this.textContent.append("{{ ").append(expression).append(" }}");
        return this;
    }

    public HtmlBuilder raw(String htmlFragment) {
        this.textContent.append(htmlFragment);
        return this;
    }

    public HtmlBuilder child(HtmlBuilder child) {
        this.children.add(child);
        return this;
    }

    public HtmlBuilder attr(String name, String value) {
        this.attributes.add(new Attribute(name, value));
        return this;
    }

    public HtmlBuilder vIf(String condition) {
        return attr("v-if", condition);
    }

    public HtmlBuilder vFor(String item, String source) {
        return attr("v-for", item + " in " + source);
    }

    public HtmlBuilder vModel(String model) {
        return attr("v-model", model);
    }

    public HtmlBuilder onClick(String expression) {
        return attr("@click", expression);
    }

    public HtmlBuilder bindAttr(String name, String expression) {
        return attr(":" + name, expression);
    }

    public HtmlBuilder on(String event, String expression) {
        return attr("@" + event, expression);
    }

    public static HtmlBuilder button(String click, String label) {
        return button().onClick(click).text(label);
    }

    public static HtmlBuilder buttonBind(String click, String bindExpr) {
        return button().onClick(click).bind(bindExpr);
    }

    public static HtmlBuilder buttonIf(String click, String label, String condition) {
        return button().onClick(click).vIf(condition).text(label);
    }

    public static HtmlBuilder buttonDisabled(String label) {
        return button().attr("disabled", "true").text(label);
    }

    public static HtmlBuilder buttonRaw(String html) {
        return button().raw(html);
    }

    public static HtmlBuilder buttonWithModifier(String event, String modifier, String handler, String label) {
        return button().attr("@" + event + "." + modifier, handler).text(label);
    }

    @Override
    public String toString() {
        if("raw" .equals(tag)) {
            return textContent.toString();
        }

        String attrs = attributes.stream()
                .map(a -> String.format("%s=\"%s\"", a.name, escapeHtml(a.value)))
                .collect(Collectors.joining(" "));

        String openTag = attrs.isEmpty() ? "<" + tag + ">" : "<" + tag + " " + attrs + ">";

        if(children.isEmpty() && textContent.isEmpty()) {
            return openTag.substring(0, openTag.length() - 1) + " />";
        }

        String innerHtml = textContent +
                children.stream().map(HtmlBuilder::toString).collect(Collectors.joining());

        return openTag + innerHtml + "</" + tag + ">";
    }

    private static String escapeHtml(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    public static HtmlBuilder htmlDoc(HtmlBuilder bodyContent) {
        return element("html")
                .child(element("head")
                        .child(element("title").text("Generated Page")))
                .child(element("body").child(bodyContent));
    }
}
