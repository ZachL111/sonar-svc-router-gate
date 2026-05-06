# Field Notes

`sonar-svc-router-gate` is easiest to review by starting with the fixture, not the prose.

The domain cases cover `queue pressure`, `retry load`, `worker slack`, and `session drift`. They sit beside the smaller starter fixture so the project has both a compact scoring check and a domain-flavored review check.

`stale` is the strongest case at 254 on `queue pressure`. `recovery` is the cautious anchor at 142 on `session drift`.

The point is not to make the repository bigger. The point is to make the important judgment testable.
