package com.javadroider.interviewprep.concurrency.locks;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Its an extended version of {@link SimpleLock}. The implementation make 
 * sure that a thread will get a lock any number of times it asks if it 
 * holds the lock on the particular object. Hence the name reentrant. This 
 * implementation also does not guarantee fairness. The order of the threads 
 * obtaining the lock is not guaranteed.
 * 
 */
public class SimpleReentrantLock implements Lock {

	private int lockCounter = 0;
	private String lockedThread = null;

	private AtomicBoolean locked = new AtomicBoolean(false);

	@Override
	public void lock() {
		synchronized(this){
			while(locked.get() && !Thread.currentThread().getName().equals(lockedThread)){
				try {
					wait();
				} catch (InterruptedException e) {}
			}

			locked.set(true);
			lockedThread = Thread.currentThread().getName();
			lockCounter++;
			System.out.println("Lock Obtained by: " + Thread.currentThread().getName());
		}
	}

	@Override
	public void unlock() {
		if(locked.get() && Thread.currentThread().getName().equals(lockedThread)){
			synchronized(this){
				lockCounter--;
				if(lockCounter == 0){
					locked.set(false);
					System.out.println("Lock released by: " + Thread.currentThread().getName());
					notifyAll();
				}
			}
		}
	}
}
