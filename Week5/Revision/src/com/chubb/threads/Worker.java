package com.chubb.threads;

public class Worker extends Thread {
	public void run() {
		try {
            Thread.sleep(2000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println("Worker thread is running: " + Thread.currentThread().getName());
	}

}
