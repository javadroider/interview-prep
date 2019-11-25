package com.javadroider.interviewprep.oops.coupling.problem;

public class CouplingExampleProblem {

	//Here traveller object is tightly coupled with car object.
	//If traveller wants to change from car to plane then the whole traveller class has to be changed
	class Traveller {
		Car c = new Car();

		public void startJourney() {
			c.move();
		}
	}

	class Car {
		public void move() {
			// ...
		}
	}
}
