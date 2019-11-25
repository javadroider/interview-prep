package com.javadroider.interviewprep.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registrar {

	List<Observer> observers = new ArrayList<>();

	public void register(Observer observer) {

	}

	public void unregister(Observer observer) {

	}

	public void notifyObservers() {

		Map<String, String> map = new HashMap<>();
		for (Observer observer : observers) {
			observer.stateChange(map);
		}
	}

}
