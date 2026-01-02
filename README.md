# GraalVM WebImage Interop

This library extends the [Oracle GraalVM WebImage API](https://www.graalvm.org/sdk/javadoc/org/graalvm/webimage/api/package-summary.html) by providing Java wrappers for core [JavaScript global objects](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects).

It offers a consistent and idiomatic interface for JavaScript interop within GraalVM-managed runtimes, focusing on clarity, type safety, and maintainability. The goal is to make Java–JavaScript interoperability predictable, testable, and straightforward.

---

## Features

- Idiomatic Java interfaces for core JavaScript objects
- Type-safe conversion, evaluation, and iteration utilities
- Full GraalVM WebImage runtime compatibility
- Dedicated, per-class test coverage
- Extensible structure for future ECMAScript wrappers

---

## Build & GraalVM Requirements

This project depends on a **GraalVM snapshot release** that is currently not available on Maven Central.

**Download the latest GraalVM snapshot release** from the [official GraalVM Early Access GitHub releases](https://github.com/graalvm/oracle-graalvm-ea-builds/releases/tag/jdk-25e1-25.0.1-ea.06).

The [GraalVM Maven Plugin](https://graalvm.github.io/native-build-tools/latest/maven-plugin.html) is used for both compilation and for generating native test artifacts.

---

### Build

To build the library normally, simply run:
```bash
mvn clean package
```

This performs a standard Maven build and produces the main JAR file in:
```
target/
```
**No native-image test bundles** are created executed in this mode.

---

## Available JavaScript Wrappers

This project provides Java wrappers for many standard ECMAScript global objects, such as arrays, maps, dates, promises, and regular expressions.

Full documentation for all wrappers can be found in the separate reference file:

[See Available Objects](./AVAILABLE_OBJECTS.md)

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
If needed, they can still be accessed using the `JSFunction.fromBody(...)` utilities.

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

Native-image-based tests are built using the `test-native` Maven profile:

```bash
mvn clean package -Ptest-native
```

### What this does:
- Compiles the project
- Uses the GraalVM Maven plugin to build the **native-image test bundle**
- Places the test bundle into:
```
target/native-tests/
```

### Running the Tests
The test bundle can be executed directly using [Node.js](https://nodejs.org/en):
```bash
node target/native-tests/tests.js
```
This bundle includes the **full native-image-compiled test runner** and require no additional tooling beyond Node.js.

See the [RunAllTests class](https://github.com/Atur256/graalvm-webimage-interop/blob/master/src/main/java/io/github/atur256/webimageinterop/tests/RunAllTests.java)

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
- [Node.js](https://nodejs.org/en)
