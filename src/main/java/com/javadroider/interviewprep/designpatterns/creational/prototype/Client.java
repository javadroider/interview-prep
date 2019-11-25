/**
 * 
 */
package com.javadroider.interviewprep.designpatterns.creational.prototype;

public class Client {
	public static void main(String args[]) {

		BikeQuotation bikeQuotation = (BikeQuotation) QuotationFactory.getQuote(1);
		CarQuotation carQuotation = (CarQuotation) QuotationFactory.getQuote(2);
		
		System.out.println(bikeQuotation);
		System.out.println(carQuotation);
		System.out.println( (BikeQuotation) QuotationFactory.getQuote(1));
		System.out.println( (CarQuotation) QuotationFactory.getQuote(2));
	}
}
