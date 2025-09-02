package demos;

import builtin.Number;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;


public class NumberDemo {

    public static void main(String[] args) {

        System.out.println("1000 / 0.0 is finite: " + Number.isFinite(1000 / 0.0));

        System.out.println("1.0 / 3.0 is finite: " + Number.isFinite(1.0 / 3.0));

        System.out.println("1234 is a number: " + Number.isNaN(JSNumber.of(1234)).asBoolean());

        System.out.println("\"1234\" is a number: " + Number.isNaN(JSString.of("1234")).asBoolean());

        System.out.println("\"abc\" is a number: " + Number.isNaN(JSString.of("abc")).asBoolean());

        System.out.println("3.4 as float is: " + Number.parseFloat(3.4));

        System.out.println("3 as float is: " + Number.parseFloat(3));

        System.out.println("\"3.4\" as float is: " + Number.parseFloat("3.4"));

        System.out.println("\"a\" as float is: " + Number.parseFloat("a"));

        System.out.println("3.4 as int is: " + Number.parseInt(3.4));

        System.out.println("3 as int is: " + Number.parseInt(3));

        System.out.println("\"3\" as int is: " + Number.parseInt("3"));

        System.out.println("\"Hello\" as int is: " + Number.parseInt("a"));

        System.out.println("\"0xF4\" as int is: " + Number.parseInt("0xF4", 16));
    }
}
