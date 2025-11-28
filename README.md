# GraalVM WebImage Interop

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

## Build & GraalVM Requirements

This project depends on a **GraalVM snapshot release** that is not available on Maven Central or other standard repositories.

**Download the latest GraalVM snapshot release** from the (official GraalVM Early Access GitHub releases)[https://github.com/graalvm/oracle-graalvm-ea-builds/releases/tag/jdk-25e1-25.0.1-ea.06].

---

### Build Script

The build script `build-script/build.sh` automates compilation and testing against unreleased GraalVM builds.

#### Configuration

The script requires two paths:
- `GRAALVM_BIN`: Path to the GraalVM `bin` directory (where `web-image` resides).
- `JAVA_HOME_OVERRIDE`: Path to the JDK you want to force for compilation. (Can be skipped)

#### Input Options

You can provide configuration either:

1. **Command-line arguments**:
   ```bash
   ./build.sh <GRAALVM_BIN> <JAVA_HOME_OVERRIDE> [--skip-tests]
   ```
2. **Configuration file (build.config)**:
  
    Define `GRAALVM_BIN` and `JAVA_HOME_OVERRIDE` in `build.config`. 

    Example:
    ```bash
    # === GraalVM Build Configuration ===
    # Path to GraalVM bin directory
    GRAALVM_BIN=/home/<user>/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_181A492ACC_JAVA25/graalvm-181a492acc-java25-25.1.0-dev/bin

    # Override JAVA_HOME (optional)
    JAVA_HOME_OVERRIDE=/usr/lib/jvm/java-25-openjdk
    ```
#### Flags

- `--skip-tests`: Skips test compilation and execution.

#### Steps Performed
1. **Compile with Maven**

   Runs `mvn clean package` with GraalVM native access enabled.
2. **Compile and Run Tests (optional)**

   Uses GraalVM `web-image` to compile the test runner into a JavaScript bundle, then executes it with [Node.js](https://nodejs.org/en).
3. **Copy Artifacts**

   Places the compiled library JAR (and test bundle if enabled) into the `output/` directory.

#### Example Usage
```bash
# Using command-line arguments
./build.sh /path/to/graalvm/bin /usr/lib/jvm/java-25-openjdk

# Using build.config
./build.sh
```

After completion, the compiled JAR and test bundle will be available in:

```bash
output/
```
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
