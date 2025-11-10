# WebImage Interop Extension

This library extends the [Oracle GraalVM WebImage API](https://www.graalvm.org/sdk/javadoc/org/graalvm/webimage/api/package-summary.html) by providing Java wrappers for core [JavaScript global objects](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects).

It offers a consistent and idiomatic interface for JavaScript interop within GraalVM-managed runtimes, focusing on clarity, type safety, and maintainability. The goal is to make Java–JavaScript interoperability predictable, testable, and straightforward.

---

## Features

- Idiomatic Java interfaces for core JavaScript objects
- Type-safe conversion, evaluation, and iteration utilities
- Full GraalVM WebImage runtime compatibility
- Dedicated, per-class JUnit test coverage
- Extensible structure for future ECMAScript wrappers

---

## GraalVM Requirement

**Important:**  
This library currently depends on a version of GraalVM that has **not yet been officially released**.  
It cannot be pulled from Maven Central or other standard repositories.

To build and use this library:

1. **Download or build the latest GraalVM version** from the [official GraalVM GitHub repository](https://github.com/oracle/graal).
2. **Compile the project locally** using this GraalVM build.
3. Use `mvn install` or `gradle build` to complete the compilation.

Standard Maven or Gradle builds with released GraalVM versions will not currently succeed.

---

## Available JavaScript Wrappers

This project provides Java wrappers for many standard ECMAScript global objects, such as arrays, maps, dates, promises, and regular expressions.

Full documentation for all wrappers can be found in the separate reference file:

[See Available Objects →](./AVAILABLE_OBJECTS.md)

---

## Design Principles

This library is designed around several guiding principles:
- Predictable behavior consistent with ECMAScript semantics
- Strong typing and safe coercion between Java and JavaScript values
- Isolation from JavaScript mutability and side effects
- Minimal use of reflection and clear API boundaries
- Extensible architecture for new interop features as GraalVM evolves

---
 
## Skipped or Deferred Functions

Certain JavaScript features are intentionally excluded due to non-standardization, limited interop value, or lack of GraalVM runtime support.
If needed, they can still be accessed using the `JSEval` or `JSFunction.fromBody(...)` utilities.

**JSError**

The following properties are skipped:
- `isError`
- `stackTraceLimit`
- `columnNumber`
- `fileName`
- `lineNumber`
- `stack`

**JSPromise**

The following feature is skipped:

- `Promise.try(...)` — not part of the ECMAScript standard and unavailable in the GraalVM WebImage runtime.

---

## Testing

Each JavaScript wrapper has its own dedicated test class.

- **Per-class testing:** Each test class corresponds to a single wrapper (e.g., `JSArrayTest`).
- **Full test suite:** The `RunAllTests` class aggregates all test classes and runs the complete suite.

See the [RunAllTests class](https://github.com/Atur256/web-image-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/tests/RunAllTests.java)

---

## Future Extensions

This library is designed for extensibility. While it currently wraps a broad set of core JavaScript objects, additional wrappers may be introduced in future releases to support more of the ECMAScript runtime and browser-like APIs.

---

## License

This project is licensed under the **Apache License, Version 2.0**.

You may obtain a copy of the License at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under this License is distributed on an "AS IS" basis, without warranties or conditions of any kind.

See the [LICENSE](./LICENSE) file for details.


---

## Resources
- [GraalVM Documentation](https://www.graalvm.org/latest/docs/)
- [WebImage API Reference](https://www.graalvm.org/sdk/javadoc/org/graalvm/webimage/api/package-summary.html)
- [MDN JavaScript Global Objects](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects)
