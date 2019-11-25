/**
 * 
 */
package com.javadroider.interviewprep.designpatterns.creational.prototype;

/**
 *
 */
public class Quotation implements Cloneable {

	private String name;
	private int value;

	@Override
	public Object clone() {
		try {
			return (Quotation) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
