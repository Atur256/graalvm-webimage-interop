package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class PadEndDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.padEnd Demo ===");

        JSString base = JSString.of("Hi");

        System.out.println("padEnd(5): " + base.padEnd(5).as(String.class));
        System.out.println("padEnd(5, '*'): " + base.padEnd(5, "*").as(String.class));
        System.out.println("padEnd(7, JSString('*')): " + base.padEnd(7, JSString.of("*")).as(String.class));
        // Expected:
        // padEnd(5): Hi
        // padEnd(5, '*'): Hi***
        // padEnd(7, JSString('*')): Hi*****
    }
}
