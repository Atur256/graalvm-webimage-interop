package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class ToWellFormedDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.toWellFormed Demo ===");

        JSString[] strings = new JSString[]{
                // Lone leading surrogate
                JSString.of("ab").concat(JSString.fromCodePoint(0xD800)),
                JSString.of("ab").concat(JSString.fromCodePoint(0xD800)).concat(JSString.of("c")),

                // Lone trailing surrogate
                JSString.fromCodePoint(0xDFFF).concat(JSString.of("ab")),
                JSString.of("c").concat(JSString.fromCodePoint(0xDFFF)).concat(JSString.of("ab")),

                // Well-formed
                JSString.of("abc"),
                JSString.of("ab").concat(JSString.fromCodePoint(0x1F604)).concat(JSString.of("c")) // 😄
        };

        for(JSString js : strings) {
            System.out.println("toWellFormed(): " + js.toWellFormed().as(String.class));
        }

        // Expected output:
        // toWellFormed(): ab�
        // toWellFormed(): ab�c
        // toWellFormed(): �ab
        // toWellFormed(): c�ab
        // toWellFormed(): abc
        // toWellFormed(): ab😄c
    }
}
