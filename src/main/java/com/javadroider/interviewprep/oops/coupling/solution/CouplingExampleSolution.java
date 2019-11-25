package com.javadroider.interviewprep.oops.coupling.solution;

public class CouplingExampleSolution {

	class Traveller {

		Vehicle c = null;

		public void setVehicle(Vehicle vehicle){
			this.c = vehicle;
		}

		public void startJourney() {
			c.move();
		}
	}

	class Car implements Vehicle {
		public void move() {
			// ...
		}
	}

	abstract interface Vehicle {
		abstract public void move();
	}
}
