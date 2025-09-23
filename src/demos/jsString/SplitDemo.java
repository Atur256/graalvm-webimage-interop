package demos.jsString;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class SplitDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.split Demo ===");

        JSString csv = JSString.of("red,green,blue,yellow");

        JSArray all1 = JSValue.checkedCoerce(csv.split(","), JSArray.class);
        JSArray all2 = JSValue.checkedCoerce(csv.split(""), JSArray.class);
        JSArray limited = JSValue.checkedCoerce( csv.split(",", 2), JSArray.class);

        System.out.println("\"red,green,blue,yellow\".split(','): " + all1.toString());
        System.out.println("\"red,green,blue,yellow\".split(''): " + all2.toString());
        System.out.println("\"red,green,blue,yellow\".split(',', 2): " + limited.toString());
        // Expected:
        // "red,green,blue,yellow".split(','): [red,green,blue,yellow]
        // "red,green,blue,yellow".split(''): [r,e,d,,,g,r,e,e,n,,,b,l,u,e,,,y,e,l,l,o,w]
        // "red,green,blue,yellow".split(',', 2): [red,green]
    }
}
