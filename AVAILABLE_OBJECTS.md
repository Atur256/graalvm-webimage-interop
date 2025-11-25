## Available Objects

This document lists all Java wrappers provided by the **WebImage Interop Extension**, with links to their implementations and short descriptions of their purpose and functionality.

---

## Summary Table

| Java Wrapper | JavaScript Equivalent | Description |
|---------------|------------------------|--------------|
| `JSArray` | `Array` | Conversion, iteration, and composition utilities |
| `JSDate` | `Date` | Time manipulation, formatting, and timestamps |
| `JSError` | `Error` | Structured exception handling and diagnostics |
| `JSFunction` | `Function` | Callback interop and dynamic invocation |
| `JSIntl` | `Intl` | Locale-aware date, number, and message formatting |
| `JSIterator` | Iterator protocol | Iteration over arrays, maps, and sets |
| `JSJson` | `JSON` | Parsing and serialization utilities |
| `JSMap` | `Map` | Key-value storage and lookup interop |
| `JSMath` | `Math` | Mathematical constants and computation utilities |
| `JSPromise` | `Promise` | Asynchronous control flow and chaining |
| `JSRegExp` | `RegExp` | Pattern matching, search, and replace |
| `JSSet` | `Set` | Collection semantics for unique values |
| `JSUri` | `encodeURI` / `decodeURI` | URI encoding and decoding utilities |

---

## Core Wrappers

### JSArray
Java wrapper for JavaScript’s `Array`.  
Extends the core WebImage API with coercion, conversion, iteration, and functional composition utilities.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSArray.java)

---

### JSDate
Java wrapper for JavaScript’s `Date`.  
Provides access to time manipulation, formatting, and timestamp utilities.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSDate.java)

---

### JSError
Java wrapper for JavaScript’s `Error`.  
Supports structured exception handling and stack trace inspection.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSError.java)

---

### JSFunction
Java wrapper for JavaScript’s `Function`.  
Supports callback interop, argument binding, and dynamic invocation from Java.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSFunction.java)

---

### JSIntl
Java wrapper for JavaScript’s `Intl` namespace.  
Provides locale-aware formatting for dates, numbers, and messages.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSIntl.java)

---

### JSIterator
Java wrapper for JavaScript’s iterator protocol.  
Enables traversal of iterable structures such as arrays, maps, and sets.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSIterator.java)

---

### JSJson
Java wrapper for JavaScript’s `JSON` object.  
Provides serialization and parsing utilities for structured data exchange.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSJson.java)

---

### JSMap
Java wrapper for JavaScript’s `Map`.  
Supports key-value storage, iteration, and dynamic lookup.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSMap.java)

---

### JSMath
Java wrapper for JavaScript’s `Math` object.  
Exposes mathematical constants and functions for numeric computation.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSMath.java)

---

### JSPromise
Java wrapper for JavaScript’s `Promise`.  
Enables asynchronous control flow, chaining, and resolution tracking in Java.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSPromise.java)

---

### JSRegExp
Java wrapper for JavaScript’s `RegExp`.  
Supports pattern matching, search, and replace operations with Java interop.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSRegExp.java)

---

### JSSet
Java wrapper for JavaScript’s `Set`.  
Implements collection semantics for unique values, iteration, and membership checks.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSSet.java)

---

### JSUri
Java wrapper for JavaScript’s URI encoding and decoding utilities.  
Exposes `encodeURI`, `decodeURI`, and related functions for safe string transmission.  
[View Implementation](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/builtin/JSUri.java)

---

## Extensibility

The library is designed to be easily extended. Future releases may add wrappers for additional ECMAScript or WebImage features such as:

- `WeakMap`, `WeakSet`, and `Proxy`  
- `Reflect` and `Atomics`  
- Extended `Intl` capabilities (e.g., plural rules, segmenter)  

All new wrappers will adhere to the same idiomatic Java conventions and GraalVM compatibility standards.
