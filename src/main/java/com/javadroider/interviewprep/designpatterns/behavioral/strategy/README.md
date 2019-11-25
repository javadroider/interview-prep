- It is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.
- It is also known as Policy Pattern. We define multiple algorithms and let client application pass the algorithm to be used as a parameter. 
- One of the best example of this pattern is Collections.sort() method that takes Comparator parameter. Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways.

**Project Example**
- Processing of sensor binary
- NFSStrategy, CDNStrategy
