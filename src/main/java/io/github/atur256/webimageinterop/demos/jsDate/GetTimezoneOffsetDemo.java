package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;


public class GetTimezoneOffsetDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getTimezoneOffset Demo ===");

        JSDate date = new JSDate();
        int jsOffset = date.getTimezoneOffset();

        System.out.println("Timezone offset (minutes): " + jsOffset);
        // Expected: Timezone offset (minutes): -120 (for CEST)

        // Get system timezone offset in minutes
        ZoneOffset offset = ZonedDateTime.now(ZoneId.systemDefault()).getOffset();
        int javaOffset = -offset.getTotalSeconds() / 60;

        // Assert values
        assertEquals(javaOffset, jsOffset);
    }
}