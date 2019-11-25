## 1. Local Variable Type Inference
Java has now var style declarations. It allows you to declare a local variable without specifying its type. The type of variable will be inferred from type of actual object created. It claims to be the only real feature for developers in JDK 10. e.g.
var str = "Hello world";
//or
String str = "Hello world";

## 2. APIs for Creating Unmodifiable Collections
List.copyOf, Set.copyOf, and Map.copyOf methods are added to create the instance from an existing instance.

## 3. Removal of javah
The native header tool is now removed and we can generate the native header using the Java compiler with the -h option