# Copilot / AI contributor guidance for hw3-karniguez

This repository is a small Java assignment (three exercises + tests). The guidance below is focused, actionable, and specific to this project so an AI coding agent can be immediately productive.

1) Big picture
- **Purpose:** three standalone Java programs implementing algorithmic exercises: `Algebra.java` (integer arithmetic primitives and `sqrt`), `Anagram.java` (string anagram utilities), and `LoanCalc.java` (compute loan payments). Tests are provided as plain Java programs (`TestAlgebra.java`, `TestAnagram.java`).
- **Structure:** top-level `.java` files; no build system (Maven/Gradle). Source and tests are in repository root. `README.md` contains submission notes.

2) How to build & run locally (no external tools)
- **Compile everything:** `javac *.java`
- **Run tests:** `java TestAlgebra` and `java TestAnagram` (each is a `main` runner that prints pass/fail counts).
- **Run example program:** `java LoanCalc <loan> <rate> <periods>` (e.g. `java LoanCalc 10000 1.5 12`) — `LoanCalc` expects three args: loan amount (double), interest rate percent (double), number of payments (int).

3) Project-specific constraints and conventions
- **Single-file, plain Java:** no external libs or build scripts; keep edits minimal and localized to the appropriate `.java` file unless instructed otherwise.
- **Static methods & main-heavy tests:** helper functions are `static` and tests call them directly (e.g., `Algebra.plus(...)`). Preserve method signatures and names when fixing behavior or adding tests.
- **Forbidden-operator check (critical):** `TestAlgebra.java` performs a static check on the `Algebra.java` source to detect forbidden usage. It strips comments/strings then searches for the following patterns: `+` (binary plus), `-` (binary minus), `*`, `/`, `%`, `Math.pow`, and `Math.sqrt`. Avoid introducing these tokens literally in `Algebra.java`'s implementation when the exercise requires their exclusion. If you must change `Algebra.java`, follow the assignment's constraint: implement arithmetic using allowed primitive operations (or safe equivalently allowed constructs) so tests still pass.

4) Testing details & edge cases to keep in mind
- `TestAlgebra.java` checks boundary conditions (e.g., `Integer.MAX_VALUE`, `Integer.MIN_VALUE`) — avoid producing overflows that make tests fail.
- `TestAnagram.java` expects `preProcess` to convert letters to lowercase, remove punctuation but preserve spaces, and `isAnagram` to ignore spaces and case when appropriate (see test examples: `"William Shakespeare"` vs `"I am a weakish speller"`). `randomAnagram` should return a permutation of the same characters.

5) Typical changes an AI might do (examples)
- Fix a logic bug in `LoanCalc.endBalance`: keep the same method signature and behavior (returns loan remaining after applying `n` periods). Example invocation: `endBalance(10000, 1.5, 12, 850.0)`.
- Implement `Anagram.isAnagram`, `preProcess`, `randomAnagram` using only standard `String`/`char[]` operations and `java.util` utilities. Unit tests call these directly.
- When editing `Algebra.java`, do not add `+`, `-`, `*`, `/`, `%`, `Math.pow`, or `Math.sqrt` tokens in the file body (the test will detect and fail). Use loops, comparisons and increments/decrements in ways that satisfy the assignment and the test-suite.

6) File access and paths
- Tests read source files relative to repo root (e.g., `Paths.get("Algebra.java")`) — keep filenames unchanged and at the repository root.

7) Pull request & commit tips for humans (brief)
- Run `javac *.java` and both tests locally before committing. Include a short commit message describing the change and which tests were run.

8) Example quick checklist for an AI change
- Compile: `javac *.java` — ensure no new compile errors
- Run: `java TestAlgebra` and `java TestAnagram` — they should report expected pass counts
- If changing `Algebra.java`, verify the forbidden-operator test still passes

If any section above is unclear or you want additional examples (e.g., a proposed implementation of `isAnagram` that matches the test expectations), tell me which section and I will expand it with code snippets or a short runnable example.
