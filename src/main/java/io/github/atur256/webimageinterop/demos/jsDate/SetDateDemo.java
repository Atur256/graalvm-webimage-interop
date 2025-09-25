package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetDateDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setDate Demo ===");
        JSDate date = new JSDate();
        date.setDate(15);
        System.out.println("Updated day of month: " + date.getDate());
        // Expected: Updated day of month: <1-31>
    }
}
