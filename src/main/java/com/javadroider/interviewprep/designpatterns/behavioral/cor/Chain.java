package com.javadroider.interviewprep.designpatterns.behavioral.cor;

public interface Chain {

	void setNextChain(Chain nextChain);

	void dispense(Currency cur);
}