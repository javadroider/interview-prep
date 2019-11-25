
- **Why Lambda Expression in java is called as lambda?**
- **What is closure**
 - **What are the important features of Java 8 release?**
    - Interface changes with default and static methods
   - Functional interfaces and Lambda Expressions
   - Java Stream API for collection classes
   - Java Date Time API
- **What do you mean by platform independence of Java?**
   Platform independence means that you can run the same Java Program in any Operating System. For example, you can write java program in Windows and run it in Mac OS.
- **Why Java is not pure Object Oriented language?**
   Java is not said to be pure object oriented because it support primitive types such as int, byte, short, long etc.
- **What is the importance of main method in Java?**
   - main() method is the entry point of any standalone java application.
   - The syntax of main method is public static void main(String args[]).
   - main method is public and static so that java can access it without initializing the class.
   - The input parameter is an array of String through which we can pass runtime arguments to the java program.
- **What is final keyword?**
   - final keyword is used with Class to make sure no other class can extend it, for example String class is final and we can't extend it.
   - We can use final keyword with methods to make sure child classes can't override it.
   - final keyword can be used with variables to make sure that it can be assigned only once. However the state of the variable can be changed, for example we can assign a final variable to an object only once but the object variables can change later on.
 - **What is try-with-resources in java?**
   One of the Java 7 features is try-with-resources statement for automatic resource management.

    >        try (BufferedReader br = new BufferedReader(new FileReader("D:/test.txt"))) {
    >          System.out.println(br.readLine());
    >       } catch (IOException e) {
    >          e.printStackTrace();
    >       }

- **What is Marker interface?**
   A marker interface is an empty interface without any method but used to force some functionality in implementing classes by Java. Some of the well known marker interfaces are Serializable and Cloneable.
- **What are Wrapper classes?**
   Java wrapper classes are the Object representation of eight primitive types in java. All the wrapper classes in java are immutable and final. Java 5 autoboxing and unboxing allows easy conversion between primitive types and their corresponding wrapper classes
- **What is the benefit of Composition over Inheritance?**
   - Any change in the superclass might affect subclass even though we might not be using the superclass methods. For example, if we have a method test() in subclass and suddenly somebody introduces a method test() in superclass, we will get compilation errors in subclass. Composition will never face this issue because we are using only what methods we need.
   - Inheritance exposes all the super class methods and variables to client and if we have no control in designing superclass, it can lead to security holes. Composition allows us to provide restricted access to the methods and hence more secure.
   - We can get runtime binding in composition where inheritance binds the classes at compile time. So composition provides flexibility in invocation of methods.
   - Unit testing is easy in composition because we know what all methods we are using from superclass and we can mock it up for testing whereas in inheritance we depend heavily on superclass and don't know what all methods of superclass will be used, so we need to test all the methods of superclass, that is an extra work and we need to do it unnecessarily because of inheritance
- **How to sort a collection of custom Objects in Java?**
   - We need to implement Comparable interface to support sorting of custom objects in a collection. Comparable interface has compareTo(T obj) method which is used by sorting methods and by providing this method implementation, we can provide default way to sort custom objects collection.
   - However, if you want to sort based on different criteria, such as sorting an Employees collection based on salary or age, then we can create Comparator instances and pass it as sorting methodology
- **What are different types of classloaders?**
   There are three types of built-in Class Loaders in Java:
      - **Bootstrap Class Loader** loads JDK internal classes, typically loads rt.jar and other core classes.
      - **Extensions Class Loader** loads classes from the JDK extensions directory, usually $JAVA_HOME/lib/ext directory.
      - **System Class Loader** loads classes from the current classpath that can be set while invoking a program using -cp or -classpath command line options.
- **What is Garbage Collection?**
- **What is difference between Heap and Stack Memory?**
   - Heap memory is used by all the parts of the application whereas stack memory is used only by one thread of execution.
   - Whenever an object is created, it's always stored in the Heap space and stack memory contains the reference to it. Stack memory only contains local primitive variables and reference variables to objects in heap space.
   - Memory management in stack is done in LIFO manner whereas it's more complex in Heap memory because it's used globally.
- What Are The Different Types Of Memory Used By Jvm ?
- What Are Various Types Of Class Loaders Used By Jvm
- What Is Metaspace ?
- What Is Permgen Or Permanent Generation ?
- What Is Database Deadlock ? How Can We Avoid Them?
- Difference Between First Level And Second Level Cache In Hibernate ?
- What Are New Features Introduced With Java 8 ?
- What Is A Transient Variable?
- Write code to implement a LRU cache with eviction