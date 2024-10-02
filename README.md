# http-invoker-alternative

This is a sample spring-boot based project that shows alternatives to using http-invoker mechanism between a set of client and server applications. The client and server applications share a `library` code that includes the service interfaces and any DTOs. The server application implement/expose the service interfaces, while the client application consumes the service interfaces.

The [`main`](https://github.com/maliksalman/spring-http-invoker-alternative) branch implements this pattern using http-invoker mechanism that was available in spring-framework until version 5.x. Although they were present in version 5.x, the classes associated with this mechanism were marked as deprecated to discourage their usage. Staring in spring-framework 6, this mechanism was completely removed. The applications are based on spring-boot 2.7.x which depends on spring-framework 5.3.x

The [`alternative-rest-spring5`](https://github.com/maliksalman/spring-http-invoker-alternative/tree/alternative-rest-spring5) branch implements this using `RestController` on the server side and `RestTemplate` on the client side. The applications are based on spring-boot 2.7.x which depends on spring-framework 5.3.x

The [`alternative-rest-spring6`](https://github.com/maliksalman/spring-http-invoker-alternative/tree/alternative-rest-spring6) branch implements this using `RestController` on the server side and `HttpExchange` on the client side. The applications are based on spring-boot 3.3.x which depends on spring-framework 6.1.x
