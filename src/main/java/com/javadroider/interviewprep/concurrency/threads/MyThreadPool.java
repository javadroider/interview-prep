package com.javadroider.interviewprep.concurrency.threads;

import java.util.LinkedList;
import java.util.Queue;

public class MyThreadPool {

	BlockingQueue<Runnable> queue;

	public MyThreadPool(int queueSize, int nThread) {
		queue = new BlockingQueue<>(queueSize);
		String threadName = null;
		TaskExecutor task = null;
		for (int count = 0; count < nThread; count++) {
			threadName = "Thread-" + count;
			task = new TaskExecutor(queue);
			Thread thread = new Thread(task, threadName);
			thread.start();
		}
	}

	public void submitTask(Runnable task) throws InterruptedException {
		queue.enqueue(task);
	}

	public class BlockingQueue<Type> {
		private Queue<Type> queue = new LinkedList<Type>();
		private int EMPTY = 0;
		private int MAX_TASK_IN_QUEUE = -1;

		public BlockingQueue(int size) {
			this.MAX_TASK_IN_QUEUE = size;
		}

		public synchronized void enqueue(Type task) throws InterruptedException {
			while (this.queue.size() == this.MAX_TASK_IN_QUEUE) {
				wait();
			}
			if (this.queue.size() == EMPTY) {
				notifyAll();
			}
			this.queue.offer(task);
		}

		public synchronized Type dequeue() throws InterruptedException {
			while (this.queue.size() == EMPTY) {
				wait();
			}
			if (this.queue.size() == this.MAX_TASK_IN_QUEUE) {
				notifyAll();
			}
			return this.queue.poll();
		}
	}

	public class TaskExecutor implements Runnable {
		BlockingQueue<Runnable> queue;

		public TaskExecutor(BlockingQueue<Runnable> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				while (true) {
					String name = Thread.currentThread().getName();
					Runnable task = queue.dequeue();
					System.out.println("Task Started by Thread :" + name);
					task.run();
					System.out.println("Task Finished by Thread :" + name);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}