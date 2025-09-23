package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class ToLocaleLowerCaseDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.toLocaleLowerCase Demo ===");

        JSString turkish = JSString.fromCodePoint(0x0130).concat(JSString.of("stanbul"));
        System.out.println("fromCodePoint(\"İstanbul\").toLocaleLowerCase(): " + turkish.toLocaleLowerCase().as(String.class));
        System.out.println("fromCodePoint(\"İstanbul\").toLocaleLowerCase(\"tr\"): " + turkish.toLocaleLowerCase("tr").as(String.class));
        System.out.println("fromCodePoint(\"İstanbul\").toLocaleLowerCase(JSString(\"tr\")): " + turkish.toLocaleLowerCase(JSString.of("tr")).as(String.class));
        // Expected:
        // fromCodePoint("İstanbul").toLocaleLowerCase(): i̇stanbul
        // fromCodePoint("İstanbul").toLocaleLowerCase("tr"): istanbul
        // fromCodePoint("İstanbul").toLocaleLowerCase(JSString("tr")): istanbul

        JSString english = JSString.of("HELLO WORLD");
        System.out.println("fromCodePoint(\"HELLO WORLD\").toLocaleLowerCase(): " + english.toLocaleLowerCase().as(String.class));
        System.out.println("fromCodePoint(\"HELLO WORLD\").toLocaleLowerCase(\"en\"): " + english.toLocaleLowerCase("en").as(String.class));
        System.out.println("fromCodePoint(\"HELLO WORLD\").toLocaleLowerCase(JSString(\"en\")): " + english.toLocaleLowerCase(JSString.of("en")).as(String.class));
        // Expected:
        // fromCodePoint("HELLO WORLD").toLocaleLowerCase(): hello world
        // fromCodePoint("HELLO WORLD").toLocaleLowerCase("en"): hello world
        // fromCodePoint("HELLO WORLD").toLocaleLowerCase(JSString("en")): hello world
    }
}
