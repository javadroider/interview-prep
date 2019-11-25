package com.javadroider.interviewprep.designpatterns.creational.builder;

public class Client {

	public static void main(String[] args) {
		Car car = new Car.CarBuilder().color("Red").alloyWheels(true).leatherSeatCovers(true).build();
		System.out.println(car);
	}
}
