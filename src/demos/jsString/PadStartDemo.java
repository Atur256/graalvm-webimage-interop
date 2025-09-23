package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class PadStartDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.padStart Demo ===");

        JSString base = JSString.of("Hi");

        System.out.println("padStart(5): " + base.padStart(5).as(String.class));
        System.out.println("padStart(5, '-'): " + base.padStart(5, "-").as(String.class));
        System.out.println("padStart(7, JSString('-')): " + base.padStart(7, JSString.of("-")).as(String.class));
        // Expected:
        // padStart(5):    Hi
        // padStart(5, '-'): ---Hi
        // padStart(7, JSString('-')): -----Hi
    }
}
