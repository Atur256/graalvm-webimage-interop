package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;

import java.util.List;


public class ConcatDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.concat Demo ===");

        // Concatenate with JS arrays
        JSArray a1 = JSArray.of(1, 2);
        JSArray a2 = JSArray.of(JSNumber.of(3), JSNumber.of(4));
        JSArray a3 = JSArray.of(5);

        JSArray result = a1.concat(new JSArray[]{a2, a3});
        System.out.println("Concatenated: " + result.toString());
        // Expected: Concatenated: [1,2,3,4,5]

        JSArray base = JSArray.of("base");

        // Concatenate with Java arrays
        int[] num = {1, 2, 3};
        String[] fruits = {"apple", "banana"};
        boolean[] flags = {true, false};

        JSArray result1 = base.concat(num, fruits, flags);
        System.out.println("Result: " + result1.toString());
        // Expected: Result: [base,1,2,3,apple,banana,true,false]

        // Concatenate with List
        List<String> extras = List.of("x", "y");
        JSArray result2 = base.concat(extras);
        System.out.println("With List: " + result2.toString());
        // Expected: With List: [base,x,y]
    }
}
