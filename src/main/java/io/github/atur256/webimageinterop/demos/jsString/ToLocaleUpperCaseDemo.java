package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class ToLocaleUpperCaseDemo {


    public static void main(String[] args) {
        System.out.println("\n=== JSString.toLocaleUpperCase Demo ===");

        JSString turkish = JSString.fromCodePoint(0x0069).concat(JSString.of("stanbul"));
        String result1 = turkish.toLocaleUpperCase().as(String.class);
        String result2 = turkish.toLocaleUpperCase("tr").as(String.class);
        String result3 = turkish.toLocaleUpperCase(JSString.of("tr")).as(String.class);
        System.out.println("fromCodePoint(\"istanbul\").toLocaleUpperCase(): " + result1);
        System.out.println("fromCodePoint(\"istanbul\").toLocaleUpperCase(\"tr\"): " + result2);
        System.out.println("fromCodePoint(\"istanbul\").toLocaleUpperCase(JSString(\"tr\")): " + result3);
        // Expected:
        // fromCodePoint("istanbul").toLocaleUpperCase(): ISTANBUL
        // fromCodePoint("istanbul").toLocaleUpperCase("tr"): İSTANBUL
        // fromCodePoint("istanbul").toLocaleUpperCase(JSString("tr")): İSTANBUL

        JSString english = JSString.of("hello world");
        String result4 = english.toLocaleUpperCase().as(String.class);
        String result5 = english.toLocaleUpperCase("en").as(String.class);
        String result6 = english.toLocaleUpperCase(JSString.of("en")).as(String.class);
        System.out.println("fromCodePoint(\"hello world\").toLocaleUpperCase(): " + result4);
        System.out.println("fromCodePoint(\"hello world\").toLocaleUpperCase(\"en\"): " + result5);
        System.out.println("fromCodePoint(\"hello world\").toLocaleUpperCase(JSString(\"en\")): " + result6);
        // Expected:
        // fromCodePoint("hello world").toLocaleUpperCase(): HELLO WORLD
        // fromCodePoint("hello world").toLocaleUpperCase("en"): HELLO WORLD
        // fromCodePoint("hello world").toLocaleUpperCase(JSString("en")): HELLO WORLD

        // Assert values
        assertEquals("ISTANBUL", result1);
        assertEquals("İSTANBUL", result2);
        assertEquals("İSTANBUL", result3);
        assertEquals("HELLO WORLD", result4);
        assertEquals("HELLO WORLD", result5);
        assertEquals("HELLO WORLD", result6);
    }
}