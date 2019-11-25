https://www.geeksforgeeks.org/java-9-features-with-examples/

## 1. Factory methods for collections(like List, Map, Set and Map.Entry)

Many a times, you want to create a collection (e.g., a List or Set) in your Java program and fill it with some elements. That leads to repetitive coding where you instantiate the collection, followed by several ‘add’ calls. With Java 9, several so-called collection factory methods have been added.
List and Set interfaces have “of()” methods to create an empty or no-empty Immutable List or Set objects as shown below:

> `List immutableList = List.of("one", "two", "three");`

## 2. JShell: the interactive Java REPL

Oracle Corp. has introduced a new tool called “jshell”. It stands for Java Shell and also known as REPL (Read Evaluate Print Loop). Many languages already feature an interactive Read-Eval-Print-Loop, and Java now joins this club. It is used to execute and test any Java Constructs like class, interface, enum, object, statements etc. very easily. You can launch jshell from the console and directly start typing and executing Java code. The immediate feedback of jshell makes it a great tool to explore APIs and try out language features.

## 3. Stream API Improvements

In Java SE 9, Oracle Corp. has added four useful new methods to java.util.Stream interface. As Stream is an interface, all those new implemented methods are default methods. It allows you to create declarative pipelines of transformations on collections. There are four new methods added to the Stream interface: dropWhile, takeWhile, ofNullable. The iterate method gets a new overload, allowing you to provide a Predicate on when to stop iterating.

## 4. Private methods in Interfaces

In Java 8, we can provide method implementation in Interfaces using Default and Static methods. However we cannot create private methods in Interfaces. To avoid redundant code and more re-usability, Oracle Corp. introduced private methods in Java SE 9 Interfaces. From Java SE 9 on-wards, we can write private and private static methods too in an interface using ‘private’ keyword.


## 5. The Java(9) Platform module system

One of the big changes or java 9 feature is the Module System. Oracle Corp. introduced the following features as part of Jigsaw Project:
- Modular JDK
- Modular Java Source Code
- Modular Run-time Images
- Encapsulate Java Internal APIs
- Java Platform Module System

Before Java SE 9 versions, we are using Monolithic Jars to develop Java-Based applications. This architecture has lot of limitations and drawbacks. To avoid all these shortcomings, Java SE 9 comes with the Module System.

## 6. HTTP/2 Client

A new way of performing HTTP calls arrives with Java 9. As existing or Legacy HTTP Client API has numerous issues (like supports HTTP/1.1 protocol and does not support HTTP/2 protocol and WebSocket, works only in Blocking mode and lot of performance issues.), they are replacing this HttpURLConnection API with new HTTP client. They are going to introduce new HTTP 2 Client API under “java.net.http” package. It supports both HTTP/1.1 and HTTP/2 protocols. It supports both Synchronous (Blocking Mode) and Asynchronous Modes. It supports Asynchronous Mode using WebSocket API.

>     HttpClient client = HttpClient.newHttpClient();
>     HttpRequest req =  HttpRequest.newBuilder(URI.create("http://www.google.com"))
>     						.header("User-Agent", "Java")
>     		                .GET()
>     	                    .build();
>     HttpResponse resp = client.send(req, HttpResponse.BodyHandler.asString());

