package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetTimezoneOffsetDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getTimezoneOffset Demo ===");
        JSDate date = new JSDate();
        System.out.println("Timezone offset (minutes): " + date.getTimezoneOffset());
        // Expected: Timezone offset (minutes): -120 (for CEST)
    }
}
