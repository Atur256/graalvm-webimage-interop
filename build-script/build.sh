#!/bin/bash
set -euo pipefail

# === CONFIGURATION ===
PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
OUTPUT_DIR="$PROJECT_DIR/output"

# === ARGUMENTS OR CONFIG FILE ===
if [[ $# -ge 2 ]]; then
  echo "Using command-line arguments for configuration..."
  GRAALVM_BIN="$1"
  JAVA_HOME_OVERRIDE="$2"
  FLAG="${3:-}"
else
  CONFIG_FILE="$PROJECT_DIR/build-script/build.config"
  if [[ ! -f "$CONFIG_FILE" ]]; then
    echo "Usage: $0 <GRAALVM_BIN> <JAVA_HOME_OVERRIDE> [--skip-tests]"
    echo "Or provide a build.config file with GRAALVM_BIN and JAVA_HOME_OVERRIDE."
    exit 1
  fi
  echo "Loading configuration from $CONFIG_FILE..."
  source "$CONFIG_FILE"
  FLAG="${1:-}"
fi

# === FLAGS ===
RUN_TESTS=true
if [[ "$FLAG" == "--skip-tests" ]]; then
  RUN_TESTS=false
fi

# === FORCE CONFIGURED JDK ===
export JAVA_HOME="$JAVA_HOME_OVERRIDE"
export PATH="$JAVA_HOME/bin:$PATH"

MAIN_JAR="$PROJECT_DIR/target/graalvm-webimage-interop-0.0.1.jar"
OUTPUT_TEST_DIR="$OUTPUT_DIR/tests"

# === STEP 1: Compile main and test code with Maven ===
echo "Building Maven project..."
cd "$PROJECT_DIR"
MAVEN_OPTS="--enable-native-access=ALL-UNNAMED" mvn clean package

# === STEP 2: Compile and run tests via WebImage (optional) ===
if [[ "$RUN_TESTS" == true ]]; then
  echo "Compiling tests with WebImage..."

  # Find all compiled test classes
  TEST_CLASSES_DIR="$PROJECT_DIR/target/test-classes"
  MAIN_CLASSES_DIR="$PROJECT_DIR/target/classes"

  mkdir -p "$OUTPUT_TEST_DIR"

  "$GRAALVM_BIN/native-image" \
    -Dcom.oracle.graalvm.iswebimage=true \
    --tool:svm-wasm \
    -H:+UnlockExperimentalVMOptions \
    -o "$OUTPUT_TEST_DIR/Tests" \
    -Ob \
    -H:-ClosureCompiler \
    -cp "$MAIN_CLASSES_DIR:$TEST_CLASSES_DIR" \
    io.github.atur256.graalvmwebimageinterop.tests.TestRunner

  echo "Running tests..."
  node "$OUTPUT_TEST_DIR/Tests.js"

  echo "Tests passed."
else
  echo "Skipping tests as requested."
fi

# === STEP 3: Copy compiled library JAR to output ===
echo "Copying compiled library JAR to output..."
mkdir -p "$OUTPUT_DIR"
cp "$MAIN_JAR" "$OUTPUT_DIR/"

echo "Build complete. Test bundle and library JAR are in: $OUTPUT_DIR"

