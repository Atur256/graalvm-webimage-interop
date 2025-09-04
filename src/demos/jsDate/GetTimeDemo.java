package demos.jsDate;

import builtin.JSDate;


public class GetTimeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getTime Demo ===");
        JSDate date = new JSDate();
        System.out.println("Milliseconds since epoch: " + date.getTime());
        // Expected: Milliseconds since epoch: <timestamp>
    }
}
