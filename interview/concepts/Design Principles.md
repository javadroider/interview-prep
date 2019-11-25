## S.O.L.I.D Design Priniciples ##
  
### 1. Single Responsibility Principle ###  
- A class or module should do one thing only. 
- A class or module should have only one reason to change.  
  
### 2. Open/Closed Principle ###  
- Code entities should be open for extension, but closed for modification.  
- It's closed for modification, but it can be extended by, for instance, inheriting from it and overriding or extending certain behaviors.  
- The design and writing of the code should be done in a way that new functionality should be added with minimum changes in the existing code. The design should be done in a way to allow the adding of new functionality as new classes, keeping as much as possible existing code unchanged.  
- https://www.oodesign.com/open-close-principle.html  
  
  
### 3. Liskov Substitution Principle ###  
- Any child type of a parent type should be able to stand in for that parent without things blowing up.  
- We must make sure that new derived classes are extending the base classes without changing their behavior.  
- For example, if you have a class, Animal, with a makeNoise() method, then any subclass of Animal should reasonably implement makeNoise(). Cats should meow, dogs should bark, etc. What you wouldn't do is define a MuteMouse class that throws IDontActuallyMakeNoiseException. This violates the LSP, and the argument would be that this class has no business inheriting from Animal. 
- We must make sure that the new derived classes just extend without replacing the functionality of old classes. Otherwise the new classes can produce undesired effects when they are used in existing program modules.
- If a program module is using a Base class, then the reference to the Base class can be replaced with a Derived class without affecting the functionality of the program module.
- https://www.oodesign.com/liskov-s-substitution-principle.html  
  
  
### 4. Interface Segregation Principle ###  
- Clients should not be forced to implement interfaces they don't use. Instead of one fat interface many small interfaces are preferred based on groups of methods, each one serving one submodule.  
- You should favor many, smaller, client-specific interfaces over one larger, more monolithic interface. In short, you don't want to force clients to depend on things they don't actually need. Imagine your code consuming some big, fat interface and having to re-compile/deploy with annoying frequency because some method you don't even care about got a new signature.  
- To picture this in the real world, think of going down to your local corner restaurant and checking out the menu. You'll see all of the normal menu mainstays, and then something that's just called "soup of the day." Why do they do this? Because the soup changes a lot and there's no sense reprinting the menus every day. Clients that don't care about the soup needn't even be concerned, and clients that do use a different interface -- asking the server.  
- https://www.oodesign.com/interface-segregation-principle.html  
- https://dzone.com/articles/solid-principles-by-example-interface-segregation
  
### 5. Dependency Inversion ###  
- Encourages you to write code that depends upon abstractions rather than upon concrete details.   
- You can recognize this in the code you read by looking for a class or method that takes something generic like "Stream" and performs operations on it, as opposed to instantiating a specific Filestream or Stringstream or whatever.   
- This gives the code in question a lot more flexibility -- you can swap in anything that conforms to the Stream abstraction and it will still work.
