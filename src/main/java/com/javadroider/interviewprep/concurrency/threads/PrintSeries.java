/**
 * 
 */
package com.javadroider.interviewprep.concurrency.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 2 Threads Printing numbers in sequence
 *
 */
public class PrintSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object lock = new Object();
		AtomicInteger counter = new AtomicInteger(1);
		Thread t1 = new Thread(new Printer(0, lock, counter, 2));
		Thread t2 = new Thread(new Printer(1, lock, counter, 2));
		t1.start();
		t2.start();
	}

	public static class Printer implements Runnable {

		private Object lock;
		private int threadId;
		private AtomicInteger counter;
		private int numberOfThreads;

		public Printer(int threadId, Object lock, AtomicInteger counter, int numberOfThreads) {
			this.lock = lock;
			this.threadId = threadId;
			this.counter = counter;
			this.numberOfThreads = numberOfThreads;
		}

		@Override
		public void run() {

			while (true) {

				synchronized (lock) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					while ((counter.get() % numberOfThreads) == threadId) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					System.out.println("T" + (threadId+1) + ":" + counter);
					counter.getAndIncrement();
					lock.notifyAll();
				}

			}
		}
	}

}
