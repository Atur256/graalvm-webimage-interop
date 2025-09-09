package demos.jsPromise;

import builtin.JSArray;
import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class PromiseAllDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.all Demo ===");

        // === JSValue-based promises ===
        JSArray promises = JSArray.of(new JSValue[]{
                JSPromise.resolve(JSNumber.of(1)),
                JSPromise.resolve(JSNumber.of(2)),
                JSPromise.resolve(JSNumber.of(3))
        }); // TODO: update Array to new version

        JSPromise all = JSPromise.all(promises);
        all.then(JSFunction.fromBody("console.log('All resolved:', arg)"));
        // Expected: All resolved: [1, 2, 3]

//        // === Java String ===
//        JSArray stringPromises = JSArray.of(new Object[]{
//                JSPromise.resolve("One"),
//                JSPromise.resolve("Two"),
//                JSPromise.resolve("Three")
//        });
//
//        JSPromise stringAll = JSPromise.all(stringPromises);
//        stringAll.then(JSFunction.fromBody("console.log('Strings resolved:', arg)"));
//        // Expected: Strings resolved: ["One", "Two", "Three"]
//
//        // === Java Double ===
//        JSArray doublePromises = JSArray.of(new Object[]{
//                JSPromise.resolve(1.1),
//                JSPromise.resolve(2.2),
//                JSPromise.resolve(3.3)
//        });
//
//        JSPromise doubleAll = JSPromise.all(doublePromises);
//        doubleAll.then(JSFunction.fromBody("console.log('Doubles resolved:', arg)"));
//        // Expected: Doubles resolved: [1.1, 2.2, 3.3]
//
//        // === Java Boolean ===
//        JSArray boolPromises = JSArray.of(new Object[]{
//                JSPromise.resolve(true),
//                JSPromise.resolve(false),
//                JSPromise.resolve(true)
//        });
//
//        JSPromise boolAll = JSPromise.all(boolPromises);
//        boolAll.then(JSFunction.fromBody("console.log('Booleans resolved:', arg)"));
//        // Expected: Booleans resolved: [true, false, true]
//
//        // === Custom Class ===
//        CustomValue a = new CustomValue("A");
//        CustomValue b = new CustomValue("B");
//        CustomValue c = new CustomValue("C");
//
//        JSArray customPromises = JSArray.of(new Object[]{
//                JSPromise.resolve(a.toString()),
//                JSPromise.resolve(b.toString()),
//                JSPromise.resolve(c.toString())
//        });
//
//        JSPromise customAll = JSPromise.all(customPromises);
//        customAll.then(JSFunction.fromBody("console.log('Custom values resolved:', arg)"));
//        // Expected: Custom values resolved: ["Custom(A)", "Custom(B)", "Custom(C)"]
    }

    // Simple record for custom object
    record CustomValue(String label) {

        @Override
        public String toString() {
            return "Custom(" + label + ")";
        }
    }
}
