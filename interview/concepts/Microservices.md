
## Tracing in micro-services
### Spring Cloud Sleuth 

	- Uses [Brave](https://github.com/openzipkin/brave) as the tracing library that adds unique ids to each web request that enters our application
	- Adds two types of IDs to log. trace ID & span ID. traceId contains set of spanIDs
    - Enabled by adding following dependency in pom.xml
		 <dependency
    		<groupIdorg.springframework.cloud</groupId
    		<artifactIdspring-cloud-starter-sleuth</artifactId
		 </dependency
    - Example log looks like this
    	 2016-06-15 16:55:56.334 INFO [slueth-sample,44462edc42f2ae73,44462edc42f2ae73,false] 13978 --- [nio-8080-exec-1] com.example.SleuthSampleApplication : calling home
		- The first part is the application name (whatever you set spring.application.name to in bootstrap.yml). 
        - The second value is the trace id. 
        - The third value is the span id. Finally the last value indicates whether the span should be exported to Zipkin
   	- It will add following headers in the request
    	 X-B3-SpanId: fbf39ca6e571f294 X-B3-TraceId: fbf39ca6e571f294
    - We can new spans using Tracer 
		 @Autowired
		 private Tracer tracer;
 		// ...
 		public void doSomeWorkNewSpan() throws InterruptedException {
    		logger.info("I'm in the original span");
	    	Span newSpan = tracer.nextSpan().name("newSpan").start();
    		try (SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
        		Thread.sleep(1000L);
        		logger.info("I'm in the new span doing some cool work that needs its own span");
    		} finally {
        		newSpan.finish();
    		}
 	    	logger.info("I'm in the original span");
		}
	- Using LazyTraceExecutor we can propagate traceIds to new threads
### Links
[One](https://dzone.com/articles/tracing-in-microservices-with-spring-cloud-sleuth) | [Two](https://www.baeldung.com/spring-cloud-sleuth-single-application)

### Support Zipkin
-Add following dependency
> <dependency 
>  <groupIdorg.springframework.cloud</groupId 
>  <artifactIdspring-cloud-sleuth-zipkin</artifactId 
></dependency>
-Add spring.zipkin.baseUrl to specify zipkin url




[Design patterns for microservices](https://dzone.com/articles/design-patterns-for-microservices)

[Service discovery using netflix eureka](https://dzone.com/articles/netflix-eureka-discovery-microservice)

[Ciruit breaker using Netflix Hystrix](https://dzone.com/articles/microservices-part-4-spring-cloud-circuit-breaker)

[Monitoring using prometheus](https://dzone.com/articles/monitoring-using-spring-boot-2-prometheus-and-graf)

[Blue Green deployment](https://dzone.com/articles/blue-green-deployment-for-cloud-native-application)

[Transactions in microservices1](https://www.baeldung.com/transactions-across-microservices)

[Transactions in microservices2](https://medium.com/@epatro/how-to-implement-a-two-phase-commit-mechanism-in-a-microservice-e99d9a32445e)

[Transactions in microservices3](https://dzone.com/articles/distributed-transactions-with-two-phase-commit-pro)

[Sidecar]

[Chained Microservice]

[Branch Microservice]

[Event Sourcing Pattern]

[Continuous Delivery Patterns]
