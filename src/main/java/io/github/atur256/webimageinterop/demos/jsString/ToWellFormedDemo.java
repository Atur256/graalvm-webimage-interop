package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class ToWellFormedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.toWellFormed Demo ===");

        // Lone leading surrogate
        JSString str1 = JSString.of("ab").concat(JSString.fromCodePoint(0xD800));
        JSString str2 = JSString.of("ab").concat(JSString.fromCodePoint(0xD800)).concat(JSString.of("c"));
        // Lone trailing surrogate
        JSString str3 = JSString.fromCodePoint(0xDFFF).concat(JSString.of("ab"));
        JSString str4 = JSString.of("c").concat(JSString.fromCodePoint(0xDFFF)).concat(JSString.of("ab"));
        // Well-formed
        JSString str5 = JSString.of("abc");
        JSString str6 = JSString.of("ab").concat(JSString.fromCodePoint(0x1F604)).concat(JSString.of("c")); // 😄

        String result1 = str1.toWellFormed().as(String.class);
        String result2 = str2.toWellFormed().as(String.class);
        String result3 = str3.toWellFormed().as(String.class);
        String result4 = str4.toWellFormed().as(String.class);
        String result5 = str5.toWellFormed().as(String.class);
        String result6 = str6.toWellFormed().as(String.class);

        System.out.println(str1.as(String.class) + ".toWellFormed(): " + result1);
        System.out.println(str2.as(String.class) + ".toWellFormed(): " + result2);
        System.out.println(str3.as(String.class) + ".toWellFormed(): " + result3);
        System.out.println(str4.as(String.class) + ".toWellFormed(): " + result4);
        System.out.println(str5.as(String.class) + ".toWellFormed(): " + result5);
        System.out.println(str6.as(String.class) + ".toWellFormed(): " + result6);
        // Expected output:
        // ab�.toWellFormed(): ab�
        // ab�c.toWellFormed(): ab�c
        // �ab.toWellFormed(): �ab
        // c�ab.toWellFormed(): c�ab
        // abc.toWellFormed(): abc
        // ab😄c.toWellFormed(): ab😄c

        // Assert values
        assertEquals("ab�", result1);
        assertEquals("ab�c", result2);
        assertEquals("�ab", result3);
        assertEquals("c�ab", result4);
        assertEquals("abc", result5);
        assertEquals("ab\uD83D\uDE04c", result6);
    }
}