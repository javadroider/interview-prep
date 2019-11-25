https://www.geeksforgeeks.org/java-11-features-and-comparison/
https://dzone.com/articles/features-of-java-11


## 1. New String Methods



 - **strip() , stripLeading() , stripTrailing()**
The strip() method is used to remove the leading and trailing whitespace. It is helpful to remove the white space from the beginning and end of a string. stripLeading()method is used to remove the white space from the beginning of a string. stripTrailing()method is used to remove the white space from the end of a string.

- **isBlank()**
This method returns true if the string is empty or contains only white spaces; otherwise, it returns false.

- **lines()**
This method is used to return the stream of strings that are partitioned by line terminators. The lines in the stream are in the order in which they occur in the string. This method is more performant compared to the methods we are using currently.

>     String str = "Hello\nNew\nWorld";
>     System.out.println(str.lines().collect(Collectors.toList()));


- **repeat(n)**
This method will return the concatenated string, and the number of times it will concatenate is dependant upon the count that we supply as an argument to this method.


>     String str = "Hello";
>     System.out.println(str.repeat(4));


## 2. New File Methods

- **writeString()**
	This is to write some content in a file.
    > `jshell>Files.writeString(Path.of(example.txt), "GeeksForGeeks!") `;

- **readString()**
	This is used to read the contents of a file.

    >      jshell>Files.readString(Path.of(example.txt));
    >     Output: "GeeksForGeeks!"

- **isSameFile()**
	This method is used to know whether two paths locate the same file or not.

    >     jshell>Files.isSameFile(Path.of("example1.txt"), Path.of("example1.txt"));
    >     Output: true
	>     jshell>Files.isSameFile(Path.of("example2.txt"), Path.of("example1.txt"));
    >     Output: false

## 3. Epsilon Garbage Collector
This handles memory allocation but does not have actual memory reclamation mechanism. Once the available Java heap is exhausted, JVM will shut down.
Its goals are
- Performance testing
- Memory pressure testing
- Last drop latency improvements

## 4. Removal of thread functions
 stop(Throwable obj) and destroy() objects have been removed from the JDK 11 because they only throw UnSupportedOperation and NoSuchMethodError respectively. Other than that, they were of no use.

## 5. TimeUnit Conversion
This method is used to convert the given time to a unit like DAY, MONTH, YEAR and for time too.

>     jshell>TimeUnit c = TimeUnit.DAYS;
>     Output: DAYS
>     jshell>c.convert(Duration.ofHours(24));
>     Output: 1
>     jshell>c.convert(Duration.ofHours(50));
>     Output: 2


## 6. Optional.isEmpty()
 This method returns true if the value of any object is null and else returns false.

>      jshell>Optional str = Optional.empty();
>      jshell>str.isEmpty();
>      Output: true
>      jshell>Optional str = Optional.of("TonyStark");
>      jshell>str.isEmpty();
>      Output: false
