# Generics | [one](https://www.baeldung.com/java-generics) | [two](https://docs.oracle.com/javase/tutorial/java/generics/why.html)

### Table of contents
- [Why Use Generics?](#why-use-generics)

## Why Use Generics
- Stronger type checks at compile time.
> A Java compiler applies strong type checking to generic code and issues errors if the code violates type safety. Fixing compile-time errors is easier than fixing runtime errors, which can be difficult to find.
- Elimination of casts.
>The following code snippet without generics requires casting:
```
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);
```
  When re-written to use generics, the code does not require casting:
```
List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0);   // no cast
```
- Enabling programmers to implement generic algorithms.
> By using generics, programmers can implement generic algorithms that work on collections of different types, can be customized, and are type safe and easier to read.
