package com.app.starter;

public class DemoUtility {

    public static void executeDemo() {
        int x = 10;
        int y = 5;
        int sum = x + y;
        System.out.println("Utility calculation complete.");
        System.out.println("The sum is: " + sum);
    }

    public static void main(String[] args) {
        System.out.println("Running DemoUtility independently for testing.");
        executeDemo();
    }
}
