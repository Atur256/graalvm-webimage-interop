# WebImage Interop Extension

This library extends the [Oracle GraalVM WebImage API](https://www.graalvm.org/sdk/javadoc/org/graalvm/webimage/api/package-summary.html) by providing Java wrappers for core [JavaScript global objects](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects). Its goal is to improve usability within GraalVM-managed runtimes by offering a consistent, idiomatic interface for JavaScript interop. It emphasizes clarity and maintainability, making it easier to build robust and reproducible interop logic in Java.

---

## Available Objects

### `JSArray`

Java wrapper for JavaScript’s `Array`, extending the core WebImage API with coercion, conversion, iteration, and composition utilities.  

See [JSArray.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSArray.java) for implementation details.

### `JSDate`

Java wrapper for JavaScript’s `Date`, providing access to time manipulation, formatting, and timestamp utilities.  

See [JSDate.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSDate.java) for implementation details.

### `JSError`

Java wrapper for JavaScript’s `Error`, enabling structured exception handling, stack trace inspection, and diagnostic propagation.  

See [JSError.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSError.java) for implementation details.

### `JSEval`

Java wrapper for JavaScript’s `eval`, allowing controlled execution of dynamic JavaScript expressions within GraalVM-managed runtimes.  

See [JSEval.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSEval.java) for implementation details.

### `JSFunction`

Java wrapper for JavaScript’s `Function`, supporting callback interop, argument binding, and dynamic invocation from Java.  

See [JSFunction.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSFunction.java) for implementation details.

### `JSIntl`

Java wrapper for JavaScript’s `Intl` namespace, exposing locale-aware formatting for dates, numbers, and messages.  

See [JSIntl.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSIntl.java) for implementation details.

### `JSIterator`

Java wrapper for JavaScript’s iterator protocol, enabling traversal of iterable structures such as arrays, maps, and sets.  

See [JSIterator.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSIterator.java) for implementation details.

### `JSJson`

Java wrapper for JavaScript’s `JSON` object, providing serialization and parsing utilities for structured data exchange.  

See [JSJson.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSJson.java) for implementation details.

### `JSMap`

Java wrapper for JavaScript’s `Map`, supporting key-value storage, iteration, and dynamic lookup with Java interop.  

See [JSMap.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSMap.java) for implementation details.

### `JSMath`

Java wrapper for JavaScript’s `Math` object, exposing mathematical constants and functions for numeric computation.  

See [JSMath.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSMath.java) for implementation details.

### `JSPromise`

Java wrapper for JavaScript’s `Promise`, enabling asynchronous control flow, chaining, and resolution tracking in Java.  

See [JSPromise.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSPromise.java) for implementation details.

### `JSRegExp`

Java wrapper for JavaScript’s `RegExp`, supporting pattern matching, search, and replace operations with Java interop.  

See [JSRegExp.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSRegExp.java) for implementation details.

### `JSSet`

Java wrapper for JavaScript’s `Set`, providing collection semantics for unique values with iteration and membership checks.  

See [JSSet.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSSet.java) for implementation details.

### `JSUri`

Java wrapper for URI encoding and decoding utilities, exposing `encodeURI`, `decodeURI`, and related functions for safe string transmission. 

See [JSUri.java](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSUri.java) for implementation details.

---

## Skipped Functions

Certain JavaScript functions were intentionally not wrapped due to limited interop value, mutability concerns, or complexity in GraalVM-managed runtimes. These can be accessed via `JSFunction.fromBody(...).call()` if needed.

### `JSError`

The following properties and methods were skipped due to lack of standardization or runtime support:

- `isError` — not available in the GraalVM WebImage runtime
- `stackTraceLimit` — not standardized across environments
- `columnNumber` — non-standard and inconsistently supported
- `fileName` — non-standard and not exposed in GraalVM
- `lineNumber` — non-standard and not exposed in GraalVM
- `stack` — not reliably available or standardized

### `JSPromise`

The following feature was skipped due to absence in the underlying JavaScript engine:

- `Promise.try(...)` — not available in the GraalVM WebImage runtime; not part of standard ECMAScript

---

## Usage Examples

Every implemented function in this library is accompanied by a corresponding demo class under the `io.github.atur256.webimageinterop.demos` package. These demos illustrate how to use each wrapper in practice, including setup, invocation, and expected behavior.

See the [demo package](https://github.com/Atur256/web-image-interop/tree/master/src/main/java/io/github/atur256/webimageinterop/demos)

---

## Testing

In addition to serving as usage examples, all demo classes act as validation harnesses. They include inline assertions (`assert` or JUnit-style) to verify correctness and runtime behavior.

The `Main` class invokes the execution of all demos. Running it will automatically invoke every demo and validate all implemented functionality.

See the [Main class](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/Main.java)

## Further Extensions

This library is designed for extensibility. While it currently wraps a broad set of core JavaScript objects, additional wrappers may be introduced in future releases to support more of the ECMAScript runtime and browser-like APIs.

All future additions will adhere to the same design principles and compatibility with GraalVM-managed runtimes.