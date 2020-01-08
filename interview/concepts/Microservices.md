
## Tracing in micro-services
### Using Spring Cloud Sleuth 

- Uses [Brave](https://github.com/openzipkin/brave) as the tracing library that adds unique ids to each web request that enters our application
- Adds two types of IDs to log. trace ID & span ID. traceId contains set of spanIDs
- Enabled by adding following dependency in pom.xml
```
	 <dependency
    		<groupIdorg.springframework.cloud</groupId
    		<artifactIdspring-cloud-starter-sleuth</artifactId
	 </dependency>
```
- Example log looks like this
 ```	
	2016-06-15 16:55:56.334 INFO [slueth-sample,44462edc42f2ae73,44462edc42f2ae73,false] 13978 --- [nio-8080-exec-1] com.example.SleuthSampleApplication : calling home
```	
		- The first part is the application name (whatever you set spring.application.name to in bootstrap.yml). 
		- The second value is the trace id. 
		- The third value is the span id. Finally the last value indicates whether the span should be exported to Zipkin
		- It will add following headers in the request
    		 	X-B3-SpanId: fbf39ca6e571f294 X-B3-TraceId: fbf39ca6e571f294
	
- We can create new spans using Tracer 
```
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
```
- Using LazyTraceExecutor we can propagate traceIds to new threads

### Links
[One](https://dzone.com/articles/tracing-in-microservices-with-spring-cloud-sleuth) | [Two](https://www.baeldung.com/spring-cloud-sleuth-single-application)

### Support Zipkin
	- Add following dependency
	 	<dependency 
	  		<groupIdorg.springframework.cloud</groupId 
	  		<artifactIdspring-cloud-sleuth-zipkin</artifactId 
		</dependency>
	- Add spring.zipkin.baseUrl to specify zipkin url

## Service discovery using netflix eureka
### Netflix Eureka
	- Provides a mechanism to keep a registry of microservices. Provides a identifier to service instead of ip & port.
    - It consists of the Eureka Server and Eureka clients.
### Eureka Discovery Server
	- Add following dependency
    	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
    - Add following entries in application.properties
    	eureka.instance.hostname=localhost
		eureka.client.register-with-eureka=false
		eureka.client.fetch-registry=false
    - Add @EnableEurekaServer to main() method class
### Eureka Client
 	- Add dependency
    	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
	- Add entries in application.properties to enable talking with server
    	eureka.client.serviceUrl.defaultZone=http://localhost:8000/eureka/
		eureka.client.register-with-eureka=true
    - Declare @LoadBalanced @Autowired private RestTemplate restTemplate;
	- Using following code you can access other micro services  
    	    Course course = restTemplate.getForObject("http://course-service/courses/details/" + student.getCourseId(), Course.class);
            
### Links
 [Example Repository](https://github.com/codepeekers/service-discovery-using-eureka)| [Reference](https://dzone.com/articles/netflix-eureka-discovery-microservice)

## Spring Cloud Circuit Breaker Using Netflix Hystrix

### Netflix Hystrix
	- Add dependency
    	<dependency>
    		<groupId>org.springframework.cloud</groupId>
    		<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
		</dependency>
    - Add @EnableCircuitBreaker annotation to entry point class
    - Use @HystrixCommand annotation on any method to apply timeout and fallback method.

### Links
[Presentation](https://docs.google.com/presentation/d/1hLitnkkutf-aL3DAnYCsmUwattoSe_ZBlSzVUEXfNw8/edit?usp=sharing) | [Code](https://github.com/codepeekers/circuit-breaker-pattern-using-hystrix) | [Reference1](https://dzone.com/articles/microservices-part-4-spring-cloud-circuit-breaker) | [Reference2](https://martinfowler.com/bliki/CircuitBreaker.html)

## Microservices monitoring

### Micrometer
	- [Micrometer](https://micrometer.io/) is an application metrics eport engine
    - Supports numerous monitoring systems such as Atlas, Datadog, Prometheus etc
    - When you add Spring Boot Actuator and micrometer as your dependencies, it auto-configures a composite MeterRegistry 
    - Having a dependency on micrometer-registry-{system} in your runtime classpath is enough for Spring Boot to configure the registry.
    - Add dependencies
    	<!-- Spring boot actuator to expose metrics endpoint -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!-- Micormeter core dependecy  -->
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-core</artifactId>
        </dependency>
        <!-- Micrometer Prometheus registry  -->
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
        </dependency>
    - Enable the actuator and Prometheus endpoints 
    	#Metrics related configurations
        management.endpoint.metrics.enabled=true
        management.endpoints.web.exposure.include=*
        management.endpoint.prometheus.enabled=true
        management.metrics.export.prometheus.enabled=true
	- The link http://localhost:9000/actuator should give actuator endpoints
    - The link http://localhost:9000/actuator/prometheus gives metrics which will get exposed to prometheus

### Prometheus 
	- Configure yml file in prometheus to contact http://localhost:9000/actuator/prometheus to get the metrics
    - Access prometheus using http://localhost:9090 once you start it
    
### Links
[Reference](https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/)

	
## Design Pattersn for microservices
### Links
[Reference](https://dzone.com/articles/design-patterns-for-microservices)

## Blue Green deployment
### Links
[Reference](https://dzone.com/articles/blue-green-deployment-for-cloud-native-application)

## Transactions in microservices

### Links
[Link4](https://developers.redhat.com/blog/2018/10/01/patterns-for-distributed-transactions-within-a-microservices-architecture/)
