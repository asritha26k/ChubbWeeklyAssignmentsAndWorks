package com.app.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SimpleApiSimulation {
    private static String simulateUserDetail(String userId) {
        sleepRandom();
        return "User[ID=" + userId + ", Name=Asritha, Location=VIT]";
    }
    private static String simulateOrderHistory(String userId) {
        sleepRandom();
        return "Orders[Total=5, Recent=Laptop]";
    }
    private static void sleepRandom() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(200, 600));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        String userId = "A-101";
        Callable<String> userDetailTask = () -> simulateUserDetail(userId);
        Callable<String> orderHistoryTask = () -> simulateOrderHistory(userId);
        try {
            Future<String> userDetailFuture = executor.submit(userDetailTask);
            Future<String> orderHistoryFuture = executor.submit(orderHistoryTask);
            String userDetail = userDetailFuture.get();       // waits for task to complete
            String orderHistory = orderHistoryFuture.get();   // waits for task to complete
            System.out.println("--- User Summary for " + userId + " ---");
            System.out.println("Detail: " + userDetail);
            System.out.println("History: " + orderHistory);
            System.out.println("--------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
