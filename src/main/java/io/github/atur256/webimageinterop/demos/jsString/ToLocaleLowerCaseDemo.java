package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class ToLocaleLowerCaseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.toLocaleLowerCase Demo ===");

        JSString turkish = JSString.fromCodePoint(0x0130).concat(JSString.of("stanbul"));
        String result1 = turkish.toLocaleLowerCase().as(String.class);
        String result2 = turkish.toLocaleLowerCase("tr").as(String.class);
        String result3 = turkish.toLocaleLowerCase(JSString.of("tr")).as(String.class);
        System.out.println("fromCodePoint(\"İstanbul\").toLocaleLowerCase(): " + result1);
        System.out.println("fromCodePoint(\"İstanbul\").toLocaleLowerCase(\"tr\"): " + result2);
        System.out.println("fromCodePoint(\"İstanbul\").toLocaleLowerCase(JSString(\"tr\")): " + result3);
        // Expected:
        // fromCodePoint("İstanbul").toLocaleLowerCase(): i̇stanbul
        // fromCodePoint("İstanbul").toLocaleLowerCase("tr"): istanbul
        // fromCodePoint("İstanbul").toLocaleLowerCase(JSString("tr")): istanbul

        JSString english = JSString.of("HELLO WORLD");
        String result4 = english.toLocaleLowerCase().as(String.class);
        String result5 = english.toLocaleLowerCase("en").as(String.class);
        String result6 = english.toLocaleLowerCase(JSString.of("en")).as(String.class);
        System.out.println("fromCodePoint(\"HELLO WORLD\").toLocaleLowerCase(): " + result4);
        System.out.println("fromCodePoint(\"HELLO WORLD\").toLocaleLowerCase(\"en\"): " + result5);
        System.out.println("fromCodePoint(\"HELLO WORLD\").toLocaleLowerCase(JSString(\"en\")): " + result6);
        // Expected:
        // fromCodePoint("HELLO WORLD").toLocaleLowerCase(): hello world
        // fromCodePoint("HELLO WORLD").toLocaleLowerCase("en"): hello world
        // fromCodePoint("HELLO WORLD").toLocaleLowerCase(JSString("en")): hello world

        // Assert values
        assertEquals("i̇stanbul", result1);
        assertEquals("istanbul", result2);
        assertEquals("istanbul", result3);
        assertEquals("hello world", result4);
        assertEquals("hello world", result5);
        assertEquals("hello world", result6);
    }
}