package com.javadroider.interviewprep.designpatterns.creational.builder;

public class Car {

	private String color;
	private boolean alloyWheels;
	private boolean leatherSeatCovers;

	public Car(CarBuilder carBuilder) {
		this.color = carBuilder.color;
		this.alloyWheels = carBuilder.alloyWheels;
		this.leatherSeatCovers = carBuilder.leatherSeatCovers;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", alloyWheels=" + alloyWheels + ", leatherSeatCovers=" + leatherSeatCovers + "]";
	}

	public static class CarBuilder {
		private String color;
		private boolean alloyWheels;
		private boolean leatherSeatCovers;

		public CarBuilder color(String color) {
			this.color = color;
			return this;
		}

		public CarBuilder alloyWheels(boolean alloyWheels) {
			this.alloyWheels = alloyWheels;
			return this;
		}

		public CarBuilder leatherSeatCovers(boolean leatherSeatCovers) {
			this.leatherSeatCovers = leatherSeatCovers;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}
}
