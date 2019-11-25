package com.javadroider.interviewprep.threads.locks; 

import java.util.concurrent.atomic.AtomicBoolean;
/**
 * <p>
 * Simple lock implementation based on synchronized block.
 * Order of the threads obtaining the lock is not guaranteed.
 * In some situation it might lead to thread starvation.
 * </p>
 * <p>
 * This implementation does not provide reentrent locking
 * mechanism.
 * </p>
 * 
 */
public class SimpleLock implements Lock{

	private String lockedThread = null;
	
	private AtomicBoolean locked = new AtomicBoolean(false);
	
	@Override
	public void lock() {
		
		synchronized(this){
			
			while(locked.get()){
				try {
					wait();
				} catch (InterruptedException e) {}
			}
			
			locked.set(true);
			lockedThread = Thread.currentThread().getName();
			System.out.println("Lock Obtained by: " + Thread.currentThread().getName());
		}
		
	}

	@Override
	public void unlock() {
		if(locked.get() && Thread.currentThread().getName().equals(lockedThread)){
			synchronized(this){
				locked.set(false);
				System.out.println("Lock released by: " + Thread.currentThread().getName());
				notifyAll();
			}
		}
	}
	
}
