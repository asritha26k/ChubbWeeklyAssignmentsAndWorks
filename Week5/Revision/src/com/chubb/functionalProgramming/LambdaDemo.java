package com.chubb.functionalProgramming;

public class LambdaDemo {

	public static void main(String[] args) {
		//interfaces are datatypes
		//lambda expressions can be used to provide the implementation of the abstract method of a functional
		Greet greet = (name)->{
			System.out.println("Hello, " + name);
		};
		greet.sayHello("Asritha");

	}

}
