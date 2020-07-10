
# Interview preparation topics

- Design patterns [One](https://github.com/javadroider/design-patterns-for-humans) | [Two](https://github.com/javadroider/interview-prep/tree/master/src/main/java/com/javadroider/interviewprep/designpatterns)
- [Design principles](https://github.com/javadroider/interview-prep/blob/master/interview/concepts/Design%20Principles.md)
- [Architectural patterns](https://github.com/javadroider/interview-prep/blob/master/interview/concepts/Architectural%20Patterns.md)
- [Micro services](https://github.com/javadroider/interview-prep/blob/master/interview/concepts/Microservices.md)
- [CAP theorem](https://github.com/javadroider/interview-prep/blob/master/interview/concepts/CAP%20Theorem.md)
- Spring
  - [Spring cache](https://howtodoinjava.com/spring-boot2/spring-boot-cache-example/)
  - [Overview of Spring-Boot Dev Tools](https://www.baeldung.com/spring-boot-devtools)
  - [What is the Difference Between JPA and Hibernate?](https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1#)
  - [Spring Singleton scope](https://dzone.com/articles/an-interview-question-on-spring-singletons)
  - How Springboot works
    - [Spring Boot Architecture](https://youtu.be/3eA8AiCV5oE)
    - [All About Spring Boot Starters](https://youtu.be/oSVwNqwkw-M)
    - [How Spring Boot Auto Configuration Works?](https://youtu.be/YdWQFpO9tIA)
    - [How SpringApplication.run() works?](https://youtu.be/VJtviz7U0Y0)
    - [Dependency Management](https://youtu.be/9baKEb_FjuQ)
    - [Custom Failure Analyzer in Spring Boot](https://youtu.be/Vt7zugDNZaU)
- [Bitwise operations](https://github.com/javadroider/interview-prep/tree/master/src/main/java/com/javadroider/interviewprep/ds/bitwise)
- [SQL famous queries](https://github.com/javadroider/interview-prep/blob/master/interview/sql/Queries.md)
- [System Design](https://github.com/javadroider/algorithm-interview/tree/master/grokking_system_design)
- [Design Questions](https://github.com/javadroider/interview-prep/blob/master/interview/questions/System-Design-Interview-Questions.md)
- Java
  - [Java Concurrency Utilities](http://tutorials.jenkov.com/java-util-concurrent/index.html)
  - [Concurrency in Java](http://tutorials.jenkov.com/java-concurrency/index.html)
  - [ConcurrentHashMap](https://www.javapatel.com/2016/09/concurrenthashmap-interview-questions.html)
  - [CompletableFuture](https://www.callicoder.com/java-8-completablefuture-tutorial/)
  - [Features introduced in Java 8, 9, 10, 11, 12](https://github.com/javadroider/interview-prep/tree/master/interview/java)
  - Garbage Collectors - [One](https://dzone.com/articles/choosing-the-right-gc) | [Two](https://dzone.com/articles/java-garbage-collection-3) | [Video](https://www.youtube.com/watch?v=2AZ0KKeXJSo)
    - [UseStringDeduplication: Pros and Cons](https://dzone.com/articles/usestringdeduplication)
  - [How atomic integer works](https://www.javacodemonk.com/what-is-atomicinteger-class-and-how-it-works-internally-1cda6a56)
  - [Separate Chaining](https://www.geeksforgeeks.org/hashing-set-2-separate-chaining/) | [Open Addressing | Linear Probing | Quadratic Probing](https://www.geeksforgeeks.org/hashing-set-3-open-addressing/) | [Cuckoo Hashing](https://www.geeksforgeeks.org/cuckoo-hashing/) | [Double Hashing](https://www.geeksforgeeks.org/double-hashing/)
  - [Generics](https://github.com/javadroider/interview-prep/blob/master/interview/java/Generics.md)
  - [Annotations](https://dzone.com/articles/explore-annotations-in-java-8)
  - [AOT vs JIT compilation in Java](https://www.youtube.com/watch?v=sJVenujWGjs)
  - [Phaser vs CountDownLatch vs CyclicBarrier](https://www.youtube.com/watch?v=J3QZ5gfCtAg)
- [Kafka](https://github.com/javadroider/kafka-tutorial)
  - Connect
  - Stream
- Cassandra
- [Data Structures and Algorithms](https://github.com/javadroider/interview-prep/tree/master/src/main/java/com/javadroider/interviewprep)
    - [Linked Lists](#linked-list-problems)
    - [Trees](#tree-problems)
    - [Stacks](#stack-problems)
    - [Queues](#queue-problems)
    - [Matrix](#matrix-problems)
    - [Dynamic Programming](#dynamic-programming-problems)
    - [Misc](#misc-problems)
    - [Arrays](#array-problems)
    - [Graphs](#graph-problems)
    - [Queue Data Structure Practice Problems and Interview Questions](https://medium.com/@codingfreak/queue-data-structure-practice-problems-and-interview-questions-f459bf0578db)
    - [Behavioural Questions](https://github.com/javadroider/interview-prep/blob/master/interview/questions/Behavioral.md)

# New Concepts
- [JMH](http://tutorials.jenkov.com/java-performance/jmh.html)
- [Brave](https://github.com/openzipkin/brave)
- [Varnish](https://varnish-cache.org/intro/)


Data Structures and Algorithms
==========================

Linked List Problems
--------------
1. Find the middle element of a singly linked list in one pass
2. Reverse a singly linked list with recursion
3. Remove duplicate nodes in an unsorted linked list
4. Find the length of a singly linked list
5. Check if a given linked list contains a cycle? How do you find the starting node of the cycle
6. Reverse a linked list
7. Find the nth node from the end in a singly linked list
8. Merge two sorted linked list
9. Find the sum of two linked lists using Stack 
10. [Find intersection of two Linked Lists - O(m + n) Time Complexity and O(1) Space Complexity](https://www.ideserve.co.in/learn/find-intersection-of-two-linked-lists-constant-space)


Tree Problems
--------------
1. Check if two given binary trees are identical or not | Iterative & Recursive
2. Calculate height of a binary tree | Iterative & Recursive
3. Inorder Tree Traversal | Iterative & Recursive
4. Preorder Tree Traversal | Iterative & Recursive
5. Postorder Tree Traversal | Iterative & Recursive
6. Level Order Traversal of Binary Tree
7. Spiral Order Traversal of Binary Tree
8. Reverse Level Order Traversal of Binary Tree
9. Print Left View of a Binary Tree
10. Print Right View of a Binary Tree
11. Print Bottom View of Binary Tree
12. Print Top View of Binary Tree
13. Find diameter of a binary tree
14. Convert binary tree to its mirror
15. Find Lowest Common Ancestor (LCA) of two nodes in a binary tree
16. Print all paths from root to leaf nodes in given binary tree
17. Find ancestors of given node in a Binary Tree
18. Find Vertical Sum in a given Binary Tree
19. Find the diagonal sum of given binary tree
20. Find node having maximum value in binary tree
21. Find size of a binary tree
22. Find number of leaves in a binary tree
23. Find level that has maximum sum
24. Check existence of path with given sum
25. Find sum of all nodes
26. [Remove vowels from a string stored in a Binary Tree](https://www.geeksforgeeks.org/remove-vowels-from-a-string-stored-in-a-binary-tree/)
27. [Construct binary tree given an array](https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/)
28. [Print all nodes of a given binary tree in specific order](https://www.techiedelight.com/print-nodes-binary-tree-specific-order/)
29. [Find next node in same level for given node in a binary tree](https://www.techiedelight.com/find-next-node-in-same-level-binary-tree/)
30. Determine if given two nodes are cousins of each other
31. [In-place convert given binary tree to its sum tree](https://www.techiedelight.com/inplace-convert-a-tree-sum-tree/)
32. [Check if given binary tree is a sum tree or not](https://www.techiedelight.com/check-given-binary-tree-sum-tree-not/)
32. [Determine if given binary tree is a subtree of another binary tree or not](https://www.techiedelight.com/determine-given-binary-tree-is-subtree-of-another-binary-tree-not/)

### To be done | [source](https://medium.com/@codingfreak/binary-tree-interview-questions-and-practice-problems-439df7e5ea1f)

- Check if given binary tree is complete binary tree or not
- Print cousins of given node in a binary tree
- Check if given binary Tree has symmetric structure or not
- Find the distance between given pairs of nodes in a binary tree
- Print nodes in vertical order of a given Binary Tree (Vertical Traversal)
- Print Diagonal Traversal of Binary Tree
- Print corner nodes of every level in binary tree
- In-place convert convert given Binary Tree to Doubly Linked List
- Sink nodes containing zero to the bottom of the binary tree
- Convert given binary tree to full tree by removing half nodes
- Truncate given binary tree to remove nodes which lie on a path having sum less than K
- Find maximum sum root-to-leaf path in a binary tree
- Determine if given Binary Tree is a BST or not
- Convert a Binary Tree to BST by maintaining its original structure
- Invert given Binary Tree | Recursive and Iterative solution
- Print leaf to root path for every leaf node in a binary tree

Stack Problems
--------------
1. Design a stack which returns minimum element in constant time
2. Check if given expression is balanced expression or not
3. Stock Buy Sell to Maximize Profit
4. [Sort a stack using recursion](https://www.geeksforgeeks.org/sort-a-stack-using-recursion/)
5. [Sort a stack using a temporary stack](https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/)
6. [Reverse a stack using recursion](https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/)

### To be done
- [Design a stack which returns minimum element without using auxiliary stack](https://www.techiedelight.com/design-a-stack-which-returns-minimum-element-without-using-auxiliary-stack/)

Queue Problems
--------------
1. Implement stack using queues
2. Implement Queue using stacks
3. [Given an array and integer k, write an algorithm to find the maximum element in each subarray of size k](https://algorithms.tutorialhorizon.com/sliding-window-algorithm-track-the-maximum-of-each-subarray-of-size-k/)
4. [Sort a stack using a temporary stack](https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/)

Matrix Problems
--------------
1. Print matrix diagonally

Dynamic Programming Problems
--------------
1. Edit Distance
2. Subset Sum Problem
3. 0-1 Knapsack Problem
4. Rod Cutting
5. Coin change problem
6. Count the number of islands
7. Weighted Job Scheduling
8. Count and print all Subarrays with product less than K in O(n)
9. [Find maximum meetings in one room](https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/)

### To be done | [source](https://www.geeksforgeeks.org/top-20-dynamic-programming-interview-questions/)

Array Problems
--------------
1. Longest Increasing Subsequence 
2. Largest Sum Contiguous Subarray
3. Find the Missing Number in the array
4. Print all subsets of an array
5. Sort an array of 0s, 1s and 2s

Misc Problems
--------------
1. [Determine the given routing number belong to which bank](https://algorithms.tutorialhorizon.com/determine-the-given-routing-number-belong-to-which-bank/)
2. [Convert Integer to Roman](https://algorithms.tutorialhorizon.com/convert-integer-to-roman/)
3. [Top 10 occurring words in a very large file java algorithm](https://www.javacodemonk.com/top-10-occurring-words-in-a-very-large-file-java-algorithm-f42e0e67)
4. [Build a Sudoku Solver in Java](https://medium.com/javarevisited/build-a-sudoku-solver-in-java-part-1-c308bd511481)
5. [Find Itinerary from a given list of tickets](https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/)
6. [Minimum Number of Platforms Required for a Railway/Bus Station](https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/)
7. [Find the first circular tour that visits all petrol pumps](https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/)


