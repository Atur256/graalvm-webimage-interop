package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class RepeatDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.repeat Demo ===");

        JSString base = JSString.of("Echo");

        String result = base.repeat(3).as(String.class);
        System.out.println("\"Echo\".repeat(3): " + result);
        // Expected: "Echo".repeat(3): EchoEchoEcho

        // Assert values
        assertEquals("EchoEchoEcho", result);
    }
}
