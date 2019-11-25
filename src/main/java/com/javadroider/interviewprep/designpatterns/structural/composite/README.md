Composite pattern is one of the Structural design pattern and is used when we have to represent a part-whole hierarchy. When we need to create a structure in a way that the objects in the structure has to be treated the same way, we can apply composite design pattern.

The Composite pattern is used when we need a way to treat a whole group of objects in a similar, or the same manner.

This is usually done by the class that "owns" the group of objects and provides a set of methods to treat them equally as if they were a single object.

**Implementation**

Let's start off with the Employee class. This class will be instantiated multiple times to form a group of employees:

The class has a list of Employee within it, this is our group of objects that we want to target as a single object.

Here, several employees are instantiated. The CEO has a few employees as close coworkers, and some of them have their own close coworkers, in lower positions.

In the end, the head employees are close coworkers of the CEO, and the regular employees are coworkers of the head employees.

Running the code above will yield:

> Employee : | Name: Scott, Position: CEO, Wage: 3000 |

> Employee : | Name: Andrew, Position: Manager, Wage: 2000 |

> Employee : | Name: David, Position: Programmer, Wage: 1500 |

> Employee : | Name: Chris, Position: Programmer, Wage: 1750 |

> Employee : | Name: Ivan, Position: Programmer, Wage: 1200 |

> Employee : | Name: Juliette, Position: Marketing, Wage: 1000 |

> Employee : | Name: Rebecca, Position: Sales, Wage: 2000 |
