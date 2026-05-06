# sonar-svc-router-gate

`sonar-svc-router-gate` explores backend services in Kotlin. The repository keeps the core rule set compact, then surrounds it with examples that show how the decisions move.

## Sonar Svc Router Gate Notes

The quickest review path is the verifier first, then the fixtures, then the operations note. That order makes it easy to see whether the code, data, and explanation still agree.

## Feature Notes

- Includes extended examples for queue pressure, including `surge` and `degraded`.
- Documents bounded workers tradeoffs in `docs/operations.md`.
- Runs locally with a single verification command and no external credentials.
- Stores project constants and verification metadata in `metadata/project.json`.
- Adds a repository audit script that checks structure before running the language verifier.

## Why This Exists

I use this kind of project to make a rule visible before adding more machinery around it. The important part here is not the size of the codebase. It is that the input signals, scoring rule, fixture data, and expected output can all be checked in one sitting.

## Code Tour

- `src`: primary implementation
- `tests`: verification harness
- `fixtures`: compact golden scenarios
- `examples`: expanded scenario set
- `metadata`: project constants and verification metadata
- `docs`: operations and extension notes
- `scripts`: local verification and audit commands

## Implementation Notes

The core is a scoring model over demand, capacity, latency, risk, and weight. That keeps job state, retry rules, and queue pressure in one explicit decision path. The threshold is 165, with risk penalty 6, latency penalty 4, and weight bonus 3. The Kotlin version keeps data classes and model logic close together for a JVM-friendly core.

## Try It

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

This runs the language-level build or test path against the compact fixture set.

## Example Scenarios

The examples are meant to be readable before they are exhaustive. They cover enough variation to show how latency and risk can pull a decision below the threshold.

## Tests

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/audit.ps1
```

The audit command checks repository structure and README constraints before it delegates to the verifier.

## Boundaries

The fixture set is deliberately small. That keeps the review surface clear, but it also means the model should not be treated as a complete domain simulator.

## Roadmap

- Add malformed input fixtures so the failure path is as visible as the happy path.
- Split the scoring constants into a typed configuration object and validate it before use.
- Add a comparison mode that shows how decisions change when one signal is adjusted.
- Add one more backend services fixture that focuses on a malformed or borderline input.

## Local Setup

Use a normal shell with Kotlin available on `PATH`. The verifier is written as a PowerShell script because the portfolio was assembled on Windows.
