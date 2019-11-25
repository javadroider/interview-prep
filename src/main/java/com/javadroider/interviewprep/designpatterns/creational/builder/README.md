This pattern was introduced to solve some of the problems with Factory and Abstract Factory design patterns when the Object contains a lot of attributes. 

Builder pattern solves the issue with large number of optional parameters and inconsistent state by providing a way to build the object step-by-step and provide a method that will actually return the final Object.

Real life Example - Multi course menu. Meal can be prepared using starter,main course,deserts. Meal can be prepared by selecting whatever is needed using MealBuilder class.  
