package demos.jsDate;

import builtin.JSDate;


public class GetMillisecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getMilliseconds Demo ===");
        JSDate date = new JSDate();
        System.out.println("Milliseconds: " + date.getMilliseconds());
        // Expected: Milliseconds: <0–999>
    }
}
