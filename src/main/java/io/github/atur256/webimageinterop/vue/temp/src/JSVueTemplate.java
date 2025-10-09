package io.github.atur256.webimageinterop.vue.temp.src;

import org.graalvm.webimage.api.JSString;

import java.util.ArrayDeque;
import java.util.Deque;

public class JSVueTemplate {
    private final JSString html;

    private JSVueTemplate(String html) {
        this.html = JSString.of(html);
    }

    public String get() {
        return html.asString();
    }

    public JSString getJS() {
        return html;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static JSVueTemplate of(String rawHtml) {
        return new JSVueTemplate(rawHtml);
    }

    public static final class Builder {
        private final StringBuilder sb = new StringBuilder();
        private final Deque<String> tagStack = new ArrayDeque<>();

        public Builder open(String tag) {
            sb.append("<").append(tag).append(">");
            tagStack.push(tag);
            return this;
        }

        public Builder open(String tag, String attributes) {
            sb.append("<").append(tag).append(" ").append(attributes).append(">");
            tagStack.push(tag);
            return this;
        }

        public Builder text(String content) {
            sb.append(content);
            return this;
        }

        public Builder bind(String expression) {
            sb.append("{{ ").append(expression).append(" }}");
            return this;
        }

        public Builder raw(String htmlFragment) {
            sb.append(htmlFragment);
            return this;
        }

        public JSVueTemplate build() {
            while (!tagStack.isEmpty()) {
                sb.append("</").append(tagStack.pop()).append(">");
            }
            return new JSVueTemplate(sb.toString());
        }
    }
}
