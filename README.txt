The circuit breaker feature of Resilience4j is verified with this Proof of Concept.

Software and their versions used in resilience4jDemo and restfulService:
	java : 1.8
	springboot : 2.6.2
	spring-boot-starter-actuator: 2.6.2
	spring-cloud-starter-circuitbreaker-resilien0ce4j:1.0.
	spring-cloud-starter-netflix-eureka-client:3.1.0
	
Software and their versions used in EurekaServiceRegistry:
	java : 1.8
	springboot : 2.5.1
	spring-cloud-starter-netflix-eureka-server:latest
	
	
1. Use project EurekaServiceRegistry as the registry for the resilience4j demo. 
   This means, EurekaServiceRegistry has to be started first.
2. Start restfulService
3. Start resilience4jDemo

End points to check after starting the servers:
	http//localhost:8761/
	http://localhost:8081/greet/user?username=RameshBontha1
	http://localhost:8082/circuitbreak/test?username=RameshBontha1
	
To see the health of the resilience4jDemo application:
	http//localhost:8082/actuator/health
	