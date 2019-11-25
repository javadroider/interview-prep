package com.javadroider.interviewprep.designpatterns.structural.decorator;

public class LightDecorator extends Decorator {

	public LightDecorator(House house) {
		super(house);
	}

	public String lightHouse() {
		return "Light";
	}

	@Override
	public String makeHouse() {
		return super.makeHouse() + " " + lightHouse();
	}
}
