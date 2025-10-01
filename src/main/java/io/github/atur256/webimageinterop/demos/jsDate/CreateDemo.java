package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CreateDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.create Demo ===");

        JSDate d0 = JSDate.create();
        String str0 = d0.toString();
        System.out.println("new Date():" + str0);
        // Expected(varies with execution time and timezone): new Date(): Wed Oct 01 2025 09:57:27 GMT+0200 (Central European Summer Time)

        Pattern pattern0 = Pattern.compile("^[A-Z][a-z]{2} [A-Z][a-z]{2} \\d{2} \\d{4} " + "\\d{2}:\\d{2}:\\d{2} GMT[+-]\\d{4} \\(.+\\)$");
        assertTrue(pattern0.matcher(str0).matches());

        JSDate d1 = JSDate.create(1759564800000.0);
        String str1 = d1.toString();
        System.out.println("new Date(value): " + str1);
        // Expected: new Date(value): Sat Oct 04 2025 10:00:00 GMT+0200 (Central European Summer Time)

        Pattern pattern1 = Pattern.compile("^Sat Oct 04 2025 10:00:00 GMT[+-]\\d{4} \\(.+\\)$");
        assertTrue(pattern1.matcher(str1).matches());

        JSDate d2 = JSDate.create("2025-10-01T08:00:00Z");
        String str2 = d2.toString();
        System.out.println("new Date(dateString): " + str2);
        // Expected: new Date(dateString): Wed Oct 01 2025 10:00:00 GMT+0200 (Central European Summer Time)

        Pattern pattern2 = Pattern.compile("^Wed Oct 01 2025 10:00:00 GMT[+-]\\d{4} \\(.+\\)$");
        assertTrue(pattern2.matcher(str2).matches());

        JSDate d3 = JSDate.create(d2);
        String str3 = d3.toString();
        System.out.println("new Date(dateObject): " + str3);
        // Expected: new Date(dateObject): Wed Oct 01 2025 10:00:00 GMT+0200 (Central European Summer Time)

        assertTrue(pattern2.matcher(str3).matches());


        JSDate d4 = JSDate.create(2025, 10); // October 1
        String str4 = d4.toString();
        System.out.println("new Date(year, month): " + str4);
        // Expected: new Date(year, month): Sat Nov 01 2025 00:00:00 GMT+0100 (Central European Standard Time)

        Pattern pattern4 = Pattern.compile("^Sat Nov 01 2025 00:00:00 GMT[+-]\\d{4} \\(.+\\)$");
        assertTrue(pattern4.matcher(str4).matches());


        JSDate d5 = JSDate.create(2025, 10, 3);
        String str5 = d5.toString();
        System.out.println("new Date(year, month, day): " + str5);
        // Expected: new Date(year, month, day): Mon Nov 03 2025 00:00:00 GMT+0100 (Central European Standard Time)


        JSDate d6 = JSDate.create(2025, 10, 3, 8);
        String str6 = d6.toString();
        System.out.println("new Date(year, month, day, hours): " + str6);
        // Expected: new Date(year, month, day, hours): Mon Nov 03 2025 08:00:00 GMT+0100 (Central European Standard Time)

        Pattern pattern5 = Pattern.compile("^Sat Nov 0132025 08:00:00 GMT[+-]\\d{4} \\(.+\\)$");
        assertTrue(pattern5.matcher(str5).matches());


        JSDate d7 = JSDate.create(2025, 10, 3, 8, 30);
        String str7 = d7.toString();
        System.out.println("new Date(year, month, day, hours, minutes): " + str7);
        // Expected: new Date(year, month, day, hours, minutes): Mon Nov 03 2025 08:30:00 GMT+0100 (Central European Standard Time)

        Pattern pattern6 = Pattern.compile("^Sat Nov 0132025 08:30:00 GMT[+-]\\d{4} \\(.+\\)$");
        assertTrue(pattern6.matcher(str6).matches());


        JSDate d8 = JSDate.create(2025, 10, 3, 8, 30, 15);
        String str8 = d8.toString();
        System.out.println("new Date(year, month, day, hours, minutes, seconds): " + str8);
        // Expected: new Date(year, month, day, hours, minutes, seconds): Mon Nov 03 2025 08:30:15 GMT+0100 (Central European Standard Time)

        Pattern pattern7 = Pattern.compile("^Sat Nov 0132025 08:30:15 GMT[+-]\\d{4} \\(.+\\)$");
        assertTrue(pattern7.matcher(str7).matches());

        JSDate d9 = JSDate.create(2025, 10, 3, 8, 30, 15, 123);
        String str9 = d9.toString();
        System.out.println("new Date(year, month, day, hours, minutes, seconds, ms): " + str9);
        // Expected: new Date(year, month, day, hours, minutes, seconds, ms): Mon Nov 03 2025 08:30:15 GMT+0100 (Central European Standard Time)

        Pattern pattern8 = Pattern.compile("^Sat Nov 0132025 08:30:15 GMT[+-]\\d{4} \\(.+\\)$");
        assertTrue(pattern8.matcher(str8).matches());

        // Assert values

    }

}