package com.javadroider.interviewprep.designpatterns.behavioral.visitor;

public interface Item {

	public int accept(ItemVisitor visitor);
}
