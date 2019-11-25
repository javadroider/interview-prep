package com.javadroider.interviewprep.designpatterns.structural.adapter;

class Rectangle {
	public void draw(int x, int y, int width, int height) {
		System.out.println("Rectangle with coordinate left-down point (" + x + ";" + y + "), width: " + width + ", height: " + height);
	}
}