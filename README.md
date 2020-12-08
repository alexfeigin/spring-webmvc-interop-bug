# spring-webmvc-interop-bug

This is a springboot tester created to replicate an issue I have. Using the latest snapshot (5.3.2) of spring-webmvc and the latest gratest release of spring. (5.3.1)

it looks like `AsyncServerResponse` has an interop problem with function routing.

related issue in spring-framework [issue 26239](https://github.com/spring-projects/spring-framework/issues/26239)

fixed by [commit 2b77c08](https://github.com/spring-projects/spring-framework/commit/2b77c08e09d978d35cfc85584972ce8a0270fd45)
