package com.chubb.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		Worker worker1 = new Worker();
//		
//		//worker1.start(); //if we use run() instead of start() it will behave like a normal method call and will not create a new thread
//		
//		//executor service is an interface that provides a way to manage a pool of threads
//		//it is part of the java.util.concurrent package
//		//it has number of static methods to create different types of executor services
//		ExecutorService service = Executors.newFixedThreadPool(3);
//		//here no new keyword  because Executors is a factory class that provides static methods to create executor service instances
//		service.execute(worker1); //this doesn't terminate like normal program so we need to shutdown the executor service
//		//threads will be created only when there is a task to execute, its replacing usage of start method
//		//advantage: lazy thread creation, better resource management, code management
//		service.execute(worker1);
//		service.shutdown(); //this will not terminate the running threads but will not accept any new tasks
//		//no matter how many threads 1 shutdown is called, it will only shutdown once all the tasks are completed
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new Worker());
		service.execute(new Worker());
		service.execute(new Worker());
		service.shutdown();
				
		
		
		
		
		

	}

}
