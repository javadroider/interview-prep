package com.javadroider.interviewprep.designpatterns.behavioral.visitor;

public class ItemVisitor {

	public int visit(Book book) {
		if (book.getPrice() > 10) {
			return book.getPrice() - 1;
		}
		return book.getPrice();
	}

	public int visit(Pen pen) {
		return pen.getPrice();
	}

}
