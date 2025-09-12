package demos.jsPromise;

import builtin.JSArray;
import builtin.JSIterator;
import builtin.JSPromise;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSValue;

import java.util.List;


public class RaceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.race Demo ===");

        // Create sample promises
        JSPromise p1 = JSPromise.resolve("Winner A");
        JSPromise p1Reject = JSPromise.reject("Loser A");
        JSPromise p2 = JSPromise.resolve("Winner B");
        JSPromise p2Reject = JSPromise.reject("Loser B");
        JSPromise p3 = JSPromise.resolve("Winner C");

        // --- Using JSIterator directly ---
        JSArray jsArray1 = JSArray.of();
        jsArray1.push(p1);
        jsArray1.push(p2);
        jsArray1.push(p3);

        JSIterator jsIterator = JSIterator.from(jsArray1);
        JSPromise raceFromIterator = JSPromise.race(jsIterator);
        raceFromIterator.then(JSFunction.fromGeneralConsumer((JSValue result) ->
                System.out.println("Result from JSIterator: " + result.as(String.class))));
        // Expected: Result from JSIterator: Winner A

        // --- Using JSArray ---
        JSArray jsArray2 = JSArray.of();
        jsArray2.push(p1Reject);
        jsArray2.push(p2);
        jsArray2.push(p3);

        JSPromise raceFromArray = JSPromise.race(jsArray2);
        raceFromArray.then(JSFunction.fromGeneralConsumer((JSValue result) ->
                System.out.println("Result from JSArray: " + result.as(String.class))));
        // Expected: Result from JSArray: Winner B

        // --- Using varargs ---
        JSPromise raceFromVarargs = JSPromise.race(p1Reject, p2Reject, p3);
        raceFromVarargs.then(JSFunction.fromGeneralConsumer((JSValue result) ->
                System.out.println("Result from varargs: " + result.as(String.class))));
        // Expected: Result from varargs: Winner C

        // --- Using List<JSPromise> ---
        List<JSPromise> promiseList = List.of(p1Reject, p2Reject, p3);
        JSPromise raceFromList = JSPromise.race(promiseList);
        raceFromList.then(JSFunction.fromGeneralConsumer((JSValue result) ->
                System.out.println("Result from List: " + result.as(String.class))));
        // Expected: Result from List: Winner C
    }
}
