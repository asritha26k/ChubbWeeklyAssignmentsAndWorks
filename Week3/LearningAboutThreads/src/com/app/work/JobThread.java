package com.app.work;

public class JobThread extends Thread {
	
	//FileReadOperations fro = new FileReadOperations();
	public JobThread(String name) {
		super(name);
	}
 public void run() {
	 System.out.println("Job Thread is running...");
	 System.out.println(isAlive());
 }
}
