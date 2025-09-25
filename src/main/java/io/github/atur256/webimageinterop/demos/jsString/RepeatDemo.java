package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class RepeatDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.repeat Demo ===");

        JSString base = JSString.of("Echo");

        System.out.println("\"Echo\".repeat(3): " + base.repeat(3).as(String.class));
        // Expected: "Echo".repeat(3): EchoEchoEcho
    }
}
