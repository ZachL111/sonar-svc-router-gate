# sonar-svc-router-gate

`sonar-svc-router-gate` keeps a focused Kotlin implementation around backend services. The project goal is to design a Kotlin verification harness for router systems, covering event replay, fixture event logs, and failure-oriented tests.

## Why This Exists

The point is to make a small domain rule concrete enough that a reader can change it and immediately see what broke.

## Sonar Svc Router Gate Review Notes

For a quick review, compare `queue pressure` with `session drift` before reading the middle cases.

## Capabilities

- `fixtures/domain_review.csv` adds cases for queue pressure and retry load.
- `metadata/domain-review.json` records the same cases in structured form.
- `config/review-profile.json` captures the read order and the two review questions.
- `examples/sonar-svc-router-walkthrough.md` walks through the case spread.
- The Kotlin code includes a review path for `queue pressure` and `session drift`.
- `docs/field-notes.md` explains the strongest and weakest cases.

## Implementation Shape

The implementation keeps the scoring rule plain: reward signal and confidence, preserve slack, penalize drag, then classify the result into a review lane.

The Kotlin code keeps the review rule close to the tests.

## Local Usage

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

## Verification

The verifier is intentionally local. It should fail if the fixture score math, lane assignment, or language-specific test drifts.

## Roadmap

No external service is required. A deeper version would add more negative cases and a clearer boundary around invalid input.
