package com.javadroider.interviewprep.designpatterns.structural.decorator;

public class Decorator implements House {

	private House house;

	public Decorator(House house) {
		this.house = house;
	}

	@Override
	public String makeHouse() {
		return house.makeHouse();
	}

}
