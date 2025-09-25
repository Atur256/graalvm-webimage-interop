package io.github.atur256.webimageinterop.demos.jsPromise;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;
import io.github.atur256.webimageinterop.builtin.JSPromise;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import java.util.List;


public class AllSettledDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.allSettled Demo ===");

        // Create sample promises: some resolve, some reject
        JSPromise p1 = JSPromise.resolve("Success A");
        JSPromise p2 = JSPromise.reject("Failure B");
        JSPromise p3 = JSPromise.resolve("Success C");

        // Create JSArray
        JSArray jsArray = JSArray.of();
        jsArray.push(p1);
        jsArray.push(p2);
        jsArray.push(p3);

        // --- Using JSIterator directly ---
        JSPromise settledFromIterator = JSPromise.allSettled(JSIterator.from(jsArray));
        settledFromIterator.then(printResults("Result from JSIterator:"));
        // Expected:
        // Result from JSIterator:
        //  - Status: fulfilled
        //  - Status: rejected
        //  - Status: fulfilled

        // --- Using JSArray ---
        JSPromise settledFromArray = JSPromise.allSettled(jsArray);
        settledFromArray.then(printResults("Result from JSArray:"));
        // Expected:
        // Result from JSArray:
        //  - Status: fulfilled
        //  - Status: rejected
        //  - Status: fulfilled

        // --- Using varargs ---
        JSPromise settledFromVarargs = JSPromise.allSettled(p1, p2, p3);
        settledFromVarargs.then(printResults("Result from varargs:"));
        // Expected:
        // Result from varargs:
        //  - Status: fulfilled
        //  - Status: rejected
        //  - Status: fulfilled

        // --- Using List<JSPromise> ---
        List<JSPromise> promiseList = List.of(p1, p2, p3);
        JSPromise settledFromList = JSPromise.allSettled(promiseList);
        settledFromList.then(printResults("Result from List:"));
        // Expected:
        // Result from List:
        //  - Status: fulfilled
        //  - Status: rejected
        //  - Status: fulfilled
    }

    private static JSFunction printResults(String label) {
        return JSFunction.fromConsumer((JSValue result) -> {
            JSArray array = result.as(JSArray.class);
            System.out.println(label);
            for(int i = 0; i < array.length; i++) {
                JSObject entry = array.at(i, JSObject.class);
                System.out.println("  - " + objectToString(entry));
            }
        });
    }

    private static String objectToString(JSObject object) {
        String status = ((JSValue) object.get("status")).as(String.class);
        String value = hasKey(object, "value") ? ((JSValue) object.get("value")).as(String.class) : null;
        String reason = hasKey(object, "reason") ? ((JSValue) object.get("reason")).as(String.class) : null;

        return "Status: " + status +
                (value != null ? ", Value: " + value : "") +
                (reason != null ? ", Reason: " + reason : "");
    }

    private static boolean hasKey(JSObject object, String key) {
        Object rawKeys = object.keys();
        if(rawKeys instanceof JSArray jsArray) {
            for(int i = 0; i < jsArray.length; i++) {
                String currentKey = jsArray.at(i, String.class);
                if(key.equals(currentKey)) return true;
            }
        }
        return false;
    }
}
