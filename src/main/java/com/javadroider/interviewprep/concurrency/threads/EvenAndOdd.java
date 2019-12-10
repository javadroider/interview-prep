/**
 * 
 */
package com.javadroider.interviewprep.concurrency.threads;


public class EvenAndOdd {

	public static void main(String[] args) {

		SharedData data = new SharedData();
		new Thread(new T1(data)).start();
		new Thread(new T2(data)).start();
	}
	
	private static class SharedData {
		public int status = 1;
		public int n = 0;
	}

	private static class T1 implements Runnable {
		private SharedData data;

		public T1(SharedData data) {
			this.data = data;
		}

		@Override
		public void run() {

			synchronized (data) {

				while (true) {

					while (data.status != 1) {
						try {
							data.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(data.n++);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					data.status = 2;
					data.notifyAll();
				}
			}
		}
	}

	private static class T2 implements Runnable {
		private SharedData data;

		public T2(SharedData data) {
			this.data = data;
		}

		@Override
		public void run() {

			synchronized (data) {

				while (true) {

					while (data.status != 2) {
						try {
							data.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(data.n++);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					data.status = 1;
					data.notifyAll();
				}
			}
		}
	}

}

