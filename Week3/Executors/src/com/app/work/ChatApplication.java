package com.app.work;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChatApplication {
    public static void main(String[] args) throws InterruptedException {
        MessageBroker broker = new MessageBroker();
        broker.createRoom("Sports");
        broker.createRoom("Movies");

        // Create users
        Thread u1 = new Thread(new User("Alice", broker, "Sports"));
        Thread u2 = new Thread(new User("Bob", broker, "Movies"));
        Thread u3 = new Thread(new User("Charlie", broker, "Sports"));
        Thread u4 = new Thread(new User("Diana", broker, "Movies"));

        // Start all users
        u1.start(); u2.start(); u3.start(); u4.start();

        // Real-time message display (every 1 second)
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            for (ChatRoom room : broker.getAllRooms()) {
                List<Message> newMsgs = room.drainMessages();
                for (Message msg : newMsgs) {
                    System.out.println(msg);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);

        // Wait for users to finish
        u1.join(); u2.join(); u3.join(); u4.join();

        // Stop after all users done
        Thread.sleep(2000);
        scheduler.shutdown();
        System.out.println("\n=== Chat ended ===");
    }
}

