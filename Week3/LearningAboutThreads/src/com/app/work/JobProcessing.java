package com.app.work;

public class JobProcessing {

	public static void main(String[] args) {
		JobThread jobThread = new JobThread("asritha");
		jobThread.start();
		System.out.println("thread details "+jobThread.getId());
		System.out.println("thread details "+jobThread.getName());
		System.out.println("thread details "+jobThread.getPriority());
		System.out.println("thread details "+jobThread.getState());
		
		
		WorkerThread worker = new WorkerThread();
		Thread workerThread = new Thread(worker);
		workerThread.start();
	}

}
