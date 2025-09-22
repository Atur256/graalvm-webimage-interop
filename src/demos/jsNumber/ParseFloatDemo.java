package demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;


public class ParseFloatDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.parseFloat Demo ===");

        // Number inputs
        System.out.println("parseFloat(42):" + JSNumber.parseFloat(42));               // 42.0
        System.out.println("parseFloat(3.1415): " + JSNumber.parseFloat(3.1415));       // 3.1415
        // Expected:
        // parseFloat(42):42.0
        // parseFloat(3.1415): 3.1415


        // String inputs
        System.out.println("parseFloat(\"123.456\"): " + JSNumber.parseFloat("123.456")); // 123.456
        System.out.println("parseFloat(\"3.14abc\"): " + JSNumber.parseFloat("3.14abc")); // 3.14
        System.out.println("parseFloat(\"abc\"): " + JSNumber.parseFloat("abc"));         // NaN
        // Expected:
        // parseFloat("123.456"): 123.456
        // parseFloat("3.14abc"): 3.14
        // parseFloat("abc"): NaN
    }
}
