/**
 * 
 */
package com.javadroider.interviewprep.designpatterns.creational.prototype;

public enum QuotationFactory {

	INSTANCE;

	private static Quotation bikeQuotation;
	private static Quotation carQuotation;

	static {
		bikeQuotation = new BikeQuotation();
		bikeQuotation.setName("Yamaha");
		bikeQuotation.setValue(100);
		((BikeQuotation) bikeQuotation).setNumber(1000);

		carQuotation = new CarQuotation();
		carQuotation.setName("Hyundai");
		carQuotation.setValue(101);
		((CarQuotation) carQuotation).setNumber(1001);
	}

	public static Quotation getQuote(int type) {
		if (type == 1) {
			return (Quotation) bikeQuotation.clone();
		} else {
			return (Quotation) carQuotation.clone();
		}
	}
}
