package demos.jsDate;

import builtin.JSDate;


public class NowDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.now Demo ===");
        System.out.println("Current timestamp: " + JSDate.now());
        // Expected: Current timestamp: <milliseconds since epoch>
    }
}
