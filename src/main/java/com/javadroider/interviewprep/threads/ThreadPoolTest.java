package com.javadroider.interviewprep.threads;

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {

		MyThreadPool threadPool = new MyThreadPool(3, 4);
		// Created 15 Tasks and submit to pool
		for (int taskNumber = 1; taskNumber <= 7; taskNumber++) {
			TestTask task = new TestTask(taskNumber);
			threadPool.submitTask(task);
		}
	}

	public static class TestTask implements Runnable {
		private int number;

		public TestTask(int number) {
			this.number = number;
		}

		@Override
		public void run() {
			System.out.println("Start executing of task number :" + number);
			try {
				// Simulating processing time
				// perform tasks
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("End executing of task number :" + number);
		}
	}
}
