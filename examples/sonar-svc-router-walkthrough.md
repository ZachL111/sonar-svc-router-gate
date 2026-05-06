# Sonar Svc Router Gate Walkthrough

The fixture is intentionally compact, so the review starts with the cases that pull farthest apart.

| Case | Focus | Score | Lane |
| --- | --- | ---: | --- |
| baseline | queue pressure | 191 | ship |
| stress | retry load | 173 | ship |
| edge | worker slack | 204 | ship |
| recovery | session drift | 142 | ship |
| stale | queue pressure | 254 | ship |

Start with `stale` and `recovery`. They create the widest contrast in this repository's fixture set, which makes them better review anchors than the middle cases.

`stale` is the optimistic case; use it to make sure the scoring path still rewards strong signal.
