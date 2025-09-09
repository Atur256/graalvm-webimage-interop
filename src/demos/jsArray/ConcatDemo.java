package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

import java.util.List;


public class ConcatDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSArray.concat Demo ===");

        // Concatenate with JS arrays
        JSArray a1 = JSArray.of(1,2);
        JSArray a2 = JSArray.of(new JSValue[]{JSNumber.of(3), JSNumber.of(4)});
        JSArray a3 = JSArray.of(5);

        JSArray result = a1.concat(new JSArray[]{a2, a3});
        System.out.println("Concatenated: " + result.toString()); // Expected: [1, 2, 3, 4, 5]

        JSArray base = JSArray.of("base");

        // Concatenate with Java arrays
        int[] nums = {1, 2, 3};
        String[] fruits = {"apple", "banana"};
        boolean[] flags = {true, false};

        JSArray result1 = base.concat(nums, fruits, flags);
        System.out.println("Result: " + result1.toString()); // ["base",1,2,3,"apple","banana",true,false]

        // Concatenate with List
        List<String> extras = List.of("x", "y");
        JSArray result2 = base.concat(extras);
        System.out.println("With List: " + result2.toString()); // ["base","x","y"]
    }
}
