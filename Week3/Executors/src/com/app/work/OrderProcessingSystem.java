package com.app.work;

import java.util.Queue;
import java.util.concurrent.*;

public class OrderProcessingSystem {

    public static void main(String[] args) {
        Queue<Order> orderQueue = new ConcurrentLinkedQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Producer: simulate incoming orders
        executor.submit(() -> {
            for (int i = 1; i <= 100; i++) {
                orderQueue.add(new Order("Order-" + i));
                System.out.println("Added: Order-" + i);
                try {
                    Thread.sleep(50); // simulate delay between orders
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Consumers: process orders concurrently
        for (int i = 0; i < 4; i++) {
            executor.submit(() -> {
                while (true) {
                    Order order = orderQueue.poll();
                    if (order != null) processOrder(order);
                }
            });
        }
    }

    static void processOrder(Order order) {
        System.out.println(Thread.currentThread().getName() + " processed " + order.getOrderId());
        try {
            Thread.sleep(100); // simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static class Order {
        private final String orderId;

        Order(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderId() {
            return orderId;
        }
    }
}
