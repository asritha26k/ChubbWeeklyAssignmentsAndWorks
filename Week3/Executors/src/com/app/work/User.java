package com.app.work;

import java.util.Random;

class User implements Runnable {
    private final String name;
    private final MessageBroker broker;
    private final String room;

    public User(String name, MessageBroker broker, String room) {
        this.name = name;
        this.broker = broker;
        this.room = room;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            String content = "Message " + i + " from " + name;
            broker.sendMessage(room, name, content);
            try { Thread.sleep(400 + new Random().nextInt(400)); } catch (InterruptedException ignored) {}
        }
    }
}
