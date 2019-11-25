Prototype pattern is used when the Object creation is a costly affair and requires a lot of time and resources and you have a similar object already existing. So this pattern provides a mechanism to copy the original object to a new object and then modify it according to our needs. This pattern uses java cloning to copy the object.

Prototype design pattern mandates that the Object which you are copying should provide the copying feature. It should not be done by any other class. However whether to use shallow or deep copy of the Object properties depends on the requirements and its a design decision.

Real life example : 
Chess game. There is lot of logic which goes to initialize chess board. Instead of re-executing this logic every time chess is started,it can be prototyped. Whenever someone asks for chess game existing object can be cloned and given. 
