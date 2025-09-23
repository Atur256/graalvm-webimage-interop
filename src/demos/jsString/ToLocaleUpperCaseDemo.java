package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class ToLocaleUpperCaseDemo {


    public static void main(String[] args) {
        System.out.println("=== JSString.toLocaleUpperCase Demo ===");

        JSString turkish = JSString.fromCodePoint(0x0069).concat(JSString.of("stanbul"));
        System.out.println("fromCodePoint(\"istanbul\").toLocaleUpperCase(): " + turkish.toLocaleUpperCase().as(String.class));
        System.out.println("fromCodePoint(\"istanbul\").toLocaleUpperCase(\"tr\"): " + turkish.toLocaleUpperCase("tr").as(String.class));
        System.out.println("fromCodePoint(\"istanbul\").toLocaleUpperCase(JSString(\"tr\")): " + turkish.toLocaleUpperCase(JSString.of("tr")).as(String.class));
        // Expected:
        // fromCodePoint("istanbul").toLocaleUpperCase(): ISTANBUL
        // fromCodePoint("istanbul").toLocaleUpperCase("tr"): İSTANBUL
        // fromCodePoint("istanbul").toLocaleUpperCase(JSString("tr")): İSTANBUL

        JSString english = JSString.of("hello world");
        System.out.println("fromCodePoint(\"hello world\").toLocaleUpperCase(): " + english.toLocaleUpperCase().as(String.class));
        System.out.println("fromCodePoint(\"hello world\").toLocaleUpperCase(\"en\"): " + english.toLocaleUpperCase("en").as(String.class));
        System.out.println("fromCodePoint(\"hello world\").toLocaleUpperCase(JSString(\"en\")): " + english.toLocaleUpperCase(JSString.of("en")).as(String.class));
        // Expected:
        // fromCodePoint("hello world").toLocaleUpperCase(): HELLO WORLD
        // fromCodePoint("hello world").toLocaleUpperCase("en"): HELLO WORLD
        // fromCodePoint("hello world").toLocaleUpperCase(JSString("en")): HELLO WORLD
    }
}
