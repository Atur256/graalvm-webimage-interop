package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class PadEndDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.padEnd Demo ===");

        JSString base = JSString.of("Hi");

        String result1 = base.padEnd(5).as(String.class);
        String result2 = base.padEnd(5, "*").as(String.class);
        String result3 = base.padEnd(7, JSString.of("*")).as(String.class);
        System.out.println("padEnd(5): " + result1);
        System.out.println("padEnd(5, '*'): " + result2);
        System.out.println("padEnd(7, JSString('*')): " + result3);
        // Expected:
        // padEnd(5): Hi
        // padEnd(5, '*'): Hi***
        // padEnd(7, JSString('*')): Hi*****

        // Assert values
        assertEquals("Hi   ", result1);
        assertEquals("Hi***", result2);
        assertEquals("Hi*****", result3);
    }
}