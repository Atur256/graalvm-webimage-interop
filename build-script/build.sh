#!/bin/bash
set -euo pipefail

# === LOAD CONFIG ===
if [[ ! -f "./build.config" ]]; then
  echo "Missing build.config file. Please create one with GRAALVM_BIN, JAVA_HOME_OVERRIDE, and OUTPUT_DIR."
  exit 1
fi
source ./build.config

# === FORCE CONFIGURED JDK ===
if [[ -n "${JAVA_HOME:-}" ]]; then
  export JAVA_HOME="$JAVA_HOME"
  export PATH="$JAVA_HOME/bin:$PATH"
fi

# === CONFIGURATION ===
PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
MAIN_JAR="$PROJECT_DIR/target/graalvm-webimage-interop-0.0.1.jar"
TEST_JAR="$PROJECT_DIR/target/graalvm-webimage-interop-0.0.1-tests.jar"
TEST_RUNNER_CLASS="io.github.atur256.graalvmwebimageinterop.tests.TestRunner"
OUTPUT_DIR="$PROJECT_DIR/output"

# === FLAGS ===
RUN_TESTS=true
if [[ "${1:-}" == "--skip-tests" ]]; then
  RUN_TESTS=false
fi

## === STEP 1: Compile and package with Maven ===
echo "Building Maven project..."
cd "$PROJECT_DIR"
MAVEN_OPTS="--enable-native-access=ALL-UNNAMED" mvn clean package

## === STEP 2: Compile and run tests via WebImage (optional) ===
if [[ "$RUN_TESTS" == true ]]; then
  echo "Compiling tests with WebImage..."
  "$GRAALVM_BIN/web-image" \
    -H:+UnlockExperimentalVMOptions \
    -H:-ClosureCompiler \
    -o "$OUTPUT_DIR/Tests" \
    -Ob \
    -cp "$MAIN_JAR:$TEST_JAR" \
    "$TEST_RUNNER_CLASS"

  echo "Running tests..."
  node "$OUTPUT_DIR/Tests.js"

  echo "Tests passed."
else
  echo "Skipping tests as requested."
fi

## === STEP 3: Copy compiled library JAR to output ===
echo "Copying compiled library JAR to output..."
cp "$MAIN_JAR" "$OUTPUT_DIR/"

echo "Build complete. Test bundle and library JAR are in: $OUTPUT_DIR"
