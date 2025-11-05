package com.app.async;
import java.util.concurrent.*;
public class CompletableFutureAPI {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {}
            return "User Info Ready";
        }, executor);

        CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {}
            return "Order History Ready";
        }, executor);

        System.out.println("Main thread doing other work...");

        // Combine both results when both tasks complete
        CompletableFuture<Void> combined = userFuture.thenCombine(orderFuture, (u, o) -> {
            System.out.println(u);
            System.out.println(o);
            return null;
        });

        combined.get(); // Wait for both to complete
        executor.shutdown();
    }
}
