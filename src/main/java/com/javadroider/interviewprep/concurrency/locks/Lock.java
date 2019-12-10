package com.javadroider.interviewprep.concurrency.locks;

/**
 * Lock interface to extend different implementations
 * 
 */
public interface Lock {
	void lock();
	void unlock();
}
