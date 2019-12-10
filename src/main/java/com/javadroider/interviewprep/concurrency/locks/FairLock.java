package com.javadroider.interviewprep.concurrency.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Fair lock implementation makes sure that locks are given to the thread 
 * based on first come first serve (FCFS) basis. The first thread to request 
 * the lock is the first one to get. Hence it avoids the "Thread Starvation" to 
 * great extent. The performance of the lock might be little slower but your 
 * application logic demands the same then you can use this implementation
 * 
 */
public class FairLock implements Lock {

	private static final int HEAD_INDEX = 0;
	
	private String lockedThread = null;
	
	private AtomicBoolean locked = new AtomicBoolean(false);
	private List<Monitor> lockRequestRegistry = new ArrayList<>();
	
	
	@Override
	public void lock() {
		/**
		 * Create thread specific monitor object
		 */
		Monitor monitor = new Monitor();
		
		/**
		 * Register your specific monitor object to obtain lock
		 */
		synchronized(this){
			lockRequestRegistry.add(monitor);
			System.out.println("Lock requested by: " + Thread.currentThread().getName());
		}
		
		/**
		 * Wait if, 
		 * a) lock is obtained by someone else or 
		 * b) You are not the first member requested for lock
		 */
		while(locked.get() || lockRequestRegistry.get(HEAD_INDEX) != monitor){
			monitor.doWait();
		}
		
		/**
		 * If you are the right candidate,
		 * a. Set the lock to true
		 * b. Remove your monitor object from registry
		 */
		synchronized(this){
			locked.set(true);
			lockedThread = Thread.currentThread().getName();
			lockRequestRegistry.remove(HEAD_INDEX);
			System.out.println("Lock obtained by: " + Thread.currentThread().getName());
		}
	}

	@Override
	public void unlock() {
		if(locked.get() && Thread.currentThread().getName().equals(lockedThread)){
			synchronized(this){
				locked.set(false);
				System.out.println("Lock released by: " + Thread.currentThread().getName());
				if(!lockRequestRegistry.isEmpty()){
					lockRequestRegistry.get(HEAD_INDEX).doNotify();
				}
			}
		}
	}
}
