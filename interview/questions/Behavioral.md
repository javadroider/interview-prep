[tech-interview-handbook/behavioral-questions](https://yangshun.github.io/tech-interview-handbook/behavioral-questions)


## Behavioural Questions
 - Tell me a time when you had a conflict in the team.
 - Tell me a time when you did something that had a big impact.
 - Tell me a time when you had to take responsability of someone else mistake  
 - What sources do you read? Tell me two books you recently read?  
 - Tell me about most challenging project worked on?
 - Tell me what was the biggest bug you shipped and what it meant for the user and the company. What were the learning you took away from the situation?  
 - Tell about a time you had to deal with a conflict in your team  
 - Describe an interesting/difficult problem you worked on  

## SAR (Situation-Action-Result) technique examples

### Example 1: Tuning performance
**Situation**: Performance problem where the application server had to be restarted every second day.

**Action**:
- Used JMeter to simulate the load conditions.
- Identified the cause of the problem to be leaking database connections due to not properly closing the connections under an exceptional scenario.
- Used the profiling tool “VisualVM” & identified a memory leak where long living objects were holding on to short lived objects. jvisualvm to detect memory leak.
- Fixed the database connection leaks by closing the connections in a finally block.
- Fixed the code to release memory consumed by the short lived objects.
- Tuned the JVM & GC settings. 
- Load and endurance tested the fixed code with the load testing tool JMeter to confirm that the issue has been fixed.


### Example 2: Code quality

**Situation**: Java code that is hard to maintain and reuse. Changes to one module may break another module.

**Action**:
- Wrote unit tests with proper Mockito mock objects for the existing un-maintainable code.
- Introduced SonarQube to ascertain code coverage & code quality metrics. Fixed the blocker, critical, and major severity items.
- Re-factored the code with OO concepts and design patterns in a test driven manner to improve maintainability.
- Large procedural style if/else statements were replaced with objects adhering to the Open-Closed design principle.
- Code duplication was eliminated with the help of SonarQube tool & refactoring.
- Reran the unit tests to ensure that the functionality is not broken due to refactoring.

**Result**: The application became much easier to maintain, extend, and reuse. The test coverage was increased from 27% to 76%.

### Example 3: Concurrency Management
**Situation**: The production ready application consumed very less CPU and response times were very poor due to heavy I/O operations like database read/write operations.

**Action**:
- Monitored the CPU usage with Visual VM tool.
- Got a series of thread dumps, say 7 to 10 at a particular interval, say 5 to 8 seconds and analysed those thread dumps by importing the thread dumps into “Samurai”, which is a visual tool.
- Paid attention to the blocked threads in red. Alternatively, VisualVM is handy for debugging deadlocks & analyzing thread dumps.
- Fixed the concurrency issue by reducing the synchronization granularity in the code.
- The offending SQL statement was identified with a SQL query planner and tuned.

**Result**: The response times were halved and the average CPU usage increased from 45% to 98%.
