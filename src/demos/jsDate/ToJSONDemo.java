package demos.jsDate;

import builtin.JSDate;


public class ToJSONDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.toJSON Demo ===");
        JSDate date = new JSDate();
        System.out.println("JSON string: " + date.toJSON());
        // Expected: Example: JSON string: 2025-09-04T11:58:00.000Z
    }
}
