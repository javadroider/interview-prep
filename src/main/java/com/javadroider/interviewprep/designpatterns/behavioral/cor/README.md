- Chain of responsibility helps to decouple sender of a request and receiver of the request with some trade-offs. 
- Chain of responsibility is a design pattern where a sender sends a request to a chain of objects, where the objects in the chain decide themselves who to honor the request. If an object in the chain decides not to serve the request, it forwards the request to the next object in the chain.
- Responsibility is outsourced. In a chain of objects, the responsibility of deciding who to serve the request is left to the objects participating in the chains. It is similar to passing the question in a quiz scenario. When the quiz master asks a question to a person, if he doesn't know the answer, he passes the question to next person and so on. When one person answers the question, the passing flow stops. Sometimes, the passing might reach the last person and still nobody gives the answer.

**Highlights of Chain of Responsibility**

- Sender will not know which object in the chain will serve its request.
- Every node in chain will have the responsibility to decide, if they can serve the request.
- If node decides to forward the request, it should be capable of choosing the next node and forward it.
- There is a possibility where none of the node may serve the request.

**Real Life Example**
- Bank loan approval process. Bank loan goes through multiple approvals. If amount is less then cashier might approve it. If it is more then he will assign the request to manager. If the manager can not approve then he may assign the request to zonal manager for approval. The person who has requested for loan is not aware of so many processes happening in the background.

**Project Example**
- HTTP Filters
