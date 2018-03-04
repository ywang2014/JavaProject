package com.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) {
		SemaphoreDemo taskManager = new SemaphoreDemo();
		taskManager.execute();
	}
	
	public void execute() {
		final Semaphore sema = new Semaphore(3);
		// use the thread pool to improve the performance
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// 100 tasks
		for (int i = 0; i < 100; i++) {
			threadPool.execute(new Task(sema, "Process+"+i));
		}
		threadPool.shutdown();
	}
	
	class Task implements Runnable {
		private Semaphore semaphore;
		private String progressName;
		
		public void run() {
			try {
				// get semaphore then come in critical zone
				semaphore.acquire();
				System.out.println("The progress: " + progressName + " get the semaphore.");
				Thread.sleep(Math.round(1.0) * 100);
				System.out.println("The progress: " + progressName + " has done its work.");
				semaphore.release();
				System.out.println("The progress: " + progressName + " is over.");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public Task(Semaphore semaphore, String progressName) {
			this.semaphore = semaphore;
			this.progressName = progressName;
		}

		public Semaphore getSemaphore() {
			return semaphore;
		}

		public void setSemaphore(Semaphore semaphore) {
			this.semaphore = semaphore;
		}

		public String getProgressName() {
			return progressName;
		}

		public void setProgressName(String progressName) {
			this.progressName = progressName;
		}
	}
}
