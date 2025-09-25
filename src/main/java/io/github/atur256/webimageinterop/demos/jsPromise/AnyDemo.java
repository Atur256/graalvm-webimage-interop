package io.github.atur256.webimageinterop.demos.jsPromise;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;
import io.github.atur256.webimageinterop.builtin.JSPromise;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import java.util.List;


public class AnyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.any Demo ===");

        JSPromise p1Resolved = JSPromise.resolve("First");
        JSPromise p1Reject = JSPromise.reject("First");
        JSPromise p2Resolved = JSPromise.resolve("Second");
        JSPromise p2Reject = JSPromise.reject("Second");
        JSPromise p3Resolved = JSPromise.resolve("Third");
        JSPromise p3Reject = JSPromise.reject("Third");

        // --- Using JSIterator directly ---
        JSArray jsArray1 = JSArray.of();
        jsArray1.push(p1Resolved);
        jsArray1.push(p2Resolved);
        jsArray1.push(p3Reject);

        JSIterator jsIterator = JSIterator.from(jsArray1);
        JSPromise anyFromJSIterator = JSPromise.any(jsIterator);
        anyFromJSIterator.then(JSFunction.fromGeneralConsumer((JSValue result) ->
                System.out.println("Result from JSIterator: " + result.as(String.class))));
        // Expected: Result from JSIterator: First

        // --- Using JSArray ---
        JSArray jsArray2 = JSArray.of();
        jsArray2.push(p1Reject);
        jsArray2.push(p2Resolved);
        jsArray2.push(p3Resolved);

        JSPromise anyFromJSArray = JSPromise.any(jsArray2);
        anyFromJSArray.then(JSFunction.fromGeneralConsumer((JSString result) ->
                System.out.println("Result from JSArray: " + result.as(String.class))));
        // Expected: Result from JSArray: Second

        // --- Using varargs ---
        JSPromise anyFromVarargs = JSPromise.any(p1Reject, p2Reject, p3Resolved);
        anyFromVarargs.then(JSFunction.fromGeneralConsumer((JSString result) ->
                System.out.println("Result from varargs: " + result.as(String.class))));
        // Expected: Result from varargs: Third

        // --- Using List<JSPromise> ---
        List<JSPromise> promiseList = List.of(p1Reject, p2Reject, p3Resolved);
        JSPromise anyFromList = JSPromise.any(promiseList);
        anyFromList.then(JSFunction.fromGeneralConsumer((JSString result) ->
                System.out.println("Result from List: " + result.as(String.class))));
        // Expected: Result from List: Third
    }
}
