package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class GetMonthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getMonth Demo ===");
        JSDate date = new JSDate();
        System.out.println("Month (0=Jan): " + date.getMonth());
        // Expected: Month (0=Jan): <1-12>
    }
}
