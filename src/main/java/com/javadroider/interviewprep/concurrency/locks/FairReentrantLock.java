package com.javadroider.interviewprep.concurrency.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Fair reentrant lock is the extended version of {@link FairLock} and supports the multiple request from the thread which holds the lock currently. The advantage of reentrant lock is you can use the same lock in different parts of the code without worrying a dead lock.
 * 
 */
public class FairReentrantLock implements Lock {

	private static final int HEAD_INDEX = 0;

	private String lockedThread = null;

	private AtomicInteger lockCounter = new AtomicInteger(0);
	private AtomicBoolean locked = new AtomicBoolean(false);
	private List<Monitor> lockRequestRegistry = new ArrayList<>();

	@Override
	public void lock() {

		if (Thread.currentThread().getName().equals(lockedThread)) {
			lockCounter.incrementAndGet();
			System.out.println("Lock obtained by: " + Thread.currentThread().getName());
			return;
		}
		/**
		 * Create thread specific monitor object
		 */
		Monitor monitor = new Monitor();

		/**
		 * Register your specific monitor object to obtain lock
		 */
		synchronized (this) {
			lockRequestRegistry.add(monitor);
			System.out.println("Lock requested by: " + Thread.currentThread().getName());
		}

		/**
		 * Wait if, a) lock is obtained by someone else or b) You are not the first member requested for lock
		 */
		while (locked.get() || lockRequestRegistry.get(HEAD_INDEX) != monitor) {
			monitor.doWait();
		}

		/**
		 * If you are the right candidate, a. Set the lock to true b. Remove your monitor object from registry
		 */
		synchronized (this) {
			locked.set(true);
			lockedThread = Thread.currentThread().getName();
			lockRequestRegistry.remove(HEAD_INDEX);
			lockCounter.incrementAndGet();
			System.out.println("Lock obtained by: " + Thread.currentThread().getName());
		}
	}

	@Override
	public void unlock() {
		if (locked.get() && Thread.currentThread().getName().equals(lockedThread)) {
			synchronized (this) {
				lockCounter.decrementAndGet();
				if (lockCounter.get() == 0) {
					locked.set(false);
					lockedThread = null;
					System.out.println("Lock released by: " + Thread.currentThread().getName());
					if (!lockRequestRegistry.isEmpty()) {
						lockRequestRegistry.get(HEAD_INDEX).doNotify();
					}
				}
			}
		}
	}
}
