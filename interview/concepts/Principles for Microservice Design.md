https://www.infoq.com/articles/microservices-design-ideals/

- For object-oriented design we follow the SOLID principles. For microservice design we propose developers follow the “IDEALS”: interface segregation, deployability (is on you), event-driven, availability over consistency, loose-coupling, and single responsibility.
- Interface segregation tells us that different types of clients (e.g., mobile apps, web apps, CLI programs) should be able to interact with services through the contract that best suits their needs. 
- Deployability (is on you) acknowledges that in the microservice era, which is also the DevOps era, there are critical design decisions and technology choices developers need to make regarding packaging, deploying and running microservices. 
- Event-driven suggests that whenever possible we should model our services to be activated by an asynchronous message or event instead of a synchronous call. 
- Availability over consistency reminds us that more often end users value the availability of the system over strong data consistency, and they’re okay with eventual consistency. 
- Loose-coupling remains an important design concern in the case of microservices, with respect to afferent (incoming) and efferent (outgoing) coupling. 
- Single responsibility is the idea that enables modeling microservices that are not too large or too slim because they contain the right amount of cohesive functionality.
