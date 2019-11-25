- It is used to handle complex communications between related objects, helping with decoupling of those objects.
- It is used to provide a centralized communication medium between different objects in a system. 
- It is very helpful in an enterprise application where multiple objects are interacting with each other. If the objects interact with each other directly, the system components are tightly-coupled with each other that makes maintainability cost higher and not flexible to extend easily. 
- It focuses on providing a mediator between objects for communication and help in implementing lose-coupling between objects.

**Real life example**
An airport control tower is an excellent example of the mediator pattern. The tower looks after who can take off and land - all communications are done from the airplane to control tower, rather than having plane-to-plane communication. This idea of a central controller is one of the key aspects to the mediator pattern.

**Project Example**
Cloud which communicates with Sensors to do automation.
