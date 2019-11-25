package com.javadroider.interviewprep.threads.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

//http://www.javacreed.com/java-fork-join-example/

public class ListFiles extends RecursiveTask<List<String>> {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();
		ListFiles fp = new ListFiles("D:/Work/softwares");
		pool.execute(fp);

		do {
			System.out.printf("******************************************\n");
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			System.out.printf("******************************************\n");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!fp.isDone());

		pool.shutdown();
		List<String> results = fp.join();
		long end = System.currentTimeMillis();
		System.out.println(results.size());
		System.out.println((end - start) / 1000);
		// System.out.println(results);
	}

	private String path;

	public ListFiles(String path) {
		this.path = path;
	}

	@Override
	protected List<String> compute() {
		List<ListFiles> tasks = new ArrayList<ListFiles>();
		List<String> filePaths = new ArrayList<String>();
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (null != files) {
				for (File tempFile : files) {
					if (tempFile.isDirectory()) {
						ListFiles fp = new ListFiles(tempFile.getAbsolutePath());
						fp.fork();
						tasks.add(fp);
					} else {
						filePaths.add(tempFile.getAbsolutePath());
					}
				}
			}
		}

		for (ListFiles fp : tasks) {
			filePaths.addAll(fp.join());
		}
		return filePaths;
	}

}
