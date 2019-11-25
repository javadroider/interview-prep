package com.javadroider.interviewprep.designpatterns.structural.decorator;

public class ColorDecorator extends Decorator {

	public ColorDecorator(House house) {
		super(house);
	}

	private String colorHouse() {
		return "Color";
	}

	@Override
	public String makeHouse() {
		return super.makeHouse() + " " + colorHouse();
	}
}
