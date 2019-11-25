

In complex cases the logic of one class will call the logic of another class just to provide the same service
If this happen there is the so called tight-coupling between the two classes.
In this case the first class that wants to call the logic from the second class will have to create an object from the second class

Example: we have two classes first is traveller and the second is a car. Traveller class is calling logic of car class; in this case traveller class creates an object of car class.

This will mean the car class will depend on the traveller object.